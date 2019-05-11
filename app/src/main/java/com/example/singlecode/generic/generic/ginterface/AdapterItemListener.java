package com.example.singlecode.generic.generic.ginterface;

/**
 * 创建时间：2019/5/3
 * 创建人：czf
 * 功能描述：这是一个单泛型参数的泛型接口，泛型接口和泛型类一样都是可以有多个泛型参数的。具体的参数类型在具体使用时绑定
 * 定义一个泛型接口语法如下：
 * 接口名<泛型参数、泛型参数...>{
 *
 * }
 **/
public interface AdapterItemListener<T> {

    void onItemClick(int position,T item);

    void onLongItemClick(int position, T item);

}
