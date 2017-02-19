package com.example;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class TPSHealth implements HealthIndicator {
    TPSCounter counter;

    @Override
    public Health health() {
        if (counter.isWeak()) {
            return Health.outOfService().withDetail("message", "Too many requests").build();
        }
        return Health.up().build();
    }

    public void updateTx() {
        if (counter == null || counter.isExpired()) {
            counter = new TPSCounter();
        }
        counter.increment();
    }
}
