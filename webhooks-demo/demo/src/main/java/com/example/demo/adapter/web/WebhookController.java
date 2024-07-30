package com.example.demo.adapter.web;

import com.example.demo.usecase.ProcessWebhookUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("webhooks")
@RequiredArgsConstructor
public class WebhookController {

    private final ProcessWebhookUseCase processWebhookUseCase;
    @PostMapping("/subscribe")
    public ResponseEntity handleSubscribe(@RequestBody String payload) {
        // Process the subscription event
        System.out.println("Received subscription event: " + payload);


        processWebhookUseCase.execute(payload);

        // Perform necessary actions (e.g., update database, send notifications)
        return new ResponseEntity<>("Webhook received successfully", HttpStatus.OK);

    }
}
