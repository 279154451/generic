package com.example.singlecode.generic.generic.ginterface;

import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;

import com.example.singlecode.generic.generic.TopBean;
import com.example.singlecode.generic.generic.gclass.BaseClass;

/**
 * 创建时间：2019/5/3
 * 创建人：czf
 * 功能描述：
 **/
public class RecyclerAdapter implements Adapter {
    private AdapterItemListener<TopBean> listener;

    private AdapterItemListener<BaseClass> itemListener;
    public void setTopBeanItemListener(AdapterItemListener<TopBean> listener) {
        this.listener = listener;
    }

    public void setBaseClassItemListener(AdapterItemListener<BaseClass> listener){
        itemListener = listener;
    }
    @Override
    public void registerDataSetObserver(DataSetObserver observer) {

    }

    @Override
    public void unregisterDataSetObserver(DataSetObserver observer) {

    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }

    @Override
    public int getItemViewType(int position) {
        return 0;
    }

    @Override
    public int getViewTypeCount() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }
}
