package com.example.singlecode.generic;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.singlecode.generic.generic.TopBean;
import com.example.singlecode.generic.generic.gclass.BaseClass;
import com.example.singlecode.generic.generic.gclass.GenericClass1;
import com.example.singlecode.generic.generic.gclass.GenericClass2;
import com.example.singlecode.generic.generic.gclass.GenericClassTop;
import com.example.singlecode.generic.generic.gclass.GenericSuper;
import com.example.singlecode.generic.generic.ginterface.AdapterItemListener;
import com.example.singlecode.generic.generic.ginterface.RecyclerAdapter;
import com.example.singlecode.generic.generic.gmethod.GenericMethod;

import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /**
         * 这里我们通过一个泛型类，存储了不同类型的键值对数据，有效的避免了每次都创建不同的类来存储对应类型的数据，
         * 完成了存储与数据类型的间接解绑（并没有真的解绑，只是通过泛型类型来指向对应的数据类型，泛型类型与数据类型直接绑定，
         * 这种方式就叫作类型参数化：数据类型通过泛型类型参数来指定，使用时通过外部传参来完成类型绑定）。
         *
         * 使用时必须通过<具体类型，具体类型> 来指定容器的类型。
         */
        GenericClass2<String,String> stringGenericClass2 = new GenericClass2<>("key","value");
        GenericClass2<Integer,String> integerStringGenericClass2 = new GenericClass2<>(1,"value");
        GenericClass2<Integer,Integer> integerGenericClass2 = new GenericClass2<>(1,1);
        //存储完数据后，再依次去除其中value值
        int value = integerGenericClass2.getValue();
        String values = integerStringGenericClass2.getValue();
        String value3 = stringGenericClass2.getValue();

        /**
         * 这里取value时，直接编译异常了。直接在编译期就进行了类型检测，
         *  发现存储的value类型和要赋值的变量类型不一致，直接编译不通过。是不是更方便？
         */
//        int value4 = stringGenericClass2.getValue();

        /**
         * 这里面的TopBean必须是BaseClass的子类，并且实现了BaseInterface接口，否则进行泛型类指定类型时直接编译错误。
         */
        TopBean bean = new TopBean();
        GenericClassTop<TopBean> beanGenericClassTop = new GenericClassTop<>(bean);
