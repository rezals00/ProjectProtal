package com.example.root.portalproject;


import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by root on 21/11/16.
 */

public class ViewPagerAdapter extends FragmentPagerAdapter {

    final int PAGE_COUNT = 3;
    final Context context;
    public ViewPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {

        Fragment fragment = null;

        switch (position){
            case 0 :
                fragment = HomeFragment.newInstance();
                break;
            case 1 :
                fragment = MobilFragment.newInstance();
                break;
            case 2 :
                fragment = MotorFragment.newInstance();
                break;
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0 :
                return context.getResources().getString(R.string.home);
            case 1 :
                return context.getResources().getString(R.string.mobil);
            case 2 :
                return context.getResources().getString(R.string.motor);
        }
        return null;
    }
}
