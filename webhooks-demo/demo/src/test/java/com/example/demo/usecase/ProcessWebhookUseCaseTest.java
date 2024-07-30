package com.example.demo.usecase;

import com.example.demo.adapter.service.NotificationService;
import com.example.demo.domain.model.Notification;
import com.example.demo.domain.model.WebhookPayload;
import com.example.demo.domain.repository.WebhookPayloadRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ProcessWebhookUseCaseTest {
    @Mock
    private WebhookPayloadRepository webhookPayloadRepository;

    @Mock
    private NotificationService notificationService;

    @InjectMocks
    private ProcessWebhookUseCase processWebhookUseCase;

    @Test
    public void testExecute() {
        String payload = "test payload";

        // Mock the save method
        doNothing().when(webhookPayloadRepository).save(any(WebhookPayload.class));

        // Execute the use case
        processWebhookUseCase.execute(payload);

        // Verify that the repository save method was called
        verify(webhookPayloadRepository, times(2)).save(any(WebhookPayload.class));

        // Verify that the sendEmailNotification method was called
        verify(notificationService, times(1)).sendEmailNotification(any(Notification.class));
    }
}
