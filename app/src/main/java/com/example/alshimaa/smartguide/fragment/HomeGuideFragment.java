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
import com.example.alshimaa.smartguide.activity.NavigationActivity;
import com.example.alshimaa.smartguide.activity.NavigationGuideActivity;
import com.example.alshimaa.smartguide.adapter.FollowFlightsAdapter;
import com.example.alshimaa.smartguide.adapter.HomeGuideAdapter;
import com.example.alshimaa.smartguide.model.FollowFlightsData;
import com.example.alshimaa.smartguide.presenter.FollowFlightsPresenter;
import com.example.alshimaa.smartguide.presenter.HomeGuidePresenter;
import com.example.alshimaa.smartguide.view.DetailsFollowFlightsView;
import com.example.alshimaa.smartguide.view.HomeGuideView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeGuideFragment extends Fragment implements HomeGuideView,DetailsFollowFlightsView{
    @BindView(R.id.home_guide_recycler)   RecyclerView recyclerViewHomeGuide;
    @BindView(R.id.home_guide_tool_bar)  Toolbar toolbar;
    @BindView(R.id.home_guide_notification)
    ImageView iconNotification;
    Unbinder unbinder;

    HomeGuideAdapter homeGuideAdapter;
    HomeGuidePresenter homeGuidePresenter;

    NetworkConnection networkConnection;



    public HomeGuideFragment() {
        // Required empty public constructor
    }

View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_home_guide, container, false);
        unbinder= ButterKnife.bind(this,view);
        //homeGuidePresenter=new HomeGuidePresenter(getContext(),this);


        NavigationGuideActivity.toggle_guide = new ActionBarDrawerToggle(
                getActivity(), NavigationGuideActivity.drawer_guide, toolbar,R.string.navigation_drawer_open, R.string.navigation_drawer_close);

        NavigationGuideActivity.drawer_guide.addDrawerListener(NavigationGuideActivity.toggle_guide);
        NavigationGuideActivity.toggle_guide.syncState();

        NavigationGuideActivity.toggle_guide.setDrawerIndicatorEnabled(false);
        toolbar.setNavigationIcon(R.drawable.group151);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (NavigationGuideActivity.drawer_guide.isDrawerOpen(GravityCompat.START)) {
                    NavigationGuideActivity.drawer_guide.closeDrawer(GravityCompat.START);
                } else {
                    NavigationGuideActivity.drawer_guide.openDrawer(GravityCompat.START);
                }
            }
        });

        networkConnection=new NetworkConnection( getContext() );
        iconNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NotificationFragment notificationFragment=new NotificationFragment();
                Bundle bundle=new Bundle();
                bundle.putString("module","guide_notification");
                notificationFragment.setArguments(bundle);
                getFragmentManager().beginTransaction().replace(R.id.content_navigation_guide,
                        notificationFragment).addToBackStack(null).commit();

            }
        });
        HomeGuideTrips();

        return view;
    }

    private void HomeGuideTrips() {

        homeGuidePresenter=new HomeGuidePresenter(getContext(),this);
        homeGuidePresenter.getHomeGuideResult( SplashActivity.Guide_user_token,"ar");
    }

    @Override
    public void showHomeGuideList(List<FollowFlightsData> followFlightsDataList) {
        homeGuideAdapter=new HomeGuideAdapter( getContext(),followFlightsDataList );
        homeGuideAdapter.onClick(this);
        recyclerViewHomeGuide.setLayoutManager( new GridLayoutManager(getContext(),2));
        recyclerViewHomeGuide.setAdapter( homeGuideAdapter );
    }

    @Override
    public void showHomeGuideError() {

    }

    @Override
    public void showDetailsFollowFlights(FollowFlightsData followFlightsData) {
        DetailsHomeGuideFragment detailsHomeGuideFragment=new DetailsHomeGuideFragment();
        Bundle bundle=new Bundle();
        bundle.putParcelable("guide_item",followFlightsData);
        detailsHomeGuideFragment.setArguments(bundle);
        getFragmentManager().beginTransaction().replace(R.id.content_navigation_guide,
                detailsHomeGuideFragment).addToBackStack(null).commit();
    }
}
