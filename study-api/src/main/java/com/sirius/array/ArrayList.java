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
        this(10);
    }

    public ArrayList(int capacity) {
        super.data = (T[]) new Object[capacity];
    }

    @Override
    public void add(Object obj) {
       super.add(obj);
    }

    @Override
    public void remove(int index) {

    }

    @Override
    public int indexOf(Object object) {
        return 0;
    }

    @Override
    public void add(int index,Object obj) {
        super.add(index,obj);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Object get(int index) {
        return null;
    }

    @Override
    public boolean contains(Object object) {
        return false;
    }
}