package com.example.singlecode.generic.generic.gclass;

public class GenericClass1<T> {
    private T data;

    public GenericClass1(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
