package com.sirius.volatile_;

/**
 * 描述:
 *
 * @author tangzhiming
 * @create 2019-11-02 15:36
 */
public class FunctionTest {


    public static int add (int a,int b){
        //iload_0 istore_2 iconst_0 入栈指令
        int d = -1;//先进栈 出栈 然后存入局部变量表 第3个slot中
        int c = a + b;

        return c;
    }
}