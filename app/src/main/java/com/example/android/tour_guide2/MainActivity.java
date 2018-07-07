package com.example.android.tour_guide2;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

//“Sound effects obtained from https://www.zapsplat.com“
//Image of Gentleman in Library from:
//https://www.flickr.com/photos/renaud-camus/6165559492/in/photolist-aoQ72S-odfqPD-nVLZ9T-nVKVwL-odbsd5-odbszh-of2sgZ-od6hWm-fpMQkn-fpM8R4-fq2ipS-fpMeoM-fpNGct-fq43Yy-ac9fCT-fq2fsQ-pJNfMT-pJyy9R-VGw45C-gVHLDz-eMnmEV-WkpXk7-XyLpbe-VKBVR8-7gMp7L-JR5PE-XyKSaX-25nPHKs-7gHG7t-6q5sDH-5kfKPJ-coS3Xj-7W1xV8-xHJib-Civrq1-pGGUpG-psmrJy-4ZgttC-nPtNWC-pGGUV1-psmdNU-pJSJJJ-nz2HMi-nTiVn6-qAy6gH-URHwra-7AJK49-cKCom-R3zPVx-biryqX
//App built with concepts integrated from Miwok App course work and Music Structure App.
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Set the content of the activity to use the activity_main.xml layout file
        setContentView(R.layout.activity_main);

        // Find the view pager that will allow the user to swipe between fragments
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);

        // Create an adapter that knows which fragment should be shown on each page
        // this is implied in the new method being used on set adapter below
        // Set the adapter onto the view pager
        viewPager.setAdapter(new LocationPagerAdapter(this, getSupportFragmentManager()));
        // Give the TabLayout the ViewPager
        TabLayout tabLayout = (TabLayout) findViewById(R.id.sliding_tabs);
        tabLayout.setupWithViewPager(viewPager);
    }

}