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
        switch (position) {
            case 0:
                return new EntertainmentFragment();
            case 1:
                return new ConsumableFragment();
            case 2:
                return new SportsFragment();
            case 3:
                return new AcademicFragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return mContext.getString(R.string.entertainment_fragment);
            case 1:
                return mContext.getString(R.string.consumable_fragment);
            case 2:
                return mContext.getString(R.string.sport_fragment);
            case 3:
                return mContext.getString(R.string.academic_fragment);
            default:
                return null;

        }
    }
}


