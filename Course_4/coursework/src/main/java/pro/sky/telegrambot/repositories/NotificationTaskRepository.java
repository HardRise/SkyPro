package pro.sky.telegrambot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pro.sky.telegrambot.enities.NotificationTask;

import java.time.LocalDateTime;

public interface NotificationTaskRepository extends JpaRepository<NotificationTask, Long> {
    public NotificationTask getByDateOfTask(LocalDateTime dateOfTask);
}
