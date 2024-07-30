package com.example.demo.adapter.service;


import com.example.demo.domain.model.Notification;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotificationService {

    @Value("${slack.webhook.url}")
    private String slackWebhookUrl;

    @Value("${email.to}")
    private String toEmail;

    private final JavaMailSender javaMailSender;


    @Async("emailTaskExecutor")
    public void sendEmailNotification(Notification notification) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(toEmail);
        mailMessage.setSubject("Webhook Event Notification");
        mailMessage.setText(notification.getMessage());
        javaMailSender.send(mailMessage);
    }
}