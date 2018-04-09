package com.itg8.adminapp.home;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.itg8.adminapp.R;
import com.itg8.adminapp.commonMethod.CommonMethod;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment implements ViewPager.OnPageChangeListener, View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    @BindView(R.id.viewPagerHome)
    ViewPager viewPagerHome;
    @BindView(R.id.viewPagerDescription)
    ViewPager viewPagerDescription;
    @BindView(R.id.frame_container)
    FrameLayout frameContainer;
    Unbinder unbinder;
    @BindView(R.id.lbl_header)
    TextView lblHeader;
    @BindView(R.id.img_right)
    ImageView imgRight;
    @BindView(R.id.img_left)
    ImageView imgLeft;
    @BindView(R.id.rl_top)
    RelativeLayout rlTop;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private static final String TAG = "HomeFragment";
    private int position;
    private boolean isLeftClicked=false;
    private boolean isRightClicked=false;


    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
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
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        unbinder = ButterKnife.bind(this, view);
        initView();
        return view;
    }

    private void initView() {
        setOnClickedListner();
        homeViewPager();
        descriptionViewPager();
    }

    private void descriptionViewPager() {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getActivity(), getChildFragmentManager(), CommonMethod.FROM_DESCRIPTION);
        viewPagerDescription.setAdapter(adapter);
    }

    private void homeViewPager() {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getActivity(), getChildFragmentManager(), CommonMethod.FROM_HOME);
        viewPagerHome.setAdapter(adapter);
    }

    private void setOnClickedListner() {
        imgLeft.setOnClickListener(this);
        imgRight.setOnClickListener(this);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        Log.d(TAG, "onPageScrolled: position:"+position+"positionOffset:"+positionOffset+"pospixel"+positionOffsetPixels);
this.position=position;


    }

    @Override
    public void onPageSelected(int position) {
        this.position = position;
        Log.d(TAG, "onPageSelected: Possition"+position);


    }

    @Override
    public void onPageScrollStateChanged(int state) {
        Log.d(TAG, "onPageScrollStateChanged: state"+state);


    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.img_left:
                Log.d(TAG, "onClick: imgLeft");
               isLeftClicked =true;
                setLeftButtonClicked(position);
                break;
            case R.id.img_right:
                Log.d(TAG, "onClick: imgRight");
                isRightClicked =true;
                setRightButtonClicked(position);
                break;
        }
    }

    private void setRightButtonClicked(int position) {
        if(isRightClicked)
        {
            position-=position;
            setLeftButtonClicked(position);

        }
        isRightClicked=!isRightClicked;
    }




    private void setLeftButtonClicked(int position) {
        if(isLeftClicked)
        {
            position+=position;
            viewPagerHome.setCurrentItem(position);
        }
        isLeftClicked=!isLeftClicked;

    }


}
