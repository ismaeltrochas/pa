package com.fastlearn.notification.infrastructure.rest;

import com.fastlearn.notification.infrastructure.jpa.adapter.EmailSenderAdapter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class SendNotificationController {

    private final EmailSenderAdapter emailSenderAdapter;

}
