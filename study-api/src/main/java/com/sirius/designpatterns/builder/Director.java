package com.sirius.designpatterns.builder;

/**
 * 描述:
 * 指挥者
 *
 * @author tangzhiming
 * @create 2019-03-05 16:33
 */
public class Director {

    private Builder builder;


    public Director(Builder builder) {
        this.builder = builder;
    }

    public void construct() {
        builder.buildCpu();
    }



}