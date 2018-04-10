package com.itg8.adminapp.bus;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.itg8.adminapp.common.OnRecyclerItemClickListener;

import butterknife.ButterKnife;

/**
 * Created by Android itg 8 on 4/10/2018.
 */

public class BusViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private OnRecyclerItemClickListener listener;
    public BusViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
        itemView.setOnClickListener(this);
    }

    public void setListener(OnRecyclerItemClickListener listener) {
        this.listener = listener;
    }

    @Override
    public void onClick(View view) {


        listener.onItemClicked(view,getAdapterPosition());
    }
}
