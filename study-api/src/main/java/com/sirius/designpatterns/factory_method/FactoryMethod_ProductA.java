package com.sirius.designpatterns.factory_method;

import org.springframework.stereotype.Service;

/**
 * 描述:
 * 具体产品
 *
 * @author tangzhiming
 * @create 2018-12-04 18:33
 */
@Service
public class FactoryMethod_ProductA implements FactoryMethod_Product {
    public String use() {
        return "我是A类";
    }
}