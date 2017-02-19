package com.example;

import java.util.Calendar;
import java.util.concurrent.atomic.LongAdder;

class TPSCounter {
    private final LongAdder count;
    private final Calendar expiry;
    private int threshold = 2;

    TPSCounter() {
        this.count = new LongAdder();
        this.expiry = Calendar.getInstance();
        this.expiry.add(Calendar.MINUTE, 1);
    }

    public void increment() {
        count.increment();
    }

    public boolean isExpired() {
        return Calendar.getInstance().after(expiry);
    }

    public boolean isWeak() {
        return count.intValue() > threshold;
    }
}
