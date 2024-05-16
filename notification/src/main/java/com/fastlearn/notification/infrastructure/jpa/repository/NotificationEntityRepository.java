package com.fastlearn.notification.infrastructure.jpa.repository;

import com.fastlearn.notification.infrastructure.jpa.entity.NotificationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotificationEntityRepository extends JpaRepository<NotificationEntity, String> {

    List<NotificationEntity> findByTo(String to);
}
