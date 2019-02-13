package com.sirius.array;

/**
 * 描述:
 * 数组
 *
 * @author tangzhiming
 * @create 2018-11-29 23:28
 */
public abstract class AbstractArray<T> implements Array {
    protected T[] data;
    protected int size;


    public void add(Object obj) {
        add(size, obj);
    }

    public void remove(int index) {

    }

    public int indexOf(Object object) {
        return 0;
    }

    /**
     * 在指定位置添加元素
     *
     * @param index
     * @param obj
     */
    public void add(int index, Object obj) {
        if (data == null) {
            throw new NullPointerException();
        }
        if (size == data.length) {
            reseiz(data.length * 2);
        }
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = (T) obj;
        size++;
    }

    public int size() {
        return size;
    }

    public Object get(int index) {
        if (index < 0 || index > data.length) {
            throw new IndexOutOfBoundsException();
        }
        return data[index];
    }

    public boolean contains(Object object) {
        return false;
    }

    /**
     * 扩容
     */
    private void reseiz(int capacity) {
        int length = data.length;
        T[] data = (T[]) new Object[capacity + length];
        for (int i = 0; i < data.length; i++) {
            data[i] = data[i];
        }
        this.data = data;
    }


    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("[");
        for (int i = 0; i < size; i++) {
            result.append(data[i]);
            if (i != size - 1) {
                result.append(",");
            }
        }
        result.append("]");
        return result.toString();
    }
}