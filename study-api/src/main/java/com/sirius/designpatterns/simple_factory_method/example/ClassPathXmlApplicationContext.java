package com.sirius.designpatterns.simple_factory_method.example;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClassPathXmlApplicationContext implements BeanFactory {

    protected Map<String,Object> map = new HashMap<String, Object>();

    public ClassPathXmlApplicationContext (String fileName)throws Exception {
        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read(ClassPathXmlApplicationContext.class.getClassLoader().getResourceAsStream(fileName));
        Element rootElement = document.getRootElement();
        List<Element> elements = rootElement.elements();
        for (Element element : elements) {
            map.put(element.attributeValue("name"),Class.forName(element.attributeValue("class")).newInstance());
        }
    }
    public Object getBean(String name) throws Exception {
        return map.get(name);
    }
}
