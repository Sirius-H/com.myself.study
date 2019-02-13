package com.sirius;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;

@ContextConfiguration(locations = {"classpath:applicationContext-service.xml"})
public class BaseTest extends AbstractTestNGSpringContextTests {
}
