package com.example.myapp.service;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitMessagingTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class MessageSender {
    public static final String SEARCH_QUEUE_NAME = "SearchQ";

    @Autowired
    RabbitMessagingTemplate template;

    @Bean
    Queue queue() {
        return new Queue(SEARCH_QUEUE_NAME, false);
    }

    public void send(Object message) {
        template.convertAndSend(SEARCH_QUEUE_NAME, message);
    }
}
