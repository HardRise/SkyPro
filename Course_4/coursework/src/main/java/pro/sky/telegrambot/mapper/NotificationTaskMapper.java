package pro.sky.telegrambot.mapper;

import org.springframework.stereotype.Component;
import pro.sky.telegrambot.dto.NotificationTaskDtoIn;
import pro.sky.telegrambot.dto.NotificationTaskDtoOut;
import pro.sky.telegrambot.enities.NotificationTask;

@Component
public class NotificationTaskMapper {
    public NotificationTaskDtoOut toDto(NotificationTask notificationTask) {
        NotificationTaskDtoOut taskDtoOut = new NotificationTaskDtoOut();
        taskDtoOut.setDateOfTask(notificationTask.getDateOfTask());
        taskDtoOut.setTextOfMessage(notificationTask.getTextOfMessage());
        return taskDtoOut;
    }

    public NotificationTask toEntity(NotificationTaskDtoIn taskDtoIn) {
        NotificationTask taskEntity = new NotificationTask();
        taskEntity.setChatId(taskDtoIn.getChatId());
        taskEntity.setTextOfMessage(taskDtoIn.getTextOfMessage());
        taskEntity.setDateOfTask(taskDtoIn.getDateOfTask());
        return taskEntity;
    }
}
