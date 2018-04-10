package com.itg8.adminapp.home;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.itg8.adminapp.R;
import com.itg8.adminapp.teachers.TeachersFragment;

public class SimpleFragmentPagerAdapter extends FragmentPagerAdapter {

    private Context mContext;

    public SimpleFragmentPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    // This determines the fragment for each tab
    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new TeachersFragment();
        } else if (position == 1){
            return new TeachersFragment();
        } else if (position == 2){
            return new TeachersFragment();
        } else {
            return new TeachersFragment();
        }
    }

    // This determines the number of tabs
    @Override
    public int getCount() {
        return 4;
    }

    // This determines the title for each tab
    @Override
    public CharSequence getPageTitle(int position) {
//        // Generate title based on item position
//        switch (position) {
//            case 0:
//                return mContext.getString(R.string.category_usefulinfo);
//            case 1:
//                return mContext.getString(R.string.category_places);
//            case 2:
//                return mContext.getString(R.string.category_food);
//            case 3:
//                return mContext.getString(R.string.category_nature);
//            default:
//                return null;
//        }
        return "";
    }

    public View getTabView(int position) {
        // Given you have a custom layout in `res/layout/custom_tab.xml` with a TextView and ImageView
        View v = LayoutInflater.from(mContext).inflate(R.layout.tab_custom_item, null);
        TextView tv = (TextView) v.findViewById(R.id.text_title);
        tv.setText("Title");
        TextView tv2 = (TextView) v.findViewById(R.id.txtValue);
        tv2.setText("24000");
        CardView.LayoutParams view = new CardView.LayoutParams(350, 500);
        v.setLayoutParams(view);
        view.setMargins(50,150,50,0);
//        v.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));

        return v;
    }

}
