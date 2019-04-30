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
public class GetRequestPauseTripFragment extends Fragment {


    public GetRequestPauseTripFragment() {
        // Required empty public constructor
    }

View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_get_request_pause_trip, container, false);
        return view;
    }

}
