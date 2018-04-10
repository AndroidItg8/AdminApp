package com.itg8.adminapp.bus;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.itg8.adminapp.R;
import com.itg8.adminapp.common.OnRecyclerItemClickListener;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Android itg 8 on 4/10/2018.
 */

public class RouteViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    @BindView(R.id.lbl_address)
    TextView lblAddress;
    @BindView(R.id.lbl_time)
    TextView lblTime;
    @BindView(R.id.line_top)
    View lineTop;
    @BindView(R.id.img_time_line)
    ImageView imgTimeLine;
    @BindView(R.id.line_bottom)
    View lineBottom;
    @BindView(R.id.rl_time)
    RelativeLayout rlTime;
    @BindView(R.id.lbl_student_count)
    TextView lblStudentCount;
    private OnRecyclerItemClickListener listener;

//    R.layout.item_rv_route

    public RouteViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        itemView.setOnClickListener(this);
    }

    public void setListener(OnRecyclerItemClickListener listener) {
        this.listener = listener;
    }

    @Override
    public void onClick(View view) {


        listener.onItemClicked(view, getAdapterPosition());
    }

}