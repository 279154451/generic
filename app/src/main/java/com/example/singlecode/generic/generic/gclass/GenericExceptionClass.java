package com.example.singlecode.generic.generic.gclass;

/**
 * 创建时间：2019/4/21
 * 创建人：czf
 * 功能描述：演示泛型类不能继承异常
 **/
public class GenericExceptionClass  {

    public void catchException(){//外部通过try/catch语句进行异常捕获
        try {
            doWork();
        } catch (ExClass1 exClass1) {
            exClass1.printStackTrace();
        }
    }
    public void doWork() throws ExClass1 {//这是一个会抛出自定义异常的方法
        throw new ExClass1();
    }
    private class ExClass1 extends Exception{//这是自定义的一个异常类

    }
//    private class ExpClass2<T> extends Exception{//这里出现了编译错误，泛型类无法继承Exception
//
//    }
//    private class ExpClass3{
//
//        public <T extends  Throwable> void doWork(T e){
//            try {
//
//            }catch (T e){//这里就出现了编译错误，无法实现对泛型类对象的捕获
//
//            }
//        }
//    }
//    那么泛型类中的异常如何捕获呢？
    public<T extends Throwable> void catchThrowable(T e) throws T{
        try {

        }catch (Throwable throwable){//这里直接通过捕获Throwable,然后将泛型异常通过Throw抛出去，再由外部捕获这个泛型指向的具体异常就可以了
            throw e;
        }
    }
}
