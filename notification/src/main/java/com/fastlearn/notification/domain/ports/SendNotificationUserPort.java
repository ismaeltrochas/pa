package com.fastlearn.notification.domain.ports;

import com.fastlearn.notification.domain.model.Notification;
import jakarta.mail.MessagingException;

public interface SendNotificationUserPort {

    Notification sendNotification(Notification notification)  throws MessagingException;
}
