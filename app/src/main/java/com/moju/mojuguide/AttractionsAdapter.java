package com.moju.mojuguide;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.ArrayList;

public class AttractionsAdapter  extends ArrayAdapter<Attractions>{

    public AttractionsAdapter(Activity context, ArrayList<Attractions> attraction) {
        super(context, 0, attraction);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        if(convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        Attractions currentAttraction = getItem(position);

        TextView localAttractionNameTextView = (TextView) convertView.findViewById(R.id.tv_attraction_name);
        localAttractionNameTextView.setText(currentAttraction.getAttractionName());

        TextView localAttractionAddressTextView = (TextView) convertView.findViewById(R.id.tv_attraction_address);
        localAttractionAddressTextView.setText(currentAttraction.getAttractionAddress());

        TextView localAttractionOpeningHoursTextView = (TextView) convertView.findViewById(R.id.tv_attraction_opening_hours);
        localAttractionOpeningHoursTextView.setText(currentAttraction.getVisitorsPerYear());

        ImageView imageView = (ImageView) convertView.findViewById(R.id.iv_attraction_image);
        imageView.setImageDrawable(currentAttraction.getImageDrawable());

        return convertView;
    }

}