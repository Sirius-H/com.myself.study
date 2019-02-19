package com.sirius.thread_test;

import com.sirius.BaseTest;
import org.testng.annotations.Test;

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


    /**
     * 测试
     */
    @Test
    public void test_Join() {
        System.out.println("-------主方法执行-------");

        Thread joinTest = new Thread( new JoinTest(Thread.currentThread()), "join" );
        joinTest.start();
        sleepUtil(2000);


                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             Thread joinTest2 = new Thread( new JoinTest2(), "joinTest2" );
        joinTest2.start();
        System.out.println("joinTest2 启动了");

        System.out.println("运行结束了");
    }



    static class JoinTest implements Runnable {

        private Thread previous;

        public JoinTest(Thread previous) {
            this.previous = previous;
        }

        public void run() {
            synchronized (lock) {
                System.out.println("----------"+Thread.currentThread().getName()+"+执行完毕----------");
                try {
                    previous.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class JoinTest2 implements Runnable {

        public void run() {
            synchronized (lock) {
                System.out.println("----------"+Thread.currentThread().getName()+"抢到了锁----------");
                sleepUtil(5000);
            }
        }
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
