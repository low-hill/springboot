package com.example.demo.usecase;

import com.example.demo.adapter.service.NotificationService;
import com.example.demo.domain.model.Notification;
import com.example.demo.domain.model.WebhookPayload;
import com.example.demo.domain.repository.WebhookPayloadRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProcessWebhookUseCase {
    private final WebhookPayloadRepository webhookPayloadRepository;
    private final NotificationService notificationService;

    public void execute(String payload) {
        // 페이로드를 저장합니다.
        WebhookPayload webhookPayload = new WebhookPayload(generateId(), payload, "PROCESSING");
        webhookPayloadRepository.save(webhookPayload);

        // 웹훅 비즈니스 로직 처리
        System.out.println("Processing webhook payload: " + payload);
        try {
            Thread.sleep(5000); // 예시로 5초 대기
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        // 페이로드 상태를 업데이트합니다.
        webhookPayload.setStatus("PROCESSED");
        webhookPayloadRepository.save(webhookPayload);

        // 이메일 전송을 비동기로 처리합니다.
        Notification notification = new Notification("Finished processing webhook payload: " + payload);
        sendEmailNotification(notification);
    }

    private String generateId() {
        // ID 생성 로직 (예시: UUID)
        return java.util.UUID.randomUUID().toString();
    }

    private void sendEmailNotification(Notification notification) {
        // 이메일 전송을 비동기로 처리합니다.
        notificationService.sendEmailNotification(notification);
    }
}
