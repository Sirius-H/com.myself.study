package com.sirius.object_test;

/**
 * 描述:
 *
 * @author tangzhiming
 * @create 2019-11-13 15:48
 */
public class SortTest {

//    private int a = 1;
//    private static SortTest sortTest = new SortTest("A");
//
//
//    public SortTest(String name) {
//        System.out.println(a);
//        System.out.println(name + "构造器被执行了" );
//    }
//
//    {
//        System.out.println("方法块被执行");
//    }
//
//    static {
//        System.out.println("静态块被执行了");
//    }

//    public static void main(String[] args) {
//        //先给a = 1 赋值 、方法块被执行  1 A构造器被执行了 静态块被执行了
//    }

    public void sayHello (Man man) {
        System.out.println("Hello " + man.getValue());
    }


    public void sayHello (Houman houman) {
        System.out.println("Hello " + houman.getValue());
    }


    public void sayHello (Jack jack) {
        System.out.println("Hello " + jack.getValue());
    }

    public static void main(String[] args) {
        SortTest sortTest = new SortTest();

        Houman jack = new Jack();

        Houman man = new Man();

        sortTest.sayHello(jack);
        sortTest.sayHello(man);
    }


}