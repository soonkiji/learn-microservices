package com.example.book.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class MessageReceiver {
    public static final String CHECKIN_QUEUE_NAME = "CheckINQ";

    @RabbitListener(queues = CHECKIN_QUEUE_NAME)
    public void onMessage(Object message) {
        String me = "onMessage()";
        System.out.println(me + " Received check-in message [" + message + "]");
        // TODO Update booking status with 'Checked In'.
    }
}
