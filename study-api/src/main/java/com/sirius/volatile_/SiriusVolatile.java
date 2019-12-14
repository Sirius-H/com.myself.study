package com.sirius.volatile_;

import java.util.concurrent.atomic.AtomicInteger;


public class SiriusVolatile {

    private AtomicInteger value = new AtomicInteger(0);


    public void add () {
        value.incrementAndGet();
    }

    public long getValue () {
        return value.intValue();
    }

}
