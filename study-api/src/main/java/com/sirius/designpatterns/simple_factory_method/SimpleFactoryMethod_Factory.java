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


    public SimpleFactoryMethod_Product getProduct(String type) {
        try {
            if ("A".equalsIgnoreCase(type)) {
                return (SimpleFactoryMethod_Product)Class.forName("com.sirius.designpatterns.simple_factory_method.SimpleFactoryMethod_ProductA").newInstance();
            } else if ("B".equalsIgnoreCase(type)) {
                return (SimpleFactoryMethod_Product)Class.forName("com.sirius.designpatterns.simple_factory_method.SimpleFactoryMethod_ProductB").newInstance();
            }
        } catch (Exception e) {
            //nothing
        }
        throw new IllegalStateException("参数错误");
    }
}