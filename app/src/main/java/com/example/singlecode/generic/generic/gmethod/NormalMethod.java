package com.example.singlecode.generic.generic.gmethod;

/**
 * 这是一个普通类，内部分别有几个普通的set get方法
 * 可以看到，value没增加一种，类型我们就要增加一个方法函数，是不是很累？
 * 那能不能通过一个函数就完成这些操作呢？泛型方法就为我们解决了这样的困扰
 */
public class NormalMethod {

    public int  getValue(int i){
        return i;
    }
    public String getValue(String string){
        return string;
    }
    public void setValue(int value){

    }
    public void setValue(String value){

    }
}
