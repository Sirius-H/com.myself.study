package com.sirius.array;



public interface Array<T> {
    public void add(Object object);
    public void remove(int index);
    public int indexOf(Object object);
    public void add (int index, Object obj);
    public int size();
    public T get(int index);
    public boolean contains(Object object);
}
