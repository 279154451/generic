package com.example.singlecode.generic.generic.ginterface;

import com.example.singlecode.generic.generic.gclass.BaseClass;
import com.example.singlecode.generic.generic.gclass.Baseinterface;

/**
 * 创建时间：2019/4/13
 * 创建人：czf
 * 功能描述：这是一个多泛型参数的泛型接口，我们可以看到M是个有下界的泛型参数，在使用具体实参类型替换M时，
 * 实参必须继承自BaseClass或者是BaseClass自身,同样P的下界是个接口，也就是说用实参替换泛型P时实参必须实现了接口BaseInterface
 **/
public interface GenericInterface2<M extends BaseClass, P extends Baseinterface> {
    public void attach(P a, M b);

    public void detach(M a, P b);

    public void normal(String a, String b);
}
