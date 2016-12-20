package com.ozy.adapter;
//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public abstract class BaseAdapter<Item> extends RecyclerView.Adapter<ItemHolder> {
    private List<Item> mItems = new ArrayList();
    private boolean mNotifyOnChange = true;
    View.OnClickListener mOnItemClickListener;
    View.OnLongClickListener mOnItemLongClickListener;

    public BaseAdapter() {
    }

    public void setNotifyOnChange(boolean notifyOnChange) {
        this.mNotifyOnChange = notifyOnChange;
    }

    public void addAll(Collection<Item> items, boolean isClearFirst) {
        if(isClearFirst) {
            this.mItems.clear();
        }

        this.mItems.addAll(items);
        if(this.mNotifyOnChange) {
            this.notifyDataSetChanged();
        }

    }

    public void add(int location, Item object) {
        this.mItems.add(location, object);
        if(this.mNotifyOnChange) {
            this.notifyDataSetChanged();
        }

    }

    public void add(Item object) {
        this.mItems.add(object);
        if(this.mNotifyOnChange) {
            this.notifyDataSetChanged();
        }

    }

    public void addAll(int location, Collection<? extends Item> collection) {
        this.mItems.addAll(location, collection);
        if(this.mNotifyOnChange) {
            this.notifyDataSetChanged();
        }

    }

    public void addAll(Collection<? extends Item> collection) {
        this.mItems.addAll(collection);
        if(this.mNotifyOnChange) {
            this.notifyDataSetChanged();
        }

    }

    public void addAll(Item... items) {
        Collections.addAll(this.mItems, items);
        if(this.mNotifyOnChange) {
            this.notifyDataSetChanged();
        }

    }

    public void insert(Item object, int index) {
        this.mItems.add(index, object);
        if(this.mNotifyOnChange) {
            this.notifyDataSetChanged();
        }

    }

    public void remove(Item object) {
        this.mItems.remove(object);
        if(this.mNotifyOnChange) {
            this.notifyDataSetChanged();
        }

    }

    public Item remove(int location) {
        Item item = this.mItems.remove(location);
        if(this.mNotifyOnChange) {
            this.notifyDataSetChanged();
        }

        return item;
    }

    public void clear() {
        this.mItems.clear();
        if(this.mNotifyOnChange) {
            this.notifyDataSetChanged();
        }

    }

    public void sort(Comparator<? super Item> comparator) {
        Collections.sort(this.mItems, comparator);
        if(this.mNotifyOnChange) {
            this.notifyDataSetChanged();
        }

    }

    public int indexOf(Object object) {
        return this.mItems.indexOf(object);
    }

    public List<Item> getList() {
        return this.mItems;
    }

    public Item getItem(int position) {
        return this.mItems.get(position);
    }

    public int getItemCount() {
        return this.mItems.size();
    }

    public long getItemId(int position) {
        return (long)position;
    }

    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    public void onBindViewHolder(ItemHolder holder, int position) {
        holder.position = position;
        holder.item = this.getItem(position);
        if(holder.getParent() != null) {
            holder.refresh();
        }

    }

    public void onViewRecycled(ItemHolder holder) {
        super.onViewRecycled(holder);
        holder.position = 0;
        holder.item = null;
    }

    public void onViewAttachedToWindow(ItemHolder holder) {
        super.onViewAttachedToWindow(holder);
        holder.refresh();
    }

    public void setOnItemClickListener(View.OnClickListener listener) {
        this.mOnItemClickListener = listener;
    }

    public void setOnItemLongClickListener(View.OnLongClickListener listener) {
        this.mOnItemLongClickListener = listener;
    }

    protected void bindListeners(View view) {
        if(this.mOnItemClickListener != null && !view.hasOnClickListeners()) {
            view.setOnClickListener(this.mOnItemClickListener);
        }

        if(this.mOnItemLongClickListener != null && !view.isLongClickable()) {
            view.setOnLongClickListener(this.mOnItemLongClickListener);
        }

    }
}
