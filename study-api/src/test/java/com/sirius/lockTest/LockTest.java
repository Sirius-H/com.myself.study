package com.sirius.lockTest;

import com.sirius.lock.SiriusSynchronized;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

@ContextConfiguration(locations = {"classpath:applicationContext-service.xml"})
public class LockTest extends AbstractTestNGSpringContextTests {



    @Test
    public void test_synchronized () {

        Thread thread1 = new Thread(new Runnable() {
            public void run() {
                SiriusSynchronized.add();
            }
        });

        final SiriusSynchronized test = new SiriusSynchronized();
        Thread thread2 = new Thread(new Runnable() {
            public void run() {
                test.sub();
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
