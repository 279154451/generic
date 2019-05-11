package com.example.singlecode.generic.generic.gclass;

import com.example.singlecode.generic.generic.TopBean;

/**
 * 创建时间：2019/4/2
 * 创建人：czf
 * 功能描述：这是一个被指定了上界的泛型类
 * 也就是说这个泛型类的泛型参数只能够是BaseClass或者是BaseClass的子类，并且实现了BaseInterface接口。
 * 注意这里extends 后面第一个必须是类，之后可以跟多个& 接口。这种写法也符合Java的特性：只能有一个extends 继承，多个implements实现
 **/
public class GenericClassTop<T extends BaseClass & Baseinterface> {
    private T data;

    public GenericClassTop(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
