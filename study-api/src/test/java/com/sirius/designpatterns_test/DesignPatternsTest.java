package com.sirius.designpatterns_test;

import com.sirius.designpatterns.factory_method.FactoryMethod_FactoryA;
import com.sirius.designpatterns.factory_method.FactoryMethod_FactoryB;
import com.sirius.designpatterns.factory_method.FactoryMethod_Product;
import com.sirius.designpatterns.simple_factory_method.SimpleFactoryMethod_Factory;
import com.sirius.designpatterns.simple_factory_method.SimpleFactoryMethod_ProductA;
import com.sirius.designpatterns.simple_factory_method.SimpleFactoryMethod_ProductB;
import com.sirius.designpatterns.simple_factory_method.example.ClassPathXmlApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

/**
 * 描述:
 * 
 *
 * @author tangzhiming
 * @create 2018-11-29 23:15
 */
@ContextConfiguration(locations = {"classpath:applicationContext-service.xml"})
public class DesignPatternsTest extends AbstractTestNGSpringContextTests {

    @Autowired
    SimpleFactoryMethod_Factory simpleFactoryMethod_factory;
    @Autowired
    FactoryMethod_FactoryA factoryMethod_factoryA;
    @Autowired
    FactoryMethod_FactoryB factoryMethod_factoryB;

    /**
     *静态工厂测试
     */
    @Test
    public void test_simple_factory_method () throws Exception{
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-service.xml");
        SimpleFactoryMethod_ProductA simpleFactoryMethod_productA = (SimpleFactoryMethod_ProductA)context.getBean("simpleFactoryMethod_ProductA");
        System.out.println(simpleFactoryMethod_productA.use());

        SimpleFactoryMethod_ProductB simpleFactoryMethod_productB = (SimpleFactoryMethod_ProductB)context.getBean("simpleFactoryMethod_ProductB");
        System.out.println(simpleFactoryMethod_productB.use());
//        SimpleFactoryMethod_ProductA aClass = (SimpleFactoryMethod_ProductA) simpleFactoryMethod_factory.getProduct("A");
//        System.out.println(aClass.use());
//
//        SimpleFactoryMethod_ProductB bClass = (SimpleFactoryMethod_ProductB) simpleFactoryMethod_factory.getProduct("B");
//        System.out.println(bClass.use());
    }


    /**
     *工厂方法测试
     */
    @Test
    public void test_factory_method () {
        FactoryMethod_Product product = factoryMethod_factoryA.getProduct();
        FactoryMethod_Product product1 = factoryMethod_factoryB.getProduct();
        System.out.println(product.use());
        System.out.println(product1.use());
    }

    public  int i = 0;


    @Test
    public void test_Thread() {
        Thread thread = new Thread(new Runnable() {
            public void run() {
                i++;
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            public void run() {
                i++;
            }
        });

        thread.start();
        thread2.start();
        if (i < 2) {
            System.out.println(i);
        }


    }

}