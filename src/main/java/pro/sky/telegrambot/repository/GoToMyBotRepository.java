package pro.sky.telegrambot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pro.sky.telegrambot.model.GoToMyBot;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface GoToMyBotRepository extends JpaRepository<GoToMyBot, Long> {
    List<GoToMyBot> findAllByDateTime(LocalDateTime localDateTime);
}
