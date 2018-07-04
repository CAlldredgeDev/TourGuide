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

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LocationViewHolder vh;

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(
                    R.layout.location_detail_layout, parent, false);
            vh = new LocationViewHolder(convertView);
            convertView.setTag(vh);
        } else {
            vh = (LocationViewHolder) convertView.getTag();
        }
        Location currentLocation = (Location) getItem(position);

        vh.mTitle.setText(currentLocation.getmTitle());
        vh.mImageResourceID.setImageResource(currentLocation.getmImageResourceID());
        vh.mDate.setText(currentLocation.getmDate());
        vh.mAddress.setText(currentLocation.getmAddress());

        return convertView;
    }

    //Use the ViewHolder pattern.
    public class LocationViewHolder {
        TextView mTitle;
        ImageView mImageResourceID;
        TextView mDate;
        TextView mAddress;

        LocationViewHolder(View v) {
            mTitle = (TextView) v.findViewById(R.id.event_name);
            mImageResourceID = (ImageView) v.findViewById(R.id.event_image);
            mDate = (TextView) v.findViewById(R.id.event_date);
            mAddress = (TextView) v.findViewById(R.id.address);
        }
    }
}

