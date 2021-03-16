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

public class attractionsFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        final ArrayList<Attractions> attractions = new ArrayList<>();

        final String[] attractionsNames = getResources().getStringArray(R.array.attraction_names);
        final String[] attractionsAddresses = getResources().getStringArray(R.array.attraction_addresses);
        final String[] attractionsVisitors = getResources().getStringArray(R.array.attraction_visitors);
        @SuppressLint("Recycle") final TypedArray attractionsImages = getResources().obtainTypedArray(R.array.attraction_images);

        for  (int id = 0; id != attractionsNames.length; ++id) {
            Attractions newEvent = new Attractions(attractionsNames[id], attractionsAddresses[id],
                    attractionsVisitors[id], attractionsImages.getDrawable(id));
            attractions.add(newEvent);
        }

        AttractionsAdapter adapter = new AttractionsAdapter(getActivity(), attractions);

        ListView listView = rootView.findViewById(R.id.list_fragments);

        listView.setAdapter(adapter);

        return rootView;
    }
}
