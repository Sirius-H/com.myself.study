package com.sirius.thread_test;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述:
 *
 * @author tangzhiming
 * @create 2019-05-16 13:17
 */
public class OomTest {


    public static class OOMobject {

    }
    //OOM
    public static void main(String[] args){
        List<OOMobject> ooMobjects = new ArrayList<>();
        while (true) {
            ooMobjects.add(new OOMobject());
        }
    }
}