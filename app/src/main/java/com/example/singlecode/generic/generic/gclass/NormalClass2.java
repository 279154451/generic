package com.example.singlecode.generic.generic.gclass;

/**
 * 这也是一个能够存储不同类型数据的类，
 * java中的所有对象都是Object子类，而利用Java的多态、继承特性就可以完成这样的存储所有子类型的数据。
 * 但是这样和泛型有什么区别呢？
 *  最大的区别就是这样存储是类型不安全的。什么叫类型不安全呢？
 *  就是在编译时，并不会像泛型一样进行数据类型检测。而在取数据时需要我们自己去进行数据类型判断和强制转换。是不是一下子感觉好鸡肋？
 *  而泛型类就不需要担心这些，泛型类在编译期就会进行类型检测，
 *  同时由于他在编译期已经做过类型检测了，所以在取数据时也就不再需要我们手动进行类型强制转换了
 */
public class NormalClass2 {
    private Object data;
    public NormalClass2(Object data){
        this.data = data;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
