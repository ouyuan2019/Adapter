package com.ozy.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.lang.reflect.Field;


public abstract class ItemHolder<Item> extends RecyclerView.ViewHolder {
    public int position;
    public Item item;
    private static Field ownerRecycleViewField = null;

    public ItemHolder(View itemView) {
        super(itemView);
        itemView.setTag(R.id.ItemHolder_item_holder, this);
    }

    public abstract void refresh();




    public RecyclerView getParent() {
        return getRecycleView(this);
    }

    public static <Holder extends ItemHolder> Holder from(View view) {
        return view == null?null: (Holder) view.getTag(R.id.ItemHolder_item_holder);
    }

    public static <Holder extends ItemHolder> Holder find(RecyclerView parent, Object tag) {
        if(tag == null) {
            return null;
        } else {
            int count = parent.getChildCount();

            for(int i = 0; i < count; ++i) {
                View child = parent.getChildAt(i);
                Object holder = child.getTag(R.id.ItemHolder_item_holder);
                if(tag.equals(holder)) {
                    return (Holder) holder;
                }
            }

            return null;
        }
    }

    private static RecyclerView getRecycleView(RecyclerView.ViewHolder holder) {
        try {
            if(ownerRecycleViewField == null) {

                ownerRecycleViewField = RecyclerView.ViewHolder.class.getDeclaredField("mOwnerRecyclerView");
                ownerRecycleViewField.setAccessible(true);
            }

            return (RecyclerView)ownerRecycleViewField.get(holder);
        } catch (NoSuchFieldException var2) {
            var2.printStackTrace();
        } catch (IllegalAccessException var3) {
            var3.printStackTrace();
        }

        return null;
    }
}
