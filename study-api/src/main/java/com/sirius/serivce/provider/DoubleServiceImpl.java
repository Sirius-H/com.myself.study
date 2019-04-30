package com.sirius.serivce.provider;

/**
 * 描述:
 *
 * @author tangzhiming
 * @create 2019-04-30 14:50
 */
public class DoubleServiceImpl implements DubboProviderService {
    @Override
    public String sayHello(String name) {
        return name + "hello!!!!";
    }
}