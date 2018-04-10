package com.itg8.adminapp.common;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public abstract class GenericAdapter<T,E extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<E> {
    private List<T> items;
    private int count;
    private OnRecyclerItemClickListener listener;

    public abstract E setViewHolder(ViewGroup parent, OnRecyclerItemClickListener listener);
    public abstract void onBindData(E holder, T val);
    public abstract OnRecyclerItemClickListener getListener();

    public GenericAdapter(List<T> items){
        this.items = items;
        listener = getListener();
    }
    public GenericAdapter(List<T> items, int count){
        this.items = items;
        this.count = count;
        listener = getListener();
    }

    @Override
    public E onCreateViewHolder(ViewGroup parent, int viewType) {
        E holder=setViewHolder(parent,listener);
        return holder;
    }

    @Override
    public void onBindViewHolder(E holder, int position) {
        if(count==0)
            onBindData(holder,items.get(position));
    }

    @Override
    public int getItemCount() {
        return count!=0?count:items.size();
    }

    public void setItems(List<T> items){
        this.items=items;
        this.notifyDataSetChanged();
    }

    public T getItem(int position){
        return items.get(position);
    }



}
