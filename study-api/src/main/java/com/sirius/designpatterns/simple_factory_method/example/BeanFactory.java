package com.sirius.designpatterns.simple_factory_method.example;

public interface BeanFactory {

    Object getBean(String name) throws Exception;

}
