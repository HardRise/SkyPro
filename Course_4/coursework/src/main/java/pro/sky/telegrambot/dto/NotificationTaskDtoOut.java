package pro.sky.telegrambot.dto;

import java.time.LocalDateTime;

public class NotificationTaskDtoOut {
    private String textOfMessage;
    private LocalDateTime dateOfTask;

    public NotificationTaskDtoOut(String textOfMessage, LocalDateTime dateOfTask) {
        this.textOfMessage = textOfMessage;
        this.dateOfTask = dateOfTask;
    }

    public NotificationTaskDtoOut() {
    }

    public String getTextOfMessage() {
        return textOfMessage;
    }

    public void setTextOfMessage(String textOfMessage) {
        this.textOfMessage = textOfMessage;
    }

    public LocalDateTime getDateOfTask() {
        return dateOfTask;
    }

    public void setDateOfTask(LocalDateTime dateOfTask) {
        this.dateOfTask = dateOfTask;
    }

    @Override
    public String toString() {
        return dateOfTask + " " + textOfMessage;
    }
}
