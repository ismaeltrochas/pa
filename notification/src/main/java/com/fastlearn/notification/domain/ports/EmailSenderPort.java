package com.fastlearn.notification.domain.ports;

import jakarta.mail.MessagingException;

public interface EmailSenderPort {

    void sendEmail(String to, String subject, String text) throws MessagingException;
}
