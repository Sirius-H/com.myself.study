package com.sirius.thread_test;

import com.sirius.BaseTest;

public class InterruptTest extends BaseTest {


    public static void main(String[] args) {
        Thread sleepThread = new Thread(new SleepRunner(),"sleepRunner");
        sleepThread.setDaemon(true);

        Thread busyThread = new Thread(new BusyRunner(),"buysRunner");
        busyThread.setDaemon(true);

        busyThread.start();
        sleepThread.start();

        sleepUtil(5000);

        sleepThread.interrupt();
        busyThread.interrupt();

        System.out.println("sleepRunner interrupt is:" + sleepThread.isInterrupted());
        System.out.println("buysRunner interrupt is:" + busyThread.isInterrupted());

        sleepUtil(5000);
    }


    static class SleepRunner implements Runnable {

        public void run() {
            while (true) {
                sleepUtil(1000);
            }
        }
    }


    static class BusyRunner implements Runnable {

        public void run() {
            while (true) {

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
