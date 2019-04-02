package com.example.singlecode.generic;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.singlecode.generic.generic.TopBean;
import com.example.singlecode.generic.generic.gclass.GenericClass2;
import com.example.singlecode.generic.generic.gclass.GenericClassTop;

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
    }
}
