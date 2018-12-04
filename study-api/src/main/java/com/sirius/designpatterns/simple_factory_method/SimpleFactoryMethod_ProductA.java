package com.sirius.designpatterns.simple_factory_method;

import org.springframework.stereotype.Service;

/**
 * 描述:
 * concreteness product A
 *
 * @author tangzhiming
 * @create 2018-11-29 14:32
 */
@Service
public class SimpleFactoryMethod_ProductA implements SimpleFactoryMethod_Product {

    public String use() {
        return "我是A类";
    }
}