package com.sirius.array;

import org.testng.annotations.Test;


/**
 * 描述:
 * 数组test
 *
 * @author tangzhiming
 * @create 2018-11-29 23:39
 */
public class ArrayTest {

    @Test
    public void test_arrayList () {
        Array array = new ArrayList<Integer>();
        array.add(1);
        array.add(2);
        array.add(3);
        System.out.println(array.toString());
    }
}