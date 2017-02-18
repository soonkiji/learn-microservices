package com.example;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitMessagingTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class QueueSender {

    @Autowired
    RabbitMessagingTemplate template;

    @Bean
    Queue queue() {
        return new Queue(QueueReceiver.QUEUE_NAME, false);
    }

    public void send(String message) {
        template.convertAndSend(QueueReceiver.QUEUE_NAME, message);
    }
}
