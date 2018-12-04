package com.sirius.designpatterns.simple_factory_method;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 描述:静态工厂
 *
 * @author tangzhiming
 * @create 2018-11-29 14:31
 */
@Service
public class SimpleFactoryMethod_Factory {

    @Autowired
    SimpleFactoryMethod_ProductA simpleFactoryMethod_productA;
    @Autowired
    SimpleFactoryMethod_ProductB simpleFactoryMethod_productB;

    public SimpleFactoryMethod_Product getProduct(String type) {
        if ("A".equalsIgnoreCase(type)) {
            return simpleFactoryMethod_productA;
        } else if ("B".equalsIgnoreCase(type)) {
            return simpleFactoryMethod_productB;
        }
        throw new IllegalStateException("参数错误");
    }
}