package com.example.android.tour_guide2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class Location extends AppCompatActivity implements OnMapReadyCallback {
    private String mTitle;
    private int mImageResourceID;
    private String mDate;
    private String mAddress;
    private GoogleMap mMap;
    private float mLat;
    private float mLng;

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

    //Now with Map
    public Location(String title, int imageResourceID, String date, String address, GoogleMap mapFragment, float latitude, float longitude) {
        mTitle = title;
        mImageResourceID = imageResourceID;
        mDate = date;
        mAddress = address;
        mMap = mapFragment;
        mLat = latitude;
        mLng = longitude;
    }

    //TODO implement other constructors for including maps and sounds
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        mMap = googleMap;
        // Add a marker in River Front Park and move the camera
        //TODO remember to replace the lat long var with members from the location class to be created.
        LatLng RFP = new LatLng(mLat, mLng);
        mMap.addMarker(new MarkerOptions().position(RFP).title("WaterFront Park"));
        //Note that latLngZoom used to focus on location. 15 seems to give the best detail for this.
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(RFP, 15));
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

    public GoogleMap getmMap() {
        return mMap;
    }
}

