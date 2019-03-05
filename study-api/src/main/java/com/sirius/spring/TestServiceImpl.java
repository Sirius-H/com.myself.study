package com.sirius.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 描述:
 *
 * @author tangzhiming
 * @create 2019-03-05 19:22
 */
@Service
public class TestServiceImpl implements TestService {


    @Autowired
    TransactionalManage transactionalManage;

    @Override
    @Transactional
    public void test() {
        System.out.println("执行完毕");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            //nothing
        }



        transactionalManage.execute( () -> {
            System.out.println("执行事务提交");
        });
    }
}