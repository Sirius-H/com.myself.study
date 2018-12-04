package com.sirius.array;

/**
 * 描述:
 * 容器
 *
 * @author tangzhiming
 * @create 2018-11-30 00:10
 */
public class ArrayList<T> extends AbstractArray<T> {

    public ArrayList() {
        super.data = (T[]) new Object[10];
    }

    public ArrayList(int capacity) {
        super.data = (T[]) new Object[capacity];
    }

    public void add(Object obj) {
       super.add(obj);
    }

    public void remove(int index) {

    }

    public int indexOf(Object object) {
        return 0;
    }

    public void add(int index,Object obj) {

    }

    public int size() {
        return size;
    }

    public Object get(int index) {
        return null;
    }

    public boolean contains(Object object) {
        return false;
    }
}