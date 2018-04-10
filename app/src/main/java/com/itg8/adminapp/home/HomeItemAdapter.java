package com.itg8.adminapp.home;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.itg8.adminapp.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Android itg 8 on 4/9/2018.
 */

public class HomeItemAdapter extends RecyclerView.Adapter<HomeItemAdapter.ViewHolder> {




    private Context context;
    private List<String> list;
    private itemClickedListner listner;

    public HomeItemAdapter(Context context, List<String> list, itemClickedListner listner) {

        this.context = context;
        this.list = list;
        this.listner = listner;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_rv_home_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.lbl_title)
        TextView lblTitle;
        @BindView(R.id.lbl_count_Value)
        TextView lblCountValue;
        @BindView(R.id.cardView)
        CardView cardView;


        public ViewHolder(final View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {



                    listner.ItemClicked(getAdapterPosition(), list.get(getAdapterPosition()), cardView);

                }
            });
        }
    }

    public interface itemClickedListner {
        void ItemClicked(int position, String item, android.support.v7.widget.CardView cardView );
    }
}
