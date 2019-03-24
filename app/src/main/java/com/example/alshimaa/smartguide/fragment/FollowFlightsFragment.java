package com.example.alshimaa.smartguide.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.alshimaa.smartguide.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FollowFlightsFragment extends Fragment {
EditText searchEtext;

    public FollowFlightsFragment() {
        // Required empty public constructor
    }

View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view =inflater.inflate(R.layout.fragment_follow_flights, container, false);
        init();

        searchEtext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().replace(R.id.main_frame_container,new DetailsFollowFlightsFragment())
                        .commit();                    //remove it
            }
        });
        return view;
    }

    private void init() {
        searchEtext=view.findViewById(R.id.follow_flights_edit_text_search);
    }

}
