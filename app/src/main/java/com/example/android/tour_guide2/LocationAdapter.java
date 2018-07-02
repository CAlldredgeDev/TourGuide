package com.example.android.tour_guide2;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class LocationAdapter extends ArrayAdapter<Location> {
    //Need a var to hold the color ref for our list item background color
    private int mColorResID;

    public LocationAdapter(Activity context, ArrayList<Location> locations) {
        super(context, 0, locations);
        //Map that passed color to the member var.
        //mColorResID = colorResID;
    }

/*
    //Use the ViewHolder pattern.
    static class LocationViewHolder {
        TextView title;
        ImageView imageResourceID;
        TextView date;
    }
*/

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (convertView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.location_detail_layout, parent, false);
        }
        Location currentLocation = (Location) getItem(position);

        TextView mTitle = (TextView) listItemView.findViewById(R.id.event_name);
        mTitle.setText(currentLocation.getmTitle());

        ImageView mImageResID = (ImageView) listItemView.findViewById(R.id.event_image);
        mImageResID.setImageResource(currentLocation.getmImageResourceID());

        TextView mDate = (TextView) listItemView.findViewById(R.id.event_date);
        mDate.setText(currentLocation.getmDate());

        /* TODO this is where color of back ground is defined.
        //Grab the Location object and find the curernt posiition in the arrayList.
        Location currentLocation = (Location) getItem(position);

        //Point to correct layout.
        View textBackground = (View) listItemView.findViewById(R.id.XX);

        //Create the color with ContextCompat's geColor Function.
        int color = ContextCompat.getColor(getContext(), mColorResID;)

        //Finally pass the color int ref to the setBackground function of the View.
        textBackground.setBackgroundColor(Color);*/
        //LocationViewHolder vh = new LocationViewHolder();
        //TODO define the getter methods to fill all the holder items now tied to xml.
        /*vh.title = (TextView) listItemView.findViewById(R.id.event_name);
        vh.title.setText(currentLocation.getmTitle());
        vh.imageResourceID = (ImageView) listItemView.findViewById(R.id.event_image);
        vh.imageResourceID.setImageResource(currentLocation.getmImageResourceID());
        vh.date = (TextView) listItemView.findViewById(R.id.event_date);
        vh.date.setText(currentLocation.getmDate());*/
        return listItemView;
    }
}

