package com.example.demo.adapter.service;

import com.example.demo.domain.model.Notification;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.internal.verification.VerificationModeFactory.times;

@ExtendWith(MockitoExtension.class)
public class NotificationServiceTest {
    @Mock
    private JavaMailSender javaMailSender;

    @InjectMocks
    private NotificationService notificationService;

    @Test
    public void testSendEmailNotification() {
        Notification notification = new Notification("Test email message");

        // Mock the send method
        doNothing().when(javaMailSender).send(any(SimpleMailMessage.class));

        notificationService.sendEmailNotification(notification);

        // Verify that the send method was called
        verify(javaMailSender, times(1)).send(any(SimpleMailMessage.class));
    }
}
