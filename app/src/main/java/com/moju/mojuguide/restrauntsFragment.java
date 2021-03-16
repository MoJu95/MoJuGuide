package com.moju.mojuguide;

import android.annotation.SuppressLint;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class restrauntsFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        final ArrayList<Attractions> restraunts = new ArrayList<>();

        final String[] restrauntNames = getResources().getStringArray(R.array.restraunts_names);
        final String[] restruantAddresses = getResources().getStringArray(R.array.restraunts_addresses);
        final String[] restrauntVisitors = getResources().getStringArray(R.array.restraunts_visitors);
        @SuppressLint("Recycle") final TypedArray restrauntImages = getResources().obtainTypedArray(R.array.restraunts_images);

        for  (int id = 0; id != restrauntNames.length; ++id) {
            Attractions newEvent = new Attractions(restrauntNames[id], restruantAddresses[id],
                    restrauntVisitors[id], restrauntImages.getDrawable(id));
            restraunts.add(newEvent);
        }

        AttractionsAdapter adapter = new AttractionsAdapter(getActivity(), restraunts);

        ListView listView = rootView.findViewById(R.id.list_fragments);

        listView.setAdapter(adapter);

        return rootView;
    }
}
