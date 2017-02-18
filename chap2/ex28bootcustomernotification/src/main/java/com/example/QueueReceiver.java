package com.example;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class QueueReceiver {
    public static final String QUEUE_NAME = "CustomerQ";

    @Autowired
    private JavaMailSender javaMailSender;

    @Bean
    Queue queue() {
        return new Queue(QUEUE_NAME, false);
    }

    @RabbitListener(queues = QUEUE_NAME)
    public void processMessage(String email) {
        SimpleMailMessage simpleMessage = new SimpleMailMessage();
        simpleMessage.setFrom("noreply@example.com");
        simpleMessage.setTo(email);
        simpleMessage.setSubject("Registration confirmed.");
        simpleMessage.setText("Thank you for registering, " + email);
        javaMailSender.send(simpleMessage);
    }
}
