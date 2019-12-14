package com.sirius.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * 描述:
 *
 * @author tangzhiming
 * @create 2019-11-30 17:22
 */
public class IoTest implements Serializable {

    private String name;

    public void set (String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static void main(String[] args)throws Exception {

//        fileIoTest();

        objectIoTest();


    }


    private static void objectIoTest () throws Exception {
        IoTest ioTest = new IoTest();
        ioTest.set("唐志明");


        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);

        // objectOutputStream 将 ioTest对象 写入 byteArrayOutputStream
        objectOutputStream.writeObject(ioTest);


        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());

        ObjectInputStream objectInputStream = new ObjectInputStream(new BufferedInputStream(byteArrayInputStream));


        IoTest o = (IoTest)objectInputStream.readObject();

        System.out.println(o == ioTest);

        System.out.println(o.getName());

    }


    private static void fileIoTest () throws Exception {
        FileInputStream inputStream = new FileInputStream("/Users/pisces/Desktop/source.txt");

        BufferedInputStream bufferedInputStream  = new BufferedInputStream(inputStream);

        FileOutputStream outputStream = new FileOutputStream("/Users/pisces/Desktop/target.txt");

        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);

        byte[] bytes = new byte[1024];

        while ( bufferedInputStream.read(bytes) != -1) {
            bufferedOutputStream.write(bytes);
        }

        bufferedOutputStream.close();
        outputStream.close();


        bufferedInputStream.close();
        inputStream.close();


    }

    /**
     * 转换流
     */
    private void convertIo () {



//        InputStreamReader inputStreamReader = new InputStreamReader();
    }
}