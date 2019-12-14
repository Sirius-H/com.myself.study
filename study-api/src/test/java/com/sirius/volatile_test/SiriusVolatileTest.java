package com.sirius.volatile_test;

import com.sirius.volatile_.SiriusVolatile;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class SiriusVolatileTest {

    Map<Integer, Integer> map;

    private boolean initialization;

    public void testInstructionReordering() {
        map = new HashMap<>();
        processValue(map);
        initialization = true;
    }

    private void processValue(Map<Integer, Integer> map) {
        map.put(0, 0);
        map.put(1, 1);
    }


    public void add() {
        while (initialization) {
            int result = map.getOrDefault(0, 0) + map.getOrDefault(1, 0);
            if (result == 1) {
                return;
            } else {
                System.out.println(result);
            }
        }
    }

//    public static void main(String[] args) {
//        for (int i = 0; i < 10000; i++) {
//            test1();
//        }
//    }
//
//    private static void test1() {
//        final SiriusVolatileTest siriusVolatileTest = new SiriusVolatileTest();
//        Thread a = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                siriusVolatileTest.testInstructionReordering();
//            }
//        }, "A");
//
//
//        Thread b = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                siriusVolatileTest.add();
//            }
//        }, "B");
//
//        b.start();
//        a.start();
//
//    }

    /**
     * 预期200000
     *
     * 实际每次输出 都不会有20万
     *
     * 原因：
     * 首先  value++ 并非一个原子操作 这里包含4步 取值 压栈 计算 赋值
     * 字节码指令：
     *          2: getfield      #2                  // Field value:J
     *          5: lconst_1
     *          6: ladd
     *          7: putfield      #2                  // Field value:J
     *举例    A线程进行 2: getfield      #2                  // Field value:J
     *                5: lconst_1
     *
     *       B线程进行 7: putfield      #2                  // Field value:J
     *
     *       这时候 value 就已经被 B线程给更改 A线程压进栈中的的值就是一个过期的 当A继续执行到 7: putfield      #2                  // Field value:J
     *       A把一个过期的值+1 并且设置进去
     *
     *
     * @param args
     */
    public static void main(String[] args) {
        final SiriusVolatile siriusVolatile = new SiriusVolatile();

        Thread[] threads = new Thread[20];
        for (int i = 0; i < 20; i++) {
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 10000; j++) {
                        siriusVolatile.add();
                    }
                }
            });
            threads[i].start();
        }

        while (Thread.activeCount() > 1) {
            Thread.yield();
        }

        System.out.println(siriusVolatile.getValue());
    }


}
