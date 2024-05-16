package com.fastlearn.notification.infrastructure.jpa.adapter;

import com.fastlearn.notification.domain.ports.EmailSenderPort;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import static java.nio.charset.StandardCharsets.UTF_8;
import static org.springframework.mail.javamail.MimeMessageHelper.MULTIPART_MODE_MIXED;

@RequiredArgsConstructor
@Service
public class EmailSenderAdapter implements EmailSenderPort {

    private final JavaMailSender javaMailSender;

    @Override
    public void sendEmail(String to, String subject, String text) throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(
                mimeMessage,
                MULTIPART_MODE_MIXED,
                UTF_8.name()
        );

        helper.setFrom("ismaeltrocha@gmail.com");
        helper.setTo(to);
        helper.setSubject(subject);

        helper.setText(text, false);

        javaMailSender.send(mimeMessage);
    }
}
