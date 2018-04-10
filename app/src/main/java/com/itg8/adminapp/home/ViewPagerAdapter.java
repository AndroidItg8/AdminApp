package com.itg8.adminapp.home;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.itg8.adminapp.common.CommonMethod;


/**
 * Created by Android itg 8 on 4/9/2018.
 */

public class ViewPagerAdapter extends FragmentPagerAdapter {
    private Context _context;
    private final int from;


    public ViewPagerAdapter(Context context, FragmentManager fm, int from) {
        super(fm);
        _context=context;
        this.from = from;
    }




    @Override
    public Fragment getItem(int position) {

        if(position==0){
            if(from== CommonMethod.FROM_HOME)
         return AlertFragment.newInstance("","");
                else
               return AlertDetailsFragment.newInstance("","");
        }
        return AlertFragment.newInstance("","");
    }
    @Override
    public int getCount() {
  return 10;
    }
}
