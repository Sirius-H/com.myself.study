package com.sirius.threadTest;

public interface ThreadPool<Job extends Runnable> {

    //执行job
    void execute (Job job);
    //关闭线程池
    void shutdown();
    // 增加工作线程
    void addWorkers(int num);
    //减少工作线程
    void removeWorkers(int num);
    //获取正在等待执行的任务数
    int getJobSize();
}
