package com.sirius.designpatterns.builder;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface Builder {

    void buildCpu();


}
