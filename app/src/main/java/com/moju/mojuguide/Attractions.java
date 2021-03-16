package com.moju.mojuguide;

import android.graphics.drawable.Drawable;

public class Attractions {

    private String mLocalAttractionName;
    private String mLocalAttractionAddress;
    private String mVisitorsPerYear;
    private Drawable mAttractionImg;

    public Attractions(String AttractionName, String AttractionAddress,
                           String visitorsPerYear, Drawable imageDrawable) {
        mLocalAttractionName = AttractionName;
        mLocalAttractionAddress = AttractionAddress;
        mVisitorsPerYear = visitorsPerYear;
        mAttractionImg = imageDrawable;
    }

    public String getAttractionName() {
        return mLocalAttractionName;
    }

    public String getAttractionAddress() {
        return mLocalAttractionAddress;
    }

    public String getVisitorsPerYear() {
        return mVisitorsPerYear;
    }

    public Drawable getImageDrawable() {
        return mAttractionImg;
    }
}
