package com.example.singlecode.generic.generic.gclass;

import android.text.TextUtils;

public class GenericClass1<T extends Baseinterface> {
    private T data;
    /**
     * 泛型是不能够实例化的，只能够通过外部先进行数据类型绑定再传具体值的方式初始化
     */
    public void newData(){
//        this.data = new T();//这里直接编译错误，因为泛型不能够实例化
    }

    /**
     * 泛型类的泛型不能够在静态域中引用
     * 那么为什么不能够在静态域中引用泛型类的泛型呢？
     * 因为静态域属于类，而不属于对象，这又是什么意思呢？
     *泛型类的泛型类型在对象创建时才能够知道，虚拟机在创建一个对象时，会先执行static代码，然后再执行
     * 类的构造方法。而一个对象的创建是在执行完构造方法后才完成的，所以static代码块在对象创建之前执行（也就是属于类）
     * 此时静态域中根本就不知道这个泛型类的泛型类型具体是什么。
     */
//    private static T code;

    /**
     * 同理静态方法也是属于类，不能够直接引用泛型
     * @return
     */
//    public static  T getCode(){
//        return T;
//    }

    /**
     * 下面的两个个方法就不受限制，我把这样的方法叫做：静态泛型方法
     * 但是如果静态方法本身也是泛型方法的话，就没有问题，可能有的同学就和我一样有点懵了，这又是为什么呢？
     * 因为泛型方法是在执行时指定具体类型，能使方法独立于类而产生变化。他所引用的泛型是方法自身的泛型，而不是泛型类的泛型。
     * 也就是说如果你想在静态方法中引用泛型，唯一的方法就是将静态方法同时变成泛型方法。
     * @param coe
     * @param <E>
     * @return
     */
    public static <E> String  getCode(E coe){
        TextUtils.equals()
        return "";
    }
    public static <E> E  getCode1(E coe){

        return coe;
    }

    /**
     * 这就是一个再普通不过的泛型方法。泛型方法将再下一章详细讲解
     * @param coe
     * @param <E>
     * @return
     */
    public  <E>  E  getCode2(E coe){
        return coe;
    }


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
