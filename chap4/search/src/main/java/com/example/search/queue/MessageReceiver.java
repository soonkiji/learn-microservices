package com.example.search.queue;

import com.example.search.service.SearchService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class MessageReceiver {
    @Autowired
    private SearchService searchService;

    @RabbitListener(queues = "SearchQ")
    public void updateInventory(Map<String, Object> fare) {
        System.out.println("Received message: " + fare);
        String flightNumber = (String) fare.get("FLIGHT_NUMBER");
        String flightDate = (String) fare.get("FLIGHT_DATE");
        int newInventory = (int) fare.get("NEW_INVENTORY");
        searchService.updateInventory(flightNumber, flightDate, newInventory);
    }
}
