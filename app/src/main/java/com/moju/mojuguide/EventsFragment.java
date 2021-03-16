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

public class EventsFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        final ArrayList<Attractions> events = new ArrayList<>();

        final String[] eventsNames = getResources().getStringArray(R.array.event_names);
        final String[] eventsAddresses = getResources().getStringArray(R.array.event_addresses);
        final String[] eventsVisitors = getResources().getStringArray(R.array.event_visitors);
        @SuppressLint("Recycle") final TypedArray eventsImages = getResources().obtainTypedArray(R.array.event_images);

        for  (int id = 0; id != eventsNames.length; ++id) {
            Attractions newEvent = new Attractions(eventsNames[id], eventsAddresses[id],
                    eventsVisitors[id], eventsImages.getDrawable(id));
            events.add(newEvent);
        }

        AttractionsAdapter adapter = new AttractionsAdapter(getActivity(), events);

        ListView listView = rootView.findViewById(R.id.list_fragments);

        listView.setAdapter(adapter);

        return rootView;
    }
}
