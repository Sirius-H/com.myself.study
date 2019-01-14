package com.sirius.volatile_;

import org.springframework.stereotype.Service;

@Service
public class SiriusVolatile {

    private volatile long v1 = 0L;

    /**
     * volatile 变量 happens-before 规则
     * v1 = 1l happens-before return v1
     *
     */

    public void setV1 () {
        v1 = 1L;

    }

    public long getV1(){
        return v1;
    }
}
