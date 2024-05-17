package com.fastlearn.notification.domain.ports;

import jakarta.mail.MessagingException;

public interface EmailSenderPort {

    public void sendEmail(String to, String subject, String text) throws MessagingException;
}