//        TopBean[] beans = new TopBean[10]; //这里我们定义并创建了一个大小为10的topBean对象数组，它的成员变量是TopBean对象
//
//        GenericClassTop<TopBean>[] classTops;//这里我们定义一个泛型类数组，它的成员变量是GenericClassTop<TopBean>结构。
//        classTops = new GenericClassTop<TopBean> [10];//但是如果你想去创建并初始化一个这样的数组是不被允许的，直接编译错误，这是因为泛型是不允许进行创建数组的

        //那个这里有一个问题，这里的TopBean是BaseClass的子类。那么这种父子关系是否能够延续到泛型类中呢？
        TopBean topBean = new TopBean();
        BaseClass baseClass  = new BaseClass();
        GenericClass1<TopBean> topBeanGenericClass1 = new GenericClass1<>(topBean);
        GenericClass1<BaseClass> baseClassGenericClass1 = new GenericClass1<>(baseClass);
        //这里直接编译错误了，为什么呢？那是因为GenericClass1<TopBean>和GenericClass1<BaseClass> 是没有任何继承关系的，
        // 也就是说这种继承关系并不会延续到泛型类上面来。
        GenericClass1<BaseClass> topBeanGenericClass2 = new GenericClass1<>(topBean);
        ;
        //可能有些朋友又糊涂了，那么下面这个又不会报错了呢？不是说继承关系不会延续到泛型类里面来吗？有这个问题的可以这样来理解：
        // topBean是baseClass的子类，这里的setData方法的参数可以替换成泛型类定义时所指定的具体参数类型，也就是BaseClass，
        // 也就是说这里的参数类型已经和普通类一样参数类型是固定的了。
        // 那么TopBean又是这个固定类型BaseClass的子类，所以当然能够直接进行替换啦！
         baseClassGenericClass1.setData(topBean);

         //Java中我们可以通过instanceof来判断对象是某个类型，或者是否有继承关系
        if(topBean instanceof TopBean){

        }

        if(topBean instanceof BaseClass){

        }
        //但是在泛型中是不允许使用instanceof关键字的,如下面这三种都直接编译错误，是不被允许的
        if(topBeanGenericClass1 instanceof GenericClass1<TopBean>){

        }
        if(topBeanGenericClass1 instanceof GenericClass1<T>){

        }
        if(topBeanGenericClass1 instanceof GenericClass1<BaseClass>){

        }
        /**
         * 这里我们在使用时通过定义来进行泛型参数与具体数据类型的绑定，然后我们只需要在Adapter中添加设置监听的方法即可，完美实现一个接口能够对不同数据结构的列表的监听
         */
        AdapterItemListener<TopBean> itemListener = new AdapterItemListener<TopBean>() {
            @Override
            public void onItemClick(int position, TopBean item) {

            }

            @Override
            public void onLongItemClick(int position, TopBean item) {

            }
        };
        AdapterItemListener<String> itemListener2 = new AdapterItemListener<String>() {
            @Override
            public void onItemClick(int position, String item) {

            }

            @Override
            public void onLongItemClick(int position, String item) {

            }
        };
        AdapterItemListener<BaseClass> itemListener3 = new AdapterItemListener<BaseClass>() {
            @Override
            public void onItemClick(int position, BaseClass item) {

            }

            @Override
            public void onLongItemClick(int position, BaseClass item) {

            }
        };
        RecyclerAdapter recyclerAdapter = new RecyclerAdapter();//这是我们用来展示数据列表的Adapter适配器

        recyclerAdapter.setTopBeanItemListener(itemListener);
        //这里由于itemListener2所绑定的数据类型是String，而Adapter的设置方法中的接口所绑定的数据类型是TopBean,俩者不一致所以直接编译错误。
        recyclerAdapter.setTopBeanItemListener(itemListener2);


       //前面我们在讲泛型类的时候有说到泛型类的泛型参数的继承关系不会延续到泛型类中，泛型接口同样有这个限制。 如下代码，第二个setBaseClassItemListener
        //方法直接编译错误，虽然TopBean是BaseClass的子类，但是接口 AdapterItemListener<TopBean>和接口AdapterItemListener<BaseClass>没有半点关系。
        recyclerAdapter.setBaseClassItemListener(itemListener3);
        recyclerAdapter.setBaseClassItemListener(itemListener);
        GenericMethod method = new GenericMethod();
        method.deleteMethod(1);
        //直接编译错误，因为泛型类型不能够指定为基础数据类型的
        GenericClass1<double> doubleGenericClass1  = new GenericClass1<>(1.0);
        //但是可以指定为基础数据类型的包装类型
        GenericClass1<Double> doubleGenericClass2  = new GenericClass1<>(1.0);
        //有的同学可能就要问了，为什么包装类型就可以呢？这个问题可以这样去理解：
        //基础数据类型不是一个类型，而包装类型是个类对象，泛型类型必须于类对象进行绑定

        String genericName1 = doubleGenericClass1.getClass().getName();
        String genericName2 = doubleGenericClass2.getClass().getName();
        String genericName3 = topBeanGenericClass2.getClass().getName();
        //这里获取到的三个类名是相等的都是"com.example.singlecode.generic.generic.gclass.GenericClass1"。
        // 而com.example.singlecode.generic.generic.gclass.GenericClass1就是这个泛型类的原生类型
        //泛型原生类型与泛型无任何关系，所以不管泛型类绑定的数据类型是什么，getClass()返回的原生类型都不会发生变化。
        //前面在讲泛型类的继承关系时，我们说泛型所绑定的数据类型TopBean与BassClass的继承关系不会延续到泛型类中来的，
        // 而GenericClass1<TopBean>和GenericClass1<BaseClass>是没有任何继承关系的。
        //前面我们又说了泛型类是可以继承和扩展的。

        GenericMethod genericMethod = new GenericMethod();
        genericMethod.getData(topBeanGenericClass1);
        genericMethod.getData(baseClassGenericClass1);

        genericMethod.getData1(topBeanGenericClass1);
        genericMethod.getData1(baseClassGenericClass1);

        GenericSuper<BaseClass> baseClassGenericSuper = new GenericSuper<>();
        GenericSuper<TopBean> beanGenericSuper = new GenericSuper<>();
        genericMethod.genericSuper(baseClassGenericSuper);
        genericMethod.genericSuper(beanGenericSuper);//入参的泛型类所绑定的参数类型只能是BaseClass自身或是BaseClass的父类，所以这里会编译错误
    }
}
