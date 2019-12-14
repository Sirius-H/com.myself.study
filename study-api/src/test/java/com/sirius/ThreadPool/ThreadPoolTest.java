package com.sirius.ThreadPool;

import com.sirius.BaseTest;
import com.sirius.threadTest.DefaultThreadPool;
import org.testng.annotations.Test;
import org.testng.internal.thread.ThreadUtil;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.math.BigDecimal;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolTest extends BaseTest {


    private static final Object[] objects = new Object[0];
    private List<Worker> workers = new ArrayList<>();

    private List<Job> jobs = new LinkedList<>();


    public ThreadPoolTest(int initialCapacity) {
        for (int i = 0; i < initialCapacity; i++) {
            Worker worker = new Worker();
            workers.add(worker);
            Thread thread = new Thread(worker,"ThreadPool-Worker-" + i);
            thread.start();
        }
    }

    public void execute (Job job) {
        synchronized (objects) {
            jobs.add(job);
            objects.notify();
        }
    }





    static class Job {

        public void job() {
           //待执行的任务
        }
    }

    class Worker implements Runnable{
        @Override
        public void run() {
            while (true) {
                Job job = null;
                synchronized (jobs) {
                    if (jobs.isEmpty()) {
                        try {
                            System.out.println("没有活干......");
                            objects.wait();
                        } catch (InterruptedException e) {
                            //响应中断
                            System.out.println("不用干活了...");
                            return;
                        }
                    }
                    System.out.println("干活...");
                    job = jobs.get(0);
                    System.out.println("删掉干完的活...");
                }

            }
        }
    }





    public static void main(String[] args) throws Exception {
//        ThreadPoolTest test = new ThreadPoolTest(5);
//
//        TimeUnit.SECONDS.sleep(5);
//
//        test.execute(new Job());
//
//        TimeUnit.SECONDS.sleep(5);
//
//        test.execute(new Job());
//
//        TimeUnit.SECONDS.sleep(5);


//        ExecutorService executorService = new ThreadPoolExecutor(1,1,60L,TimeUnit.SECONDS,
//                new ArrayBlockingQueue<>(5),new ThreadPoolExecutor.CallerRunsPolicy());
//
//        for (int i = 0; i < 10; i++) {
//            executorService.submit(new ThreadTest(i + ""));
//        }
//
//        System.out.println("执行完毕");



//
//        Thread thread = new Thread(new ThreadTest(Thread.currentThread()),"sirius");
//
//        thread.start();
//
//        TimeUnit.SECONDS.sleep(5);

//        System.out.println("执行中断 : " + thread.isInterrupted());

//        System.out.println("执行完毕");

//        TimeUnit.SECONDS.sleep(10);

    }


    @Test
    public void test_threadPool() {
        DefaultThreadPool defaultThreadPool = new DefaultThreadPool();
        for (int i = 0; i < 10; i++) {
            ThreadPool threadPool = new ThreadPool("测试" + i);
            defaultThreadPool.execute(threadPool);
        }

        try {
            Thread.sleep(200000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    static class ThreadPool implements Runnable {

        private String mark;

        public ThreadPool(String mark) {
            this.mark = mark;
        }

        @Override
        public void run() {
            int count = 0;
            System.out.println(mark + "开始报时");
            while (count < 10) {
                System.out.println(mark + " 为你报时 ： " + new SimpleDateFormat("HH:mm:ss").format(new Date()));
                count++;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    //nothing
                }
            }
            System.out.println(mark + "结束报时");
        }
    }

    private static final Object[] object = new Object[0];

    private static ThreadLocal<Long> threadLocal = new ThreadLocal<>();





    static class ThreadTest implements Runnable {

        private String name;

        public ThreadTest(String name) {
            this.name = name;
        }

        //        Thread thread;
//
//        public ThreadTest(Thread thread) {
//            this.thread = thread;
//        }

        @Override
        public void run() {
//            try {
////                thread.interrupt();
//                Thread currentThread = Thread.currentThread();
//                System.out.println(currentThread.getName() + ":我进入等待");
////                thread.join();
//                System.out.println(currentThread.getName() + ":我开始工作了");
//            } catch (InterruptedException e) {
//                System.out.println("我可以结束了");
//            }

            while (true){
                try {
                    System.out.println(Thread.currentThread().getName() + "正在执行......");
                    TimeUnit.SECONDS.sleep(100000000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
