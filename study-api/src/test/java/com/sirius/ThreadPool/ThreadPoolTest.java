package com.sirius.ThreadPool;

import com.sirius.BaseTest;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ThreadPoolTest extends BaseTest {


    @Test
    public void test_threadPool () {
        DefaultThreadPool defaultThreadPool = new DefaultThreadPool();
        for (int i = 0; i < 10; i++) {
            ThreadPool threadPool = new ThreadPool("测试" + i);
            defaultThreadPool.execute(threadPool);
        }
        //5秒之后 删除5个线程
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        defaultThreadPool.removeWorkers(1);


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
                System.out.println(mark + " 为你报时 ： " +  new SimpleDateFormat("HH:mm:ss").format(new Date()));
                count ++;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    //nothing
                }
            }
            System.out.println(mark + "结束报时");
        }
    }
}
