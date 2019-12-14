package com.sirius.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class LockApiTest {

    static int value = 0;

    static final Lock lock = new ReentrantLock();

    static final Lock twinsLock = new TwinsLock();

    static final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    static final Lock readLock = readWriteLock.readLock();

    static final Lock write = readWriteLock.writeLock();




    private void lockTest () {
        lock.lock();
        try {
            value++;
            System.out.println(String.format(Thread.currentThread().getName() + "对我+1 结果:{%d}",value));
        } finally {
            System.out.println(Thread.currentThread().getName() + ":准备释放锁");
            lock.unlock();
            System.out.println(Thread.currentThread().getName() + ":释放锁");
        }

    }



    private void twinsLockTest () throws Exception{
        twinsLock.lock();
        try {
            TimeUnit.SECONDS.sleep(1);
            System.out.println(Thread.currentThread().getName());
            TimeUnit.SECONDS.sleep(1);
        } finally {
            twinsLock.unlock();
        }
    }

    public static void main(String[] args) throws Exception {
        LockApiTest lockApiTest = new LockApiTest();

        Condition condition = lock.newCondition();

        condition.await();

        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        lockApiTest.twinsLockTest();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            },"thread"+i).start();
        }

        for (int i = 0; i < 10; i++) {
            TimeUnit.SECONDS.sleep(1);
            System.out.println("------------------");
        }

//        Thread a = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                lockApiTest.lockTest();
//            }
//        },"testA");
//
//
//        Thread b = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                lockApiTest.lockTest();
//            }
//        },"testB");
//
//        a.start();
//        b.start();
//
//
//        TimeUnit.SECONDS.sleep(10);

    }
}
