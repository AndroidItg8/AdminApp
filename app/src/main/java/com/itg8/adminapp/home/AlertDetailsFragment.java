package com.itg8.adminapp.home;


import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.RadioGroup;

import com.itg8.adminapp.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AlertDetailsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AlertDetailsFragment extends Fragment implements HomeItemAdapter.itemClickedListner {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    Unbinder unbinder;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;


    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private List<String> list;
    private Animation anim;
    private HomeItemAdapter adapter;


    public AlertDetailsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AlertDetailsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AlertDetailsFragment newInstance(String param1, String param2) {
        AlertDetailsFragment fragment = new AlertDetailsFragment();
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
        View view = inflater.inflate(R.layout.fragment_alert_details, container, false);
        unbinder = ButterKnife.bind(this, view);
        initRecyclerView();
        return view;
    }

    private void initRecyclerView() {
        anim = AnimationUtils.loadAnimation(getActivity(),R.anim.raisecard);
     list = new ArrayList();
     list.add("abc");
     list.add("abc");
     list.add("abc");
     list.add("abc");
     list.add("abc");
     list.add("abc");
     list.add("abc");
     list.add("abc");
     list.add("abc");
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        adapter=new HomeItemAdapter(getActivity(),list,this);
        recyclerView.setAdapter(adapter);
        recyclerView.setNestedScrollingEnabled(false);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void ItemClicked(int position, String item,  CardView cardView) {
        cardView.startAnimation(anim);
        list.set(0,item);
        adapter.notifyDataSetChanged();
        recyclerView.getLayoutManager().scrollToPosition(0);
    }




}
