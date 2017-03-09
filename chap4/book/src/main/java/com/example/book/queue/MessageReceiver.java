package com.example.book.queue;

import com.example.book.service.BookingService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MessageReceiver {
    @Autowired
    private BookingService bookingService;

/*
    @RabbitListener(queues = "CheckInQ")
    public void processMessage(long bookingId) {
        String me = "processMessage()";
        System.out.println(me + " Updating booking status with CHECKED_IN [" + bookingId + "]");
        System.out.println(bookingService);
    }
*/
}
