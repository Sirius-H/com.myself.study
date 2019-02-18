package com.sirius.thread_test;

import com.sirius.BaseTest;

import java.text.SimpleDateFormat;
import java.util.Date;

public class WaitAndNotifyTest extends BaseTest {

    private static volatile boolean flag = true;
    private static Object[] lock = new Object[0];


    public static void main(String[] args) {

        Thread wait = new Thread(new Wait(),"waitThread");
        wait.start();

        sleepUtil(2000);
        Thread notify = new Thread(new Notify(),"notifyThread");
        notify.start();

    }



    static class Wait implements Runnable {

        public void run() {

            synchronized (lock) {
                while (flag)  {
                    try {
                        System.out.println(Thread.currentThread().getName() + " flag is true wait" +
                                new SimpleDateFormat("HH:mm:ss").format(new Date()));
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                System.out.println(Thread.currentThread().getName() + " flag is false Running" +
                        new SimpleDateFormat("HH:mm:ss").format(new Date()));

            }

        }
    }


    static class Notify implements Runnable {

        public void run() {
            synchronized (lock) {
                while (flag)  {
                    try {
                        System.out.println(Thread.currentThread().getName() + " holt lock  notify" +
                                new SimpleDateFormat("HH:mm:ss").format(new Date()));
                        lock.notifyAll();
                        flag = false;
                        sleepUtil(5000);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }

            synchronized (lock) {
                System.out.println(Thread.currentThread().getName() + " holt lock  again sleep" +
                        new SimpleDateFormat("HH:mm:ss").format(new Date()));
                sleepUtil(5000);
            }

        }
    }

    private static void sleepUtil (int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            //nothing
        }
    }
}
