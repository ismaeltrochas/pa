package com.fastlearn.notification.application;

import com.fastlearn.notification.application.notifications.mapper.NotificationDTOMapper;
import com.fastlearn.notification.application.notifications.service.SendNotificationManagementService;
import com.fastlearn.notification.domain.ports.SendNotificationUserPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanModuleApplication {

    @Bean
    public SendNotificationManagementService sendNotificationService(
            SendNotificationUserPort sendNotificationUserPort,
            NotificationDTOMapper notificationDTOMapper) {
        return new SendNotificationManagementService(sendNotificationUserPort, notificationDTOMapper);
    }
}
