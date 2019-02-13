package com.sirius.lockTest;

import com.sirius.lock.SiriusSynchronized;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

@ContextConfiguration(locations = {"classpath:applicationContext-service.xml"})
public class LockTest extends AbstractTestNGSpringContextTests {

    int i = 0;
    private SiriusSynchronized test1 = new SiriusSynchronized();

    private SiriusSynchronized test2 = new SiriusSynchronized();

    @Test
    public void test_synchronized () {

        Thread thread1 = new Thread(new Runnable() {
            public void run() {
                //System.out.println(SiriusSynchronized.add());
            }
        });


        Thread thread2 = new Thread(new Runnable() {
            public void run() {
                System.out.println(test1.sub());
            }
        });
        thread1.setName("ADD");
        thread2.setName("SUB");
        thread1.start();
        thread2.start();
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            //nothing
        }
    }
}
