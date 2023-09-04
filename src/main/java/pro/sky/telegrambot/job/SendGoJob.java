package pro.sky.telegrambot.job;

import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import pro.sky.telegrambot.repository.GoToMyBotRepository;
import pro.sky.telegrambot.service.TelegramSenderService;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

@Component
public class SendGoJob {

    private final Logger logger = (Logger) LoggerFactory.getLogger(SendGoJob.class);

    private final GoToMyBotRepository goToMyBotRepository;
    private final TelegramSenderService telegramSenderService;

    public SendGoJob(GoToMyBotRepository goToMyBotRepository, TelegramSenderService telegramSenderService) {
        this.goToMyBotRepository = goToMyBotRepository;
        this.telegramSenderService = telegramSenderService;
    }

    @Scheduled(timeUnit = TimeUnit.MINUTES, fixedRate = 1)
    public void sendGo(){
        LocalDateTime currentDateTime =  LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES);
        logger.info("Job started for dateTime = " + currentDateTime);

        goToMyBotRepository.findAllByDateTime(currentDateTime).forEach(task -> {
            telegramSenderService.send(task.getChatId(), "Напоминание! " +  task.getMessage());
            logger.info("Reminder for task with id = {} has been sent!");
        });

        logger.info("Job started finished for dateTime = " + currentDateTime);
    }
}
