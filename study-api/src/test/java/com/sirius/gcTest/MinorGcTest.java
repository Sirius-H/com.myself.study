package com.sirius.gcTest;

import org.testng.annotations.Test;
import redis.clients.jedis.Jedis;

/**
 * 描述:
 *
 * @author tangzhiming
 * @create 2019-06-04 11:04
 */
public class MinorGcTest {

    private static final int _1MB = 1024 * 1024;



    @Test
    public void test_1(String[] args) {
        byte[] allocation4 = new byte[_1MB];
    }

    @Test
    public void testMinorGc2 () {
        byte[]  allocation1, allocation2, allocation3,allocation4;
        allocation1 = new byte[_1MB / 4];

        allocation2 = new byte[4 * _1MB];

        allocation3 = new byte[4 * _1MB];

        allocation3 = null;

        allocation3 = new byte[4 * _1MB];
    }

    public static void main(String[] args) {
        Jedis jedis = new Jedis("0.0.0.0",6379);

        System.out.println(jedis.get("name"));

        System.out.println(jedis.get("name").length());

    }
}