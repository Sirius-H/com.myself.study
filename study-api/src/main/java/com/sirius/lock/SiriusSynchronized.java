package com.sirius.lock;

public class SiriusSynchronized {

    public static void add () {
        synchronized (SiriusSynchronized.class) {
            System.out.println("我被"+ Thread.currentThread().getName() + "调用了");
            try {
                System.out.println(Thread.currentThread().getName() + "暂停10秒");
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + "我结束了");
    }


    public synchronized void sub () {
        System.out.println("我被"+ Thread.currentThread().getName() + "调用了");
        try {
            System.out.println(Thread.currentThread().getName() + "暂停10秒");
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "我结束了");
    }

}
