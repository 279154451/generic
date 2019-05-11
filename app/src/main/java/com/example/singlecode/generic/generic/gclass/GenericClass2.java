package com.example.singlecode.generic.generic.gclass;

import java.util.List;

/**
 * 这是一个泛型类
 * @param <K>
 * @param <V>
 */
public class GenericClass2<K,V> {
    private K key;//key 的类型不确定，暂定泛型K,
    private V value;//value的泛型不确定，暂定V. 可能有人会说，啊，你怎么就知道怎么要定义这个数据的泛型是K 还是V 呢？
                    // 这里我只能说，这个泛型的类型怎么定义，随你高兴怎么定义就怎么定义。但是一般在开发中约定俗成的都用T 、E、K、V、M

    /**
     * 这是这个泛型类的构造函数
     * @param key //对应私有变量的key值类型K
     * @param value//对应私有变量的value值类型V
     *
     *  这时候，只要有一个键值对的数据需要存储，我们都只需要new一个泛型类实例就解决了，再也不用根据键值对的类型创建不同的类了。
     *    那么到底怎么用呢？
     */
    public GenericClass2(K key,V value){
        this.key = key;
        this.value = value;
    }
    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }
    
}
