package com.sirius.ThreadPool;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class DefaultThreadPool<Job extends Runnable> implements ThreadPool<Job> {

    //最大工作线程
    private static final int MAX_WORKER_NUMBERS = 10;
    //初始化工作线程
    private static final int DEFAULT_WORKER_NUMBER = 5;
    //最小工作线程
    private static final int MIN_WORKER_NUMBER = 1;
    //工作列表 客户端将不断向里面插入工作(谁去执行这个工作 工作者)
    private final LinkedList<Job> jobs = new LinkedList<Job>();
    //工作者
    private final List<Worker> workers = Collections.synchronizedList(new ArrayList<Worker>());
    //工作者线程数量
    private int workerNumbers = DEFAULT_WORKER_NUMBER;
    //线程编号
    private AtomicLong threadNumber = new AtomicLong();

    public DefaultThreadPool() {
        initializeWorkers(DEFAULT_WORKER_NUMBER);
    }

    public DefaultThreadPool(int num) {
        //大于最大的 就用自定义最大的， 小于最小的就用自定义最小的，否则 用用户自定义的
        workerNumbers = num > MAX_WORKER_NUMBERS ? MAX_WORKER_NUMBERS : num < MIN_WORKER_NUMBER ?  MIN_WORKER_NUMBER : num;
        initializeWorkers(workerNumbers);
    }

    public void execute(Runnable runnable) {

    }

    public void shutdown() {

    }

    public void addWorkers(int num) {

    }

    public void removeWorkers(int num) {

    }

    public int getJobSize() {
        return 0;
    }


    private void initializeWorkers (int num) {
        for (int i = 0; i < num; i++) {
            Worker worker = new Worker();
            workers.add(worker);
            Thread thread = new Thread(worker,"ThreadPool-Worker-" + threadNumber.incrementAndGet());
            thread.start();
        }
    }


    class Worker implements Runnable {
        private volatile boolean running = true;
        public void run() {
            while (running) {
                synchronized (jobs) {

                }
            }
        }
    }
}
