package pro.sky.telegrambot.dto;

import java.time.LocalDateTime;

public class NotificationTaskDtoIn {
    private Integer chatId;
    private String textOfMessage;
    private LocalDateTime dateOfTask;

    public NotificationTaskDtoIn(Integer chatId, String textOfMessage, LocalDateTime dateOfTask) {
        this.chatId = chatId;
        this.textOfMessage = textOfMessage;
        this.dateOfTask = dateOfTask;
    }

    public NotificationTaskDtoIn() {
    }

    public Integer getChatId() {
        return chatId;
    }

    public void setChatId(Integer chatId) {
        this.chatId = chatId;
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
        return "chatId=" + chatId +
                ", textOfMessage='" + textOfMessage +
                ", datePushingMessage=" + dateOfTask;
    }
}
