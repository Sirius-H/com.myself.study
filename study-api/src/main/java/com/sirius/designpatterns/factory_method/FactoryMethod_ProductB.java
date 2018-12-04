package com.sirius.designpatterns.factory_method;

import org.springframework.stereotype.Service;

/**
 * 描述:
 * 子类b
 *
 * @author tangzhiming
 * @create 2018-12-04 18:34
 */
@Service
public class FactoryMethod_ProductB implements FactoryMethod_Product {
    public String  use() {
        return "我是B类";
    }
}