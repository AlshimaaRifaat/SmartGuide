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
import android.widget.TextView;
import android.widget.Toast;

import com.example.alshimaa.smartguide.NetworkConnection;
import com.example.alshimaa.smartguide.R;
import com.example.alshimaa.smartguide.SplashActivity;
import com.example.alshimaa.smartguide.activity.NavigationActivity;
import com.example.alshimaa.smartguide.activity.NavigationGuideActivity;
import com.example.alshimaa.smartguide.adapter.HomeGuideAdapter;
import com.example.alshimaa.smartguide.adapter.NotificationsAdapter;
import com.example.alshimaa.smartguide.model.FollowFlightsData;
import com.example.alshimaa.smartguide.model.NotificationsData;
import com.example.alshimaa.smartguide.presenter.HomeGuidePresenter;
import com.example.alshimaa.smartguide.presenter.NotificationsPresenter;
import com.example.alshimaa.smartguide.view.NotificationNumbersView;
import com.example.alshimaa.smartguide.view.NotificationsView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class NotificationFragment extends Fragment implements NotificationsView
,NotificationNumbersView{

    @BindView(R.id.notification_recycler)
    RecyclerView recyclerViewNotification;
    @BindView(R.id.notification_tool_bar)
    Toolbar toolbar;;
    Unbinder unbinder;

    NotificationsAdapter notificationsAdapter;
    NotificationsPresenter notificationsPresenter;

    NetworkConnection networkConnection;
    Bundle bundle;
    String NotificationFrom;
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
        bundle=this.getArguments();
        if (bundle!=null) {
            NotificationFrom = bundle.getString("module");

        }
      //  Toast.makeText(getContext(), NotificationFrom, Toast.LENGTH_SHORT).show();


      /*  NavigationActivity.toggle = new ActionBarDrawerToggle(
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
        });*/
        networkConnection=new NetworkConnection( getContext() );
        Notifications();

        return view;
    }

    private void Notifications() {
        notificationsPresenter=new NotificationsPresenter(getContext(),this);
        if(NotificationFrom.equals("guide_notification"))
        {
            notificationsPresenter.getNotificationsResult( SplashActivity.Guide_user_token,"guides");
        }else if(NotificationFrom.equals("driver_notification"))
        {
            notificationsPresenter.getNotificationsResult( SplashActivity.Driver_user_token,"drivers");
        }
            else if(NotificationFrom.equals("supervisor_notification")) {
            notificationsPresenter.getNotificationsResult(SplashActivity.Login, "supervisors");
        }
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

    @Override
    public void showNotificationNumbersList(List<NotificationsData> notificationsDataList) {
        /*if(notificationsDataList.size()>=0) {
            *//*TabLayout.Tab tab = HomeActivity.tabLayout.getTabAt(1); // fourth tab
            View tabView = tab.getCustomView();*//*
           //FollowFlightsFragment.textView.setVisibility(View.VISIBLE);
            Toast.makeText(getContext(), String.valueOf(notificationsDataList.size()), Toast.LENGTH_SHORT).show();
            //FollowFlightsFragment.textView.setText(notificationsDataList.size()+"");

        }*/
    }

    @Override
    public void showNotificationNumbersError() {

    }
}
