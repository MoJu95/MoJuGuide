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

public class publicFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        final ArrayList<Attractions> publicPlaces = new ArrayList<>();

        final String[] publicNames = getResources().getStringArray(R.array.public_names);
        final String[] publicAddresses = getResources().getStringArray(R.array.public_addresses);
        final String[] publicVisitors = getResources().getStringArray(R.array.public_visitors);
        @SuppressLint("Recycle") final TypedArray publicImages = getResources().obtainTypedArray(R.array.public_images);

        for  (int id = 0; id != publicNames.length; ++id) {
            Attractions newAttraction = new Attractions(publicNames[id], publicAddresses[id],
                    publicVisitors[id], publicImages.getDrawable(id));
            publicPlaces.add(newAttraction);
        }

        AttractionsAdapter adapter = new AttractionsAdapter(getActivity(), publicPlaces);

        ListView listView = rootView.findViewById(R.id.list_fragments);

        listView.setAdapter(adapter);

        return rootView;
    }
}
