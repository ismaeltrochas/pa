package com.fastlearn.notification.domain.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@NoArgsConstructor
@Setter
public class NotificationDTO {

    private String text;
    private String from;
    private String subject;
    private String to;
    private LocalDateTime createdAt;
    private boolean readStatus;

}
