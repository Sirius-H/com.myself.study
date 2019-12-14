package com.sirius.lock;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 描述:
 *
 * @author tangzhiming
 * @create 2019-11-21 16:18
 */
public class SynchronizedTest {

    private static Lock lock = new ReentrantLock();


    public void testSynchronized () {
        lock.lock();
        try {
            System.out.println("我拿到锁了");
            TimeUnit.SECONDS.sleep(10000);
        } catch (Exception e) {
            lock.unlock();
            //nothing
        }
    }


    public static void main(String[] args) {
        SynchronizedTest test = new SynchronizedTest();

        Set<Integer> list = new HashSet<>();

        new Thread(new Runnable() {
            @Override
            public void run() {
                test.testSynchronized();
            }
        },"test").start();

        test.testSynchronized();


    }
}