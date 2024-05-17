package com.fastlearn.notification.infrastructure.rest;

import com.fastlearn.notification.infrastructure.jpa.adapter.EmailSenderAdapter;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class SendNotificationController {

    private final EmailSenderAdapter emailSenderAdapter;

    @KafkaListener(topics = "course-topic")
    public void sendEmail() throws MessagingException {
    }
}
