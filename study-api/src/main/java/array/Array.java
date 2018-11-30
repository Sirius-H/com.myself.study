package array;


public interface Array<T> {
    public void add(T object);
    public void remove(int index);
    public int indexOf(T object);
    public void add (int index, T obj);
    public int size();
    public T get(int index);
    public boolean contains(T object);
}
