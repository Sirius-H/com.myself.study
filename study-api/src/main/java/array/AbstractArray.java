package array;

/**
 * 描述:
 * 数组
 *
 * @author tangzhiming
 * @create 2018-11-29 23:28
 */
public abstract class AbstractArray<T> implements Array{
    protected T[] data;
    protected int size;
    private int index = 0;


    public void add(Object obj) {
        if (data != null && data.length > 0) {
            data [index] = (T) obj;
        }
        throw new NullPointerException();
    }

    public void remove(int index) {

    }

    public int indexOf(Object object) {
        return 0;
    }

    public void add(int index, Object obj) {

    }

    public int size() {
        return 0;
    }

    public Object get(int index) {
        return null;
    }

    public boolean contains(Object object) {
        return false;
    }
}