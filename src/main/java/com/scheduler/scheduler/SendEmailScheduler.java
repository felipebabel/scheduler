package com.scheduler.scheduler;

import lombok.Getter;
import com.scheduler.config.ProjectProperties;
import com.scheduler.service.SendEmail;
import com.scheduler.util.EmailDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import net.javacrumbs.shedlock.spring.annotation.SchedulerLock;

@Component
@EnableScheduling
public class SendEmailScheduler {

    private static final Logger LOGGER = LoggerFactory.getLogger(SendEmailScheduler.class);

    @Getter
    private final ProjectProperties projectProperties;

    private final SendEmail sendEmail;

    @Autowired
    public SendEmailScheduler(ProjectProperties projectProperties, SendEmail sendEmail) {
        this.projectProperties = projectProperties;
        this.sendEmail = sendEmail;
    }

    @SchedulerLock(name = "sendEmailScheduler", lockAtMostFor = "5m", lockAtLeastFor = "2s")
    @Scheduled(cron = "${scheduler.cron-expression}")
    public void schedulerSendEmail() {
        try {
            final EmailDto emailDto = EmailDto.builder()
                    .to(this.getEmailTo())
                    .from(this.getEmailFrom())
                    .build();
            this.sendEmail.sendEmail(emailDto);
        } catch (Exception e) {
            LOGGER.error("Failed to send scheduled email", e);
        }
    }

    public String getEmailFrom() {
        return this.projectProperties.getProperty("email-service.from");
    }

    public String getEmailTo() {
        return this.projectProperties.getProperty("email-service.to");
    }

}
