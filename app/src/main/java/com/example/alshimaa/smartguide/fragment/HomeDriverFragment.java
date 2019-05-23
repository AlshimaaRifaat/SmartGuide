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
import android.widget.ImageView;

import com.example.alshimaa.smartguide.NetworkConnection;
import com.example.alshimaa.smartguide.R;
import com.example.alshimaa.smartguide.SplashActivity;
import com.example.alshimaa.smartguide.activity.NavigationDriverActivity;
import com.example.alshimaa.smartguide.activity.NavigationGuideActivity;
import com.example.alshimaa.smartguide.adapter.HomeDriverAdapter;
import com.example.alshimaa.smartguide.adapter.HomeGuideAdapter;
import com.example.alshimaa.smartguide.model.FollowFlightsData;
import com.example.alshimaa.smartguide.presenter.HomeDriverPresenter;
import com.example.alshimaa.smartguide.presenter.HomeGuidePresenter;
import com.example.alshimaa.smartguide.view.DetailsFollowFlightsView;
import com.example.alshimaa.smartguide.view.HomeDriverView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeDriverFragment extends Fragment implements HomeDriverView,DetailsFollowFlightsView{
    @BindView(R.id.home_driver_recycler)
    RecyclerView recyclerViewHomeDriver;
    @BindView(R.id.home_driver_tool_bar)
    Toolbar toolbar;

    @BindView(R.id.home_driver_notification)
    ImageView notificationIcon;
    Unbinder unbinder;

    NetworkConnection networkConnection;

    HomeDriverAdapter homeDriverAdapter;
    HomeDriverPresenter homeDriverPresenter;
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
        networkConnection=new NetworkConnection( getContext() );

        HomeDriverTrips();
        notificationIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NotificationFragment notificationFragment=new NotificationFragment();
                Bundle bundle=new Bundle();
                bundle.putString("module","driver_notification");
                notificationFragment.setArguments(bundle);
                getFragmentManager().beginTransaction().replace(R.id.content_navigation_driver,
                        notificationFragment).addToBackStack(null).commit();
            }
        });
        return view;
    }

    private void HomeDriverTrips() {
        homeDriverPresenter=new HomeDriverPresenter(getContext(),this);
        homeDriverPresenter.getHomeDriverResult( SplashActivity.Driver_user_token,"ar");
    }

    @Override
    public void showHomeDriverList(List<FollowFlightsData> followFlightsDataList) {
        homeDriverAdapter=new HomeDriverAdapter( getContext(),followFlightsDataList );
        homeDriverAdapter.onClick(this);
        recyclerViewHomeDriver.setLayoutManager( new GridLayoutManager(getContext(),2));
        recyclerViewHomeDriver.setAdapter( homeDriverAdapter );
    }

    @Override
    public void showHomeDriverError() {

    }

    @Override
    public void showDetailsFollowFlights(FollowFlightsData followFlightsData) {
        DetailsHomeDriverFragment detailsHomeDriverFragment=new DetailsHomeDriverFragment();
        Bundle bundle=new Bundle();
        bundle.putParcelable("driver_item",followFlightsData);
        detailsHomeDriverFragment.setArguments(bundle);
        getFragmentManager().beginTransaction().replace(R.id.content_navigation_driver,
                detailsHomeDriverFragment).addToBackStack(null).commit();
    }
}
