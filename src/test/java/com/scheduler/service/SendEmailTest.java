package com.scheduler.service;

import com.scheduler.adapters.EmailApi;
import com.scheduler.util.EmailDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.ActiveProfiles;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
@ActiveProfiles("test")
public class SendEmailTest {

    @Mock
    private EmailApi emailApi;

    @InjectMocks
    private SendEmail sendEmail;

    @Test
    void shouldSendEmail() {
        EmailDto email = EmailDto.builder()
                .from("test@domain.com")
                .body("body")
                .subject("subject")
                .to("someone@domain.com")
                .build();

        sendEmail.sendEmail(email);

        verify(emailApi, times(1)).sendEmail(email);
    }
}