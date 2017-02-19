package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.metrics.CounterService;
import org.springframework.boot.actuate.metrics.GaugeService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {
    @Autowired
    private TPSHealth health;

    @Autowired
    private CounterService counterService;

    @Autowired
    private GaugeService gaugeService;

    @RequestMapping("/")
    Greet greet() {
        health.updateTx();
        counterService.increment("mygreet.mycounter");
        gaugeService.submit("mygreet.mygauge", 1.0);
        return new Greet("Hello World!");
    }
}
