package com.example.fares;

import com.example.fares.entity.Fare;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import static junit.framework.TestCase.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {
    @Test
    public void testFare() {
        RestTemplate restTemplate = new RestTemplate();
        Fare fare = restTemplate.getForObject("http://localhost:8080/fares/1", Fare.class);
        assertEquals("101", fare.getFare());
    }
}
