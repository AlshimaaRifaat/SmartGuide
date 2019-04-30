package com.example.alshimaa.smartguide.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.alshimaa.smartguide.NetworkConnection;
import com.example.alshimaa.smartguide.R;
import com.example.alshimaa.smartguide.SplashActivity;
import com.example.alshimaa.smartguide.activity.NavigationGuideActivity;
import com.example.alshimaa.smartguide.adapter.HomeGuideAdapter;
import com.example.alshimaa.smartguide.adapter.NotificationsAdapter;
import com.example.alshimaa.smartguide.model.FollowFlightsData;
import com.example.alshimaa.smartguide.model.NotificationsData;
import com.example.alshimaa.smartguide.presenter.HomeGuidePresenter;
import com.example.alshimaa.smartguide.presenter.NotificationsPresenter;
import com.example.alshimaa.smartguide.view.NotificationsView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class NotificationFragment extends Fragment implements NotificationsView{

    @BindView(R.id.notification_recycler)
    RecyclerView recyclerViewNotification;
    @BindView(R.id.notification_tool_bar)
    Toolbar toolbar;;
    Unbinder unbinder;

    NotificationsAdapter notificationsAdapter;
    NotificationsPresenter notificationsPresenter;

    NetworkConnection networkConnection;
    public NotificationFragment() {
        // Required empty public constructor
    }

View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_notification, container, false);
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
        Notifications();

        return view;
    }

    private void Notifications() {
        notificationsPresenter=new NotificationsPresenter(getContext(),this);
        notificationsPresenter.getNotificationsResult( SplashActivity.Guide_user_token,"guides");
    }


    @Override
    public void showNotificationList(List<NotificationsData> notificationsDataList) {
        notificationsAdapter=new NotificationsAdapter( getContext(),notificationsDataList );
       // homeGuideAdapter.onClick(this);
        recyclerViewNotification.setLayoutManager( new LinearLayoutManager(getContext()));
        recyclerViewNotification.setAdapter( notificationsAdapter );
    }

    @Override
    public void showNotificationError() {

    }
}
