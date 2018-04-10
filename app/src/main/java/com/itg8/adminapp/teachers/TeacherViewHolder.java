package com.itg8.adminapp.teachers;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.itg8.adminapp.R;
import com.itg8.adminapp.common.OnRecyclerItemClickListener;
import com.itg8.adminapp.widget.CircleImageView;

import butterknife.BindView;
import butterknife.ButterKnife;

class TeacherViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    @BindView(R.id.image_person_profile)
    CircleImageView imagePersonProfile;
    @BindView(R.id.text_name)
    TextView textName;
    @BindView(R.id.text_current_lecture)
    TextView textCurrentLecture;
    private OnRecyclerItemClickListener listener;
//    R.layout.item_teacher_rv

    public TeacherViewHolder(View view) {
        super(view);
        ButterKnife.bind(this,view);
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
