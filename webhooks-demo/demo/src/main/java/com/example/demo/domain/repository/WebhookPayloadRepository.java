package com.example.demo.domain.repository;

import com.example.demo.domain.model.WebhookPayload;

import java.util.Optional;

public interface WebhookPayloadRepository {

    void save(WebhookPayload webhookPayload);

    Optional<WebhookPayload> findById(String id);
}
