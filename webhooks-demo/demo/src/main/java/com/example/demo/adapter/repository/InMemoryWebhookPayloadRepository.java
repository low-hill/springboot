package com.example.demo.adapter.repository;

import com.example.demo.domain.model.WebhookPayload;
import com.example.demo.domain.repository.WebhookPayloadRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
public class InMemoryWebhookPayloadRepository implements WebhookPayloadRepository {

    private final Map<String, WebhookPayload> storage = new HashMap<>();

    @Override
    public void save(WebhookPayload webhookPayload) {
        storage.put(webhookPayload.getId(), webhookPayload);
    }

    @Override
    public Optional<WebhookPayload> findById(String id) {
        return Optional.ofNullable(storage.get(id));
    }
}
