package com.fastlearn.notification.infrastructure.jpa.repository.mapper;

import com.fastlearn.notification.domain.model.Notification;
import com.fastlearn.notification.infrastructure.jpa.entity.NotificationEntity;
import com.fastlearn.notification.share.mapper.EntityToDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface NotificationRepositoryMapper extends EntityToDto<Notification, NotificationEntity> {
}
