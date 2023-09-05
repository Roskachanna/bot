package pro.sky.telegrambot.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "go_to_my_bot")
public class GoToMyBot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String message;
    private long chatId;
    private LocalDateTime dateTime;
    public GoToMyBot(String message, long chatId, LocalDateTime dateTime) {
        this.message = message;
        this.chatId = chatId;
        this.dateTime = dateTime;
    }
    public GoToMyBot() {

    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getChatId() {
        return chatId;
    }

    public void setChatId(long chatId) {
        this.chatId = chatId;
    }

    public LocalDateTime getDataTime() {
        return dateTime;
    }

    public void setDataTime(LocalDateTime dataTime) {
        this.dateTime = dataTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GoToMyBot goToMyBot = (GoToMyBot) o;
        return chatId == goToMyBot.chatId && Objects.equals(id, goToMyBot.id) && Objects.equals(message, goToMyBot.message) && Objects.equals(dateTime, goToMyBot.dateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, message, chatId, dateTime);
    }

    @Override
    public String toString() {
        return "GoToMyBot{" +
                "id=" + id +
                ", message='" + message + '\'' +
                ", chatId=" + chatId +
                ", dataTime=" + dateTime +
                '}';
    }
}
