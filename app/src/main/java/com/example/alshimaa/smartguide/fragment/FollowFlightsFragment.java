package com.example.alshimaa.smartguide.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.alshimaa.smartguide.R;
import com.example.alshimaa.smartguide.activity.NavigationActivity;

import static com.example.alshimaa.smartguide.activity.NavigationActivity.toolbar;

/**
 * A simple {@link Fragment} subclass.
 */
public class FollowFlightsFragment extends Fragment {
EditText searchEtext;
Toolbar toolbar;
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

        NavigationActivity.toggle = new ActionBarDrawerToggle(
                getActivity(), NavigationActivity.drawer, toolbar,R.string.navigation_drawer_open, R.string.navigation_drawer_close);



//        NavigationActivity.drawer.addDrawerListener(NavigationActivity.toggle);
//        NavigationActivity.toggle.syncState();
//
//        NavigationActivity.toggle.setDrawerIndicatorEnabled(false);
//        toolbar.setNavigationIcon(R.drawable.group151  );
//
//        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//                if (NavigationActivity.drawer.isDrawerOpen(GravityCompat.START)) {
//                    NavigationActivity.drawer.closeDrawer(GravityCompat.START);
//                } else {
//                    NavigationActivity.drawer.openDrawer(GravityCompat.START);
//                }
//            }
//        });

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
        toolbar=view.findViewById(R.id.follow_flights_tool_bar);
    }

}
