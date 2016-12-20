package com.ozy.adapter;

import android.view.ViewGroup;


/**
 * Created by WORK on 2016/8/8.NewMessageHolder
 */

public class ItemAdapter<Item, Holder extends ItemHolder<Item>> extends BaseAdapter<Item> {
    private final ItemType<Holder> mItemType;
    private boolean mHasStableIds;

    public ItemAdapter(Class<Holder> clazz) {
        this(new ItemType(clazz));
    }

    public ItemAdapter(Class<Holder> clazz, int resId) {
        this(new ItemType(clazz, resId));
    }

    public ItemAdapter(ItemType itemType) {
        this.mHasStableIds = false;
        this.mItemType = itemType;
    }

    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        Holder holder = this.mItemType.inflate(parent);
        this.bindListeners(holder.itemView);
        return holder;
    }
}