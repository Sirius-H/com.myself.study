package map;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

/**
 * 描述:
 *
 * @author tangzhiming
 * @create 2019-11-22 15:49
 */
public class SiriusMap<K,V> implements Map {

    //最大容量 2的30次方
    private static final int MAX_SIZE = 1 >>>30;

    //默认容量 也是最小容量 不能小于2的幂
    private static final int DEFAULT_SIZE = 16;

    private static final float LOAD_FACTOR = 0.75f;

    private int size;

    private int threshold;

    private int modCount;

    //负载因子0.75
    private float loadFactor = LOAD_FACTOR;

    //默认大小16
    private Entity[] table = new Entity[DEFAULT_SIZE];

    public SiriusMap() {
        this(DEFAULT_SIZE);
    }

    public SiriusMap(int initialCapacity) {
        this(initialCapacity,LOAD_FACTOR);
    }


    public SiriusMap(int initialCapacity, float loadFactor) {
        if (initialCapacity <= 0){
            throw new IllegalArgumentException("参数异常");
        }

        //参数校验 比如找到大于 initialCapacity 的最小2次幂
        int capacity = 1;
        while (capacity < initialCapacity) {
            capacity <<= 1;
        }

        //参数赋值
        //阈值 当超过这个值之后 要触发rehash和resize
        this.threshold = (int)(capacity * loadFactor);
        //初始容量
        this.table = new Entity[capacity];

    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean containsKey(Object key) {
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        return false;
    }

    @Override
    public Object get(Object key) {
        return null;
    }

    @Override
    public Object put(Object key, Object value) {
        return null;
    }

    @Override
    public Object remove(Object key) {
        return null;
    }

    @Override
    public void putAll(Map m) {

    }

    @Override
    public void clear() {

    }

    @Override
    public Set keySet() {
        return null;
    }

    @Override
    public Collection values() {
        return null;
    }

    @Override
    public Set<Entry> entrySet() {
        return null;
    }



    private final class Entity<K,V> implements Serializable {
        private K key;

        private V value;

        private Entry<K,V> next;

        public Entity(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public void setNext(Entry<K, V> next) {
            this.next = next;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public Entry<K, V> getNext() {
            return next;
        }
    }
}