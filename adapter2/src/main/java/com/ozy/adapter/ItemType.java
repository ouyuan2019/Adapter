package com.ozy.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by WORK on 2016/8/8.
 */
public final class ItemType<Holder extends ItemHolder> {
    public final Class<Holder> clazz;
    public final Class itemClazz;
    public final int resId;
    public final int type;

    public ItemType(Class<Holder> clazz, int resId, int type, Class itemClazz) {
        this.clazz = clazz;
        this.resId = resId;
        this.type = type > 0?type:resId;
        this.itemClazz = itemClazz;
    }

    public ItemType(Class<Holder> clazz, int resId, int type) {
        this(clazz, resId, resId, (Class)null);
    }

    public ItemType(Class<Holder> clazz, int resId) {
        this(clazz, resId, 0, (Class)null);
    }

    public ItemType(Class<Holder> clazz) {
        this(clazz, ((ItemLayout)clazz.getAnnotation(ItemLayout.class)).value(), 0, itemClass(clazz));
    }

    private static <Holder> Class itemClass(Class<Holder> clazz) {
        ItemClass itemClass = (ItemClass)clazz.getAnnotation(ItemClass.class);
        return itemClass == null?null:itemClass.value();
    }

    public Holder newInstance(View view) {
        try {
            return (Holder) this.clazz.getConstructor(new Class[]{View.class}).newInstance(new Object[]{view});
        } catch (InvocationTargetException var3) {
            var3.printStackTrace();
        } catch (NoSuchMethodException var4) {
            var4.printStackTrace();
        } catch (InstantiationException var5) {
            var5.printStackTrace();
        } catch (IllegalAccessException var6) {
            var6.printStackTrace();
        }

        return null;
    }

    public Holder inflate(ViewGroup parent) {
        return this.newInstance(LayoutInflater.from(parent.getContext()).inflate(this.resId, parent, false));
    }
}

