package com.itg8.adminapp.teachers;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.itg8.adminapp.common.OnRecyclerItemClickListener;

class TeacherPeriodViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private OnRecyclerItemClickListener listener;

    public TeacherPeriodViewHolder(View view) {
        super(view);
        view.setOnClickListener(this);
    }

    public void setListener(OnRecyclerItemClickListener listener) {
        this.listener = listener;
    }

    @Override
    public void onClick(View view) {
        listener.onItemClicked(view,getAdapterPosition());
    }
}
