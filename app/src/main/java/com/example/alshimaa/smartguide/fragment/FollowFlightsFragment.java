package com.example.alshimaa.smartguide.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.alshimaa.smartguide.NetworkConnection;
import com.example.alshimaa.smartguide.R;
import com.example.alshimaa.smartguide.SplashActivity;
import com.example.alshimaa.smartguide.activity.NavigationActivity;
import com.example.alshimaa.smartguide.adapter.FollowFlightsAdapter;
import com.example.alshimaa.smartguide.model.FollowFlightsData;
import com.example.alshimaa.smartguide.presenter.FollowFlightsPresenter;
import com.example.alshimaa.smartguide.view.DetailsFollowFlightsView;
import com.example.alshimaa.smartguide.view.FollowFlightsView;

import java.util.List;

import static com.example.alshimaa.smartguide.activity.NavigationActivity.toolbar;

/**
 * A simple {@link Fragment} subclass.
 */
public class FollowFlightsFragment extends Fragment implements FollowFlightsView
        ,DetailsFollowFlightsView {
EditText searchEtext;
Toolbar toolbar;
ImageView iconPlus;

    RecyclerView recyclerViewFollowFlights;
    FollowFlightsAdapter followFlightsAdapter;
    FollowFlightsPresenter followFlightsPresenter;

    NetworkConnection networkConnection;

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

        NavigationActivity.drawer.addDrawerListener(NavigationActivity.toggle);
        NavigationActivity.toggle.syncState();

        NavigationActivity.toggle.setDrawerIndicatorEnabled(false);
        toolbar.setNavigationIcon(R.drawable.group151);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (NavigationActivity.drawer.isDrawerOpen(GravityCompat.START)) {
                    NavigationActivity.drawer.closeDrawer(GravityCompat.START);
                } else {
                    NavigationActivity.drawer.openDrawer(GravityCompat.START);
                }
            }
        });
        networkConnection=new NetworkConnection( getContext() );
        FollowFlights();

        iconPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().replace(R.id.content_navigation,new
                        NewTripFragment()).addToBackStack(null).commit();
            }
        });
        return view;
    }

    private void FollowFlights() {
        followFlightsPresenter=new FollowFlightsPresenter(getContext(),this);
        followFlightsPresenter.getFollowFlightsResult("ar", SplashActivity.Login,"1");
    }

    private void init() {
        searchEtext=view.findViewById(R.id.follow_flights_edit_text_search);
        toolbar=view.findViewById(R.id.follow_flights_tool_bar);
        iconPlus=view.findViewById(R.id.follow_flights_icon_plus);
        recyclerViewFollowFlights=view.findViewById(R.id.follow_flights_recycler);

    }

    @Override
    public void showFollowFlightsList(List<FollowFlightsData> followFlightsDataList) {
        followFlightsAdapter=new FollowFlightsAdapter( getContext(),followFlightsDataList );
       followFlightsAdapter.onClick(this);
        recyclerViewFollowFlights.setLayoutManager( new GridLayoutManager(getContext(),2));
        recyclerViewFollowFlights.setAdapter( followFlightsAdapter );
    }

    @Override
    public void showFollowFlightsError() {

    }

    @Override
    public void showDetailsFollowFlights(FollowFlightsData followFlightsData) {
        DetailsFollowFlightsFragment detailsFollowFlightsFragment=new DetailsFollowFlightsFragment();
        Bundle bundle=new Bundle();
        bundle.putParcelable("follow_flight_item",followFlightsData);
        detailsFollowFlightsFragment.setArguments(bundle);
        getFragmentManager().beginTransaction().replace(R.id.content_navigation,
                detailsFollowFlightsFragment).addToBackStack(null).commit();
    }
}
