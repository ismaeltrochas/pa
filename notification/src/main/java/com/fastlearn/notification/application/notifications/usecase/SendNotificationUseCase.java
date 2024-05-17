package com.fastlearn.notification.application.notifications.usecase;

import com.fastlearn.notification.domain.model.dto.NotificationDTO;
import jakarta.mail.MessagingException;

public interface SendNotificationUseCase {

    NotificationDTO sendNotification(NotificationDTO notificationDTO) throws MessagingException;
}
