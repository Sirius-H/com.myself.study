package com.sirius.designpatterns.factory_method;

import org.springframework.stereotype.Service;

/**
 * 描述:
 * 工厂A
 *
 * @author tangzhiming
 * @create 2018-12-04 18:37
 */
@Service
public class FactoryMethod_FactoryA implements FactoryMethod_Factory {
    public FactoryMethod_Product getProduct() {
        return new FactoryMethod_ProductA();
    }
}