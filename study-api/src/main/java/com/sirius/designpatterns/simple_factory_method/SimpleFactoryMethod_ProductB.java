package com.sirius.designpatterns.simple_factory_method;

import org.springframework.stereotype.Service;

/**
 * 描述:
 * concreteness product b
 *
 * @author tangzhiming
 * @create 2018-11-29 14:33
 */
@Service
public class SimpleFactoryMethod_ProductB implements SimpleFactoryMethod_Product {
    public String use() {
        return "我是B类";
    }
}