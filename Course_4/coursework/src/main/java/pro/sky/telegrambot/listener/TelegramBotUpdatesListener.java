package pro.sky.telegrambot.listener;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.model.Update;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import pro.sky.telegrambot.enities.NotificationTask;
import pro.sky.telegrambot.mapper.NotificationTaskMapper;
import pro.sky.telegrambot.repositories.NotificationTaskRepository;
import pro.sky.telegrambot.utils.MessageUtils;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class TelegramBotUpdatesListener implements UpdatesListener {

    private final Logger logger = LoggerFactory.getLogger(TelegramBotUpdatesListener.class);

    private final TelegramBot telegramBot;
    private final NotificationTaskRepository taskRepository;
    private final NotificationTaskMapper taskMapper;
    private final TelegramBot bot;
    private final MessageUtils messageUtils;


    public TelegramBotUpdatesListener(TelegramBot telegramBot,
                                      NotificationTaskRepository taskRepository,
                                      NotificationTaskMapper taskMapper,
                                      TelegramBot bot, MessageUtils messageUtils) {
        this.telegramBot = telegramBot;
        this.taskRepository = taskRepository;
        this.taskMapper = taskMapper;
        this.bot = bot;
        this.messageUtils = messageUtils;
    }

    @PostConstruct
    public void init() {
        telegramBot.setUpdatesListener(this);
    }

    @Override
    public int process(List<Update> updates) {
        var pattern = Pattern.compile("([0-9.:\\s]{16})(\\s)([\\W+]+)");

        updates.forEach(update -> {
            logger.info("Processing update: {}", update);

            var message = update.message().text();
            var matcher = pattern.matcher(message);
            var chatId = update.message().chat().id();
            var pastChatId = 0L;

            if (pastChatId != update.message().chat().id()) {
                pastChatId = chatId;
                new Thread(() -> processNotificationDaemon(chatId)).start();
            }

            distributiveMessagesByCommands(chatId, matcher, message);
        });
        return UpdatesListener.CONFIRMED_UPDATES_ALL;
    }

    private void distributiveMessagesByCommands(Long chatId, Matcher matcher, String message) {
        if (message.equals("/start")) {
            processStartCommand(chatId);
        } else if (message.equals("/add")) {
            processAddCommand(chatId);
        } else if (matcher.matches()) {
            processNotificationTask(chatId, message);
        } else {
            unsupportedTypeOfText(chatId);
        }
    }

    private void processStartCommand(Long chatId) {
        bot.execute(messageUtils.sendMessage(chatId, "Hi there, It's my course work"));
    }

    private void processAddCommand(Long chatId) {
        var sendAddMessage = messageUtils.sendMessage(chatId, "Write ur task according to a certain example: 01.01.2022 20:00 Помыть посуду");
        bot.execute(sendAddMessage);
    }

    private void unsupportedTypeOfText(Long chatId) {
        logger.error("Unsupported command");
        bot.execute(messageUtils.sendMessage(chatId, "Unsupported command"));
    }

    private void processNotificationTask(Long chatId, String message) {
        var taskDtoIn = messageUtils.taskProcessing(chatId, message);
        if (taskDtoIn == null) {
            logger.error("Unsupported argument");
            return;
        }
        bot.execute(messageUtils.sendMessage(chatId, String.format(
                "Task: '%s' - is successfully added",
                taskMapper.toDto(taskRepository.save(taskMapper.toEntity(taskDtoIn))))));
    }

    public synchronized void processNotificationDaemon(Long chatId) {
        int counter = 0;
        while (true) {
            NotificationTask notificationTask = taskRepository.getByDateOfTask(LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES));
            if (notificationTask != null) {
                if (counter == 3) {
                    taskRepository.delete(notificationTask);
                    counter = 0;
                }
                bot.execute(messageUtils.sendMessage(chatId, taskMapper.toDto(notificationTask).toString()));
                counter++;
            }
            pause(10);
        }
    }


    private void pause(int time) {
        try {
            TimeUnit.SECONDS.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
