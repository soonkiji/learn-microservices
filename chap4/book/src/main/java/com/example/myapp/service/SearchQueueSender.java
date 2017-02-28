package com.example.myapp.service;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitMessagingTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class SearchQueueSender {
    @Autowired
    RabbitMessagingTemplate template;

    @Bean
    Queue queue() {
        return new Queue(SearchQueueReceiver.QUEUE, false);
    }

    public void send(Object message) {
        template.convertAndSend(SearchQueueReceiver.QUEUE, message);
    }
}
