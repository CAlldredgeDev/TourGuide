package com.example.android.tour_guide2;

import android.support.v7.app.AppCompatActivity;

public class Location extends AppCompatActivity {
    private String mTitle;
    private int mImageResourceID;
    private String mDate;
    private String mAddress;
    private float mLat;
    private float mLng;
    private int mZoom;
    //Title, Background Image, Date of Event
    public Location(String title, int imageResourceID, String date) {
        mTitle = title;
        mImageResourceID = imageResourceID;
        mDate = date;
    }

    //Now with Address
    public Location(String title, int imageResourceID, String date, String address) {
        mTitle = title;
        mImageResourceID = imageResourceID;
        mDate = date;
        mAddress = address;
    }

    //Now with Map intent
    public Location(String title, int imageResourceID, String date, String address, float latitude, float longitude, int zoom) {
        mTitle = title;
        mImageResourceID = imageResourceID;
        mDate = date;
        mAddress = address;
        mLat = latitude;
        mLng = longitude;
        mZoom = zoom;
    }

    //TODO implement other constructors for including maps and sounds


    public String getmTitle() {
        return mTitle;
    }

    public int getmImageResourceID() {
        return mImageResourceID;
    }

    public String getmAddress() {
        return mAddress;
    }

    public String getmDate() {
        return mDate;
    }
}

