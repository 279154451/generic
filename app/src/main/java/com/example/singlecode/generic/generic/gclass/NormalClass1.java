package com.example.singlecode.generic.generic.gclass;

/**
 * 这是一个普通的键值对数据结构
 */
public class NormalClass1 {
    private String key;//键的类型为String
    private String value;//值的类型也是String

    /**
     * 这里是他的构造方法
     * @param key 构造参数，类型与私有变量的类型一致。
     * @param value
     *
     * 当有一个键值都是String类型的数据需要存储时，我们就可以new一个这样的对象类存储。
     * 看起来是不是很方便？我们只需要缓存这个对象就完成了数据的缓存。
     * 但是，问题来了。如果这个时候有一个key的类型是Int型，value 是String类型的数据需要缓存呢？更变态点的key的类型不确定，value的类型也不确定。
     * 这个时候我们要怎么存储这样的数据？难道还要一个个对应的去创建Class? 怕是脑子有坑哦
     * 这个时候泛型类就很好的帮我们解决了这样的问题。
     */
    public NormalClass1(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}
