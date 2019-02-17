package com.sirius.thread_test;

import com.sirius.BaseTest;
import org.testng.annotations.Test;

/**
 * 描述:
 *
 * @author tangzhiming
 * @create 2019-02-13 12:29
 */
public class ThreadTest extends BaseTest {


    /**
     * 线程的状态
     * new ：初始状态 线程被创建 但是还没有调用 start 方法
     * runnable：运行状态 ，java中将就绪状态和运行状态统称 运行状态
     * blocked：阻塞状态
     * waiting: 等待状态 线程进入等待状态，进入该状态说明 线程在等待其他线程做出某些动作，或等待其他线程通知
     * time_waiting ：超时等待，在一定时间内处于等待状态
     * terminated ： 终止状态
     */

    /**
     * jstack dump
     * "Blocked-2" #15 prio=5 os_prio=31 tid=0x00007fe722a00800 nid=0x4303 waiting for monitor entry [0x000070000ed21000]
     *    java.lang.Thread.State: BLOCKED (on object monitor)
     * 	at com.sirius.thread_test.ThreadTest$Blocked.run(ThreadTest.java:69)
     * 	- waiting to lock <0x0000000797626698> (a java.lang.Class for com.sirius.thread_test.ThreadTest$Blocked)
     * 	at java.lang.Thread.run(Thread.java:748)
     *
     *    Locked ownable synchronizers:
     * 	- None3
     *
     * "Blocked-1" #14 prio=5 os_prio=31 tid=0x00007fe721b1b800 nid=0x4003 waiting on condition [0x000070000ec1e000]
     *    java.lang.Thread.State: TIMED_WAITING (sleeping)
     * 	at java.lang.Thread.sleep(Native Method)
     * 	at com.sirius.thread_test.ThreadTest.sleepUtil(ThreadTest.java:77)
     * 	at com.sirius.thread_test.ThreadTest.access$000(ThreadTest.java:12)
     * 	at com.sirius.thread_test.ThreadTest$Blocked.run(ThreadTest.java:69)
     * 	- locked <0x0000000797626698> (a java.lang.Class for com.sirius.thread_test.ThreadTest$Blocked)
     * 	at java.lang.Thread.run(Thread.java:748)
     *
     *    Locked ownable synchronizers:
     * 	- None
     *
     * "TimeWaiting" #13 prio=5 os_prio=31 tid=0x00007fe722a32800 nid=0x4403 in Object.wait() [0x000070000eb1b000]
     *    java.lang.Thread.State: WAITING (on object monitor)
     * 	at java.lang.Object.wait(Native Method)
     * 	- waiting on <0x0000000797626630> (a java.lang.Class for com.sirius.thread_test.ThreadTest$Waiting)
     * 	at java.lang.Object.wait(Object.java:502)
     * 	at com.sirius.thread_test.ThreadTest$Waiting.run(ThreadTest.java:54)
     * 	- locked <0x0000000797626630> (a java.lang.Class for com.sirius.thread_test.ThreadTest$Waiting)
     * 	at java.lang.Thread.run(Thread.java:748)
     *
     *    Locked ownable synchronizers:
     * 	- None
     *
     * "TimeWaitingThread" #12 prio=5 os_prio=31 tid=0x00007fe721b1a800 nid=0x3e03 waiting on condition [0x000070000ea18000]
     *    java.lang.Thread.State: TIMED_WAITING (sleeping)
     * 	at java.lang.Thread.sleep(Native Method)
     * 	at com.sirius.thread_test.ThreadTest.sleepUtil(ThreadTest.java:77)
     * 	at com.sirius.thread_test.ThreadTest.access$000(ThreadTest.java:12)
     * 	at com.sirius.thread_test.ThreadTest$TimeWaiting.run(ThreadTest.java:42)
     * 	at java.lang.Thread.run(Thread.java:748)
     *
     *    Locked ownable synchronizers:
     * 	- None
     */

    @Test
    public void test_ThreadStatus () {
        new Thread(new TimeWaiting(),"TimeWaitingThread").start();
        new Thread(new Waiting(),"TimeWaiting").start();

        new Thread(new Blocked(),"Blocked-1").start();
        new Thread(new Blocked(),"Blocked-2").start();
        sleepUtil(30000);
    }


    //线程将不断的进行睡眠
    static class TimeWaiting implements Runnable {

        public void run() {
            while (true) {
                sleepUtil(30000);
            }
        }
    }

    //
    static class Waiting implements Runnable {

        public void run() {
            while (true) {
               synchronized (Waiting.class) {
                   try {
                       Waiting.class.wait();
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
               }
            }
        }
    }

    static class Blocked implements Runnable {

        public void run() {
            synchronized (Blocked.class){
                while (true) {

                    sleepUtil(30000);
                }
            }
        }
    }

    private static void sleepUtil (int second) {
        try {
            Thread.sleep(second);
        } catch (InterruptedException e) {
            //nothing
        }
    }

}