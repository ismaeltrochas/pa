package com.fastlearn.notification.infrastructure.jpa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "notifications")
@Entity
public class NotificationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String text;
    private String sender;
    private String subject;
    private String receiver;
    private LocalDateTime createdAt;
    private boolean readStatus;

}
