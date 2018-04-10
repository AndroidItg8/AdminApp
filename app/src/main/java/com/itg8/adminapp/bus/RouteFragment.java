package com.itg8.adminapp.bus;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.itg8.adminapp.R;
import com.itg8.adminapp.common.GenericAdapter;
import com.itg8.adminapp.common.OnRecyclerItemClickListener;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RouteFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RouteFragment extends Fragment implements OnRecyclerItemClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    Unbinder unbinder;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public RouteFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment RouteFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static RouteFragment newInstance(String param1, String param2) {
        RouteFragment fragment = new RouteFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_route, container, false);
        unbinder = ButterKnife.bind(this, view);
        initView();
        return view;
    }

    private void initView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setNestedScrollingEnabled(false);

        recyclerView.setAdapter( new GenericAdapter<Object,RouteViewHolder>(new ArrayList(),20) {
            @Override
            public RouteViewHolder setViewHolder(ViewGroup parent, OnRecyclerItemClickListener listener) {
                RouteViewHolder view = new RouteViewHolder(LayoutInflater.from(getContext()).inflate(R.layout.item_rv_route, parent, false));
                view.setListener(listener);
                return view;
            }

            @Override
            public void onBindData(RouteViewHolder holder, Object val) {

//                if(holder.getAdapterPosition()==0)
//                {
//                    holder.lineTop.setVisibility(View.GONE);
//                }else
//                {
//                    holder.lineTop.setVisibility(View.VISIBLE);
//
//                }
//
//                if(holder.getAdapterPosition()==20)
//                {
//                    holder.lineBottom.setVisibility(View.GONE);
//
//
//                }else
//                {
//                    holder.lineBottom.setVisibility(View.VISIBLE);
//
//                }
            }


            @Override
            public OnRecyclerItemClickListener getListener() {
                return RouteFragment.this;
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onItemClicked(View view, int position) {

    }
}
