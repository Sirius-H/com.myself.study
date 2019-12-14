package com.sirius.classloader;

import java.io.IOException;
import java.io.InputStream;

/**
 * 描述: 测试同一个类被不同的类加载器加载之后 2个对象不是同一个对象
 *
 *
 * @author tangzhiming
 * @create 2019-11-12 17:25
 */
public class ClassLoaderTest {


    public static void main(String[] args) throws Exception {

        ClassLoader myClassLoder = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                try {
                    String  name1 = name.substring(name.lastIndexOf(".") + 1) + ".class";
                    InputStream resourceAsStream = getClass().getResourceAsStream(name1);
                    if (resourceAsStream == null) {
                        return super.loadClass(name);
                    }
                    byte[] obj = new byte[resourceAsStream.available()];
                    resourceAsStream.read(obj);
                    return defineClass(name,obj,0,obj.length);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                throw new ClassNotFoundException(name);
            }

        };
        Object o = myClassLoder.loadClass(Person.class.getName()).newInstance();

        System.out.println(o.getClass().getName());
        System.out.println(Person.class.getName());
        System.out.println(o instanceof Person );
    }
}