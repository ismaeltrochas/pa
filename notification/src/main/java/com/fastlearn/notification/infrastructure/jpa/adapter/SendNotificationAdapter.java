package com.fastlearn.notification.infrastructure.jpa.adapter;

import com.fastlearn.notification.domain.model.Notification;
import com.fastlearn.notification.domain.ports.EmailSenderPort;
import com.fastlearn.notification.domain.ports.SendNotificationUserPort;
import com.fastlearn.notification.infrastructure.jpa.repository.NotificationEntityRepository;
import com.fastlearn.notification.infrastructure.jpa.repository.mapper.NotificationRepositoryMapper;
import jakarta.mail.MessagingException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SendNotificationAdapter implements SendNotificationUserPort {

    private final NotificationEntityRepository notificationEntityRepository;
    private final NotificationRepositoryMapper notificationRepositoryMapper;
    private final EmailSenderPort emailSenderPort;

    @Override
    public Notification sendNotification(Notification notification) throws MessagingException {
        emailSenderPort.sendEmail(notification.getReceiver(), notification.getSubject(), notification.getText());
        return notificationRepositoryMapper.toEntity(
                notificationEntityRepository.save(
                        notificationRepositoryMapper.toDTO(notification)));
    }
}
