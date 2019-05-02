package com.example.alshimaa.smartguide.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.alshimaa.smartguide.NetworkConnection;
import com.example.alshimaa.smartguide.R;
import com.example.alshimaa.smartguide.activity.NavigationDriverActivity;
import com.example.alshimaa.smartguide.activity.NavigationGuideActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeDriverFragment extends Fragment {

    @BindView(R.id.home_driver_tool_bar)
    Toolbar toolbar;

    Unbinder unbinder;
    public HomeDriverFragment() {
        // Required empty public constructor
    }

View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_home_driver, container, false);
        unbinder= ButterKnife.bind(this,view);

        NavigationDriverActivity.toggle_driver = new ActionBarDrawerToggle(
                getActivity(), NavigationDriverActivity.drawer_driver, toolbar,R.string.navigation_drawer_open, R.string.navigation_drawer_close);

        NavigationDriverActivity.drawer_driver.addDrawerListener(NavigationDriverActivity.toggle_driver);
        NavigationDriverActivity.toggle_driver.syncState();

        NavigationDriverActivity.toggle_driver.setDrawerIndicatorEnabled(false);
        toolbar.setNavigationIcon(R.drawable.group151);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (NavigationDriverActivity.drawer_driver.isDrawerOpen(GravityCompat.START)) {
                    NavigationDriverActivity.drawer_driver.closeDrawer(GravityCompat.START);
                } else {
                    NavigationDriverActivity.drawer_driver.openDrawer(GravityCompat.START);
                }
            }
        });

        return view;
    }

}
