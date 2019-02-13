package com.sirius.volatile_test;

import com.sirius.BaseTest;
import com.sirius.volatile_.SiriusVolatile;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

public class SiriusVolatileTest extends BaseTest {

    @Autowired
    SiriusVolatile siriusVolatile;
    int i = 0;


    public void test_Volatile () {

      Thread thread =   new Thread(new Runnable() {
            public void run() {
                System.out.print(siriusVolatile.getV1());
                i++;
                if (i % 100 == 0) {
                    System.out.println('\n');
                }
            }
        });

        Thread thread1 =    new Thread(new Runnable() {
            public void run() {
                siriusVolatile.setV1();
            }
        });

        thread.setName("A");
        thread1.setName("B");

        //先读后写
        thread.start();
        thread1.start();



    }
    @Test
    public void test_for () {
        for (int i = 0; i < 1; i++) {
            test_Volatile();
        }
    }
}
