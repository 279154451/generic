package com.example.singlecode.generic.generic.gmethod;

import com.example.singlecode.generic.generic.TopBean;
import com.example.singlecode.generic.generic.gclass.BaseClass;
import com.example.singlecode.generic.generic.gclass.GenericClass1;
import com.example.singlecode.generic.generic.gclass.GenericSuper;

public class GenericMethod {
    /*
    *定义一个泛型方法的语法如下
    * 方法作用域修饰符 <泛型类型> 返回值类型 方法名（泛型）{
    *
    * }
     */
    public <K> K deleteMethod(K value){

        return value;
    }
    public <M> String deleteMethod1(M value){

        return "";
    }


    /**
     * 做Android开发的同学应该后对接过后台接口，后台接口一般都会返回一个json格式的数据，
     * 然后我们解析出数据用来展示。但是很讨厌的是每个接口返回的数据类型都不一样。
     * 那么我们如何只写一个网络请求方法，却能够获取到我们想要的各种数据类型呢。答案就是如下使用泛型方法解决
     * @param tClass
     * @param <T>
     * @return
     */
    public <T> T getHttpResponse(Class<T> tClass){
        try {
            /**
             * 通常这里都是使用oKHttp调用后台接口，获取返回的json数据，
             * 然后再通过Gson或者FastJson转换成入参的Class类型（我们通常称返回的数据类型为xxBean）
             */
            return tClass.newInstance();//这里省去网络接口调用，简单的返回一个对应的Bean结果
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return null;
    }


    public String getResponse(Class<? extends BaseClass> tclass){

        return null;
    }

    /**
     * 前面在讲泛型类的继承关系时，我们说泛型所绑定的数据类型TopBean与BassClass的继承关系不会延续到泛型类中来的，
     * 而GenericClass1<TopBean>和GenericClass1<BaseClass>是没有任何继承关系的。所以这的第一个getData方法传泛型类
     * GenericClass1<TopBean>完全没有问题，但是传GenericClass1<BaseClass>却编译报错了。
     *  那么我们要怎样才能做到，一个get方法能传GenericClass1<TopBean>和GenericClass1<BaseClass>呢
     *  这里泛型的通配符就是为我们解决这种问题的，
     *  如下方法getData1，就可以帮我们实现既可以传GenericClass1<TopBean>又可以传GenericClass1<BaseClass>
     * @param bClass
     * @param <T>
     * @return
     */
    public <T> String getData(GenericClass1<TopBean> bClass){

        return "";
    }
    public String getData1(GenericClass1<? extends BaseClass> bClass){

        return "";
    }


    /**
     * 通过通配符和super组合来指定泛型类的下界
     * 这里的入参的是个泛型类对象，而这个泛型类所绑定的参数被指定了下界，
     * 也就是这个泛型类的泛型参数只能是BaseClass或者是BaseClass的父类
     * @param data
     */
    public void genericSuper(GenericSuper<?  super BaseClass> data){

    }
}
