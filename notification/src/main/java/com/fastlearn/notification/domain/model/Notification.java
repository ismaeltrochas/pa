package com.fastlearn.notification.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Notification {

    private String id;
    private String text;
    private String sender;
    private String subject;
    private String receiver;
    private LocalDateTime createdAt;
    private boolean readStatus;
}
