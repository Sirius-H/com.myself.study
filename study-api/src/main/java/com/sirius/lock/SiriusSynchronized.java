package com.sirius.lock;

public class SiriusSynchronized {

    public String add () {
        synchronized (this) {
            System.out.println("我被"+ Thread.currentThread().getName() + "调用了");
            try {
                System.out.println("我睡觉了 zzzz");
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
       return  Thread.currentThread().getName() + "我结束了";
    }


    public synchronized String sub () {
        System.out.println("我被"+ Thread.currentThread().getName() + "调用了");
        try {
            System.out.println("我睡觉了 zzzz");
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return  Thread.currentThread().getName() +"我结束了";
    }

}
