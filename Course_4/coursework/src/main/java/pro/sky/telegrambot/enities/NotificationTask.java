package pro.sky.telegrambot.enities;

import jdk.jfr.Timestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "tasks")
public class NotificationTask {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer chatId;
    private String textOfMessage;
    @Timestamp
    private LocalDateTime dateOfTask;

    public NotificationTask(Long id, Integer chatId, String textOfMessage, LocalDateTime dateOfTask) {
        this.id = id;
        this.chatId = chatId;
        this.textOfMessage = textOfMessage;
        this.dateOfTask = dateOfTask;
    }

    public NotificationTask() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NotificationTask notificationTask = (NotificationTask) o;
        return Objects.equals(notificationTask.chatId, chatId) &&
                Objects.equals(notificationTask.textOfMessage, textOfMessage) &&
                Objects.equals(notificationTask.dateOfTask, dateOfTask);
    }

    @Override
    public int hashCode() {
        return Objects.hash(chatId, textOfMessage, dateOfTask);
    }

    @Override
    public String toString() {
        return "id=" + id +
                ", chatId=" + chatId +
                ", textOfMessage='" + textOfMessage +
                ", datePushingMessage=" + dateOfTask;
    }
}
