package com.example.demo.adapter.web;

import com.example.demo.usecase.ProcessWebhookUseCase;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.mockito.Mockito.doNothing;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(WebhookController.class)
public class WebhookControllerTest {

    @MockBean
    private ProcessWebhookUseCase processWebhookUseCase;

    private MockMvc mockMvc;


    public WebhookControllerTest(WebApplicationContext context) {
        MockitoAnnotations.openMocks(this);
        this.mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void testHandleWebhook() throws Exception {
        String payload = "test payload";

        // Mock the use case execution
        doNothing().when(processWebhookUseCase).execute(payload);

        mockMvc.perform(post("/webhooks/subscribe")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payload))
                .andExpect(status().isOk());
    }
}
