package com.scheduler.scheduler;

import com.scheduler.config.ProjectProperties;
import com.scheduler.service.SendEmail;
import com.scheduler.util.EmailDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
@ActiveProfiles("test")
class SendEmailSchedulerTest {

    @MockBean
    private ProjectProperties projectProperties;

    @MockBean
    private SendEmail sendEmail;

    @Autowired
    private SendEmailScheduler scheduler;

    @Test
    void shouldCallSendEmailSuccessfully() {
        // Mock dos valores das propriedades
        when(projectProperties.getProperty("email-service.from")).thenReturn("from@example.com");
        when(projectProperties.getProperty("email-service.to")).thenReturn("to@example.com");

        EmailDto emailDto = EmailDto.builder()
                .from("from@example.com")
                .to("to@example.com")
                .build();

        when(sendEmail.sendEmail(any())).thenReturn(emailDto);

        scheduler.schedulerSendEmail();

        verify(sendEmail, times(1)).sendEmail(any());
    }

    @Test
    void testGetEmailFrom() {
        String emailFrom = scheduler.getEmailFrom();

        assertEquals(null, emailFrom);
    }

    @Test
    void testGetEmailTo() {
        String emailTo = scheduler.getEmailTo();

        assertEquals(null, emailTo);
    }

}
