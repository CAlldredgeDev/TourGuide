package com.example.android.tour_guide2;

public class Location{
    private String mTitle;
    private int mImageResourceID;
    private String mDate;
    private String mAddress;
    private double mLat;
    private double mLng;
    private int mZoom;
    private String mMapPin;
    private String mPinLabel;
    private int mAudioResID;

    //Title, Background Image, Date of Event
    public Location(String title, int imageResourceID, String date) {
        mTitle = title;
        mImageResourceID = imageResourceID;
        mDate = date;
    }

    //Now with Address
    public Location(String title, int imageResourceID, String date, String address, int audioResID) {
        mTitle = title;
        mImageResourceID = imageResourceID;
        mDate = date;
        mAddress = address;
        mAudioResID = audioResID;
    }

    //Now with map and no pin data
    public Location(String title, int imageResourceID, String date, String address, double latitude, double longitude, int zoom, int audioResID) {
        mTitle = title;
        mImageResourceID = imageResourceID;
        mDate = date;
        mAddress = address;
        mLat = latitude;
        mLng = longitude;
        mZoom = zoom;
        mAudioResID = audioResID;
    }

    //Now with Map intent and Pin
    public Location(String title, int imageResourceID, String date, String address, double latitude, double longitude, int zoom, String pinLabel, int audioResID) {
        mTitle = title;
        mImageResourceID = imageResourceID;
        mDate = date;
        mAddress = address;
        mLat = latitude;
        mLng = longitude;
        mZoom = zoom;
        mPinLabel = pinLabel;
        mAudioResID = audioResID;

    }


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

    public double getmLat() {
        return mLat;
    }

    public double getmLng() {
        return mLng;
    }

    public int getmZoom() {
        return mZoom;
    }

    public String getmMapPin() {
        mMapPin = Double.toString(mLat) + ", " + Double.toString(mLng) + ", " + Integer.toString(mZoom);
        return mMapPin;
    }

    public String getmPinLabel() {
        return mPinLabel;
    }

    public int getmAudioResID() {
        return mAudioResID;
    }
}

