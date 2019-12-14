package com.sirius.lock;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 描述:
 *
 * @author tangzhiming
 * @create 2019-12-08 16:24
 */
public class CountDownLatchTest {


    public static void main(String[] args)throws Exception {
        //裁判
        CountDownLatch referee = new CountDownLatch(1);

        //队员
        CountDownLatch player = new CountDownLatch(10);


        ExecutorService executorService = Executors.newFixedThreadPool(10);

        AtomicInteger ranking = new AtomicInteger(1);

        for (int no = 1; no < 11; no++) {
           Thread thread =  new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        //准备
                        referee.await();
                        long timeConsuming = (long)(Math.random() * 10);
                        TimeUnit.SECONDS.sleep(timeConsuming);
                        System.out.println(Thread.currentThread().getName() + " complete No." +  ranking.getAndIncrement() + " 耗时:" + timeConsuming);
                    } catch (Exception e) {
                        //终止比赛
                        executorService.shutdown();
                    }finally {
                        player.countDown();
                    }
                }
            },"No."+no);

           executorService.submit(thread);

        }

        //裁判喊开始
        referee.countDown();

        //等待所有队员都跑完
        player.await();

        System.out.println("比赛结束");

        executorService.shutdown();
    }
}