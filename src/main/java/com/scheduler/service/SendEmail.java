package com.scheduler.service;

import com.scheduler.adapters.EmailApi;
import com.scheduler.util.EmailDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class SendEmail {

    private static final Logger LOGGER = LoggerFactory.getLogger(SendEmail.class);

    private final EmailApi emailApi;


    public SendEmail(EmailApi emailApi) {
        this.emailApi = emailApi;
    }

    public EmailDto sendEmail(final EmailDto emailDto) {
        LOGGER.info("Sending scheduled email");
        emailApi.sendEmail(emailDto);
        LOGGER.info("Email scheduled sent");
        return emailDto;
    }

}
