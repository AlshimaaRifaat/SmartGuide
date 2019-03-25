package com.example.alshimaa.smartguide.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.alshimaa.smartguide.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class OldTripFragment extends Fragment {


    public OldTripFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_old_trips, container, false);
    }

}
