package com.ozy.adapter;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.view.View;


/**
 * Created by WORK on 2016/8/8.
 */

public abstract class BindingHolder<Item, Binding extends ViewDataBinding> extends ItemHolder<Item> {

    public final Binding binding;

    public BindingHolder(View v) {
        super(v);
        binding = DataBindingUtil.bind(v);

    }

}