package designpatterns_test;

import designpatterns.simple_factory_method.ConcretenessProductA;
import designpatterns.simple_factory_method.ConcretenessProductB;
import designpatterns.simple_factory_method.Factory;
import org.testng.annotations.Test;

/**
 * 描述:
 * 静态工厂测试
 *
 * @author tangzhiming
 * @create 2018-11-29 23:15
 */
public class SimpleFactoryMethodTest {

    @Test
    public void test () {

        ConcretenessProductA aClass = (ConcretenessProductA)Factory.getProduct("A");
        System.out.println(aClass.use());

        ConcretenessProductB bClass = (ConcretenessProductB)Factory.getProduct("B");
        System.out.println(bClass.use());
    }
}