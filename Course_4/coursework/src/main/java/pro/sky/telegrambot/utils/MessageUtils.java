package pro.sky.telegrambot.utils;

import com.pengrad.telegrambot.request.SendMessage;
import org.springframework.stereotype.Component;
import pro.sky.telegrambot.dto.NotificationTaskDtoIn;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class MessageUtils {
    public SendMessage sendMessage(Long chatId, String text) {
        return new SendMessage(chatId, text);
    }

    public NotificationTaskDtoIn taskProcessing(Long chatId, String message) throws NullPointerException {
        Pattern pattern = Pattern.compile("([0-9.:\\s]{16})(\\s)([\\W+]+)");
        Matcher matcher = pattern.matcher(message);

        if (message.isBlank() || !matcher.matches()) return null;

        var date = LocalDateTime.parse(matcher.group(1), DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm"));
        var otherText = matcher.group(3);

        if (date.isBefore(LocalDateTime.now())) return null;

        NotificationTaskDtoIn notificationTaskDtoIn = new NotificationTaskDtoIn();
        notificationTaskDtoIn.setChatId(chatId.intValue());
        notificationTaskDtoIn.setTextOfMessage(otherText);
        notificationTaskDtoIn.setDateOfTask(date);

        return notificationTaskDtoIn;
    }
}
