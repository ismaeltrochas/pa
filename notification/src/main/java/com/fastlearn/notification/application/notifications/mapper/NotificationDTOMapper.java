package com.fastlearn.notification.application.notifications.mapper;

import com.fastlearn.notification.domain.model.Notification;
import com.fastlearn.notification.domain.model.dto.NotificationDTO;
import com.fastlearn.notification.share.mapper.EntityToDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface NotificationDTOMapper extends EntityToDto<Notification, NotificationDTO> {

}
