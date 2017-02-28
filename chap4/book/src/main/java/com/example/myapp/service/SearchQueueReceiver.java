package com.example.myapp.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class SearchQueueReceiver {
    public static final String QUEUE = "SearchQ";

    @RabbitListener(queues = QUEUE)
    public void processMessage(Object message) {
        String me = "processMessage()";
        System.out.println(me + " Received message [" + message + "]");
    }
}
