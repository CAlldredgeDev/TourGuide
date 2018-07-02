package com.example.android.tour_guide2;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class LocationPagerAdapter extends FragmentPagerAdapter {

    private Context mContext;

    public LocationPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        //TODO implement other tabs to populate for all the locations
        switch (position) {
            case 0:
                return new ThunderFragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        //TODO count up all the tabs we will have
        return 1;
    }
}


