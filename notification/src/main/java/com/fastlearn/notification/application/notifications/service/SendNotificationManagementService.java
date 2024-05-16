package com.fastlearn.notification.application.notifications.service;

import com.fastlearn.notification.application.notifications.mapper.NotificationDTOMapper;
import com.fastlearn.notification.application.notifications.usecase.SendNotificationUseCase;
import com.fastlearn.notification.domain.model.dto.NotificationDTO;
import com.fastlearn.notification.domain.ports.SendNotificationUserPort;
import jakarta.mail.MessagingException;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SendNotificationManagementService implements SendNotificationUseCase {

    private final SendNotificationUserPort sendNotificationUserPort;
    private final NotificationDTOMapper notificationDTOMapper;

    @Override
    public NotificationDTO sendNotification(NotificationDTO notificationDTO) throws MessagingException {
        return notificationDTOMapper.toDTO(
                sendNotificationUserPort.sendNotification(
                        notificationDTOMapper.toEntity(notificationDTO)));
    }
}
