package com.sirius.spring_test;

import com.sirius.BaseTest;
import com.sirius.spring.TestService;
import com.sirius.spring.TransactionalManage;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

/**
 * 描述:
 *
 * @author tangzhiming
 * @create 2019-03-05 19:20
 */
public class SpringTest extends BaseTest {

    @Autowired
    TestService testService;



    @Test
    public void test_spring () {

        testService.test();

    }
}