package com.example.singlecode.generic.generic.ginterface;

/**
 * 这是一个多泛型参数的泛型接口，泛型接口和泛型类一样都是可以有多个泛型参数的。具体的参数类型在具体使用时绑定
 * @param <T>
 * @param <M>
 */
public interface GenericInterface<T,M> {
    void addT(T data);
    void deleteT(T data);
    void addM(M data);
    void deleteM(M data);
}
