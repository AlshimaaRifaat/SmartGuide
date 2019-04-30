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
import com.example.alshimaa.smartguide.adapter.OldRequestsGuideAdapter;
import com.example.alshimaa.smartguide.model.OldRequestsGuideData;
import com.example.alshimaa.smartguide.presenter.HomeGuidePresenter;
import com.example.alshimaa.smartguide.presenter.OldRequestsGuidePresenter;
import com.example.alshimaa.smartguide.view.OldRequestsGuideView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class OldRequestsGuideFragment extends Fragment implements OldRequestsGuideView{
    @BindView(R.id.old_requests_guide_recycler)
    RecyclerView recyclerViewOldRequests;
    @BindView(R.id.old_requests_guide_tool_bar)
    Toolbar toolbar;;
    Unbinder unbinder;

    OldRequestsGuideAdapter oldRequestsGuideAdapter;
    OldRequestsGuidePresenter oldRequestsGuidePresenter;

    NetworkConnection networkConnection;

    public OldRequestsGuideFragment() {
        // Required empty public constructor
    }

View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_old_requests_guide, container, false);
        unbinder= ButterKnife.bind(this,view);


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
       OldRequestsGuide();
        return view;
    }

    private void OldRequestsGuide() {
        oldRequestsGuidePresenter=new OldRequestsGuidePresenter(getContext(),this);
        oldRequestsGuidePresenter.getOldRequestsGuideResult( SplashActivity.Guide_user_token);
    }

    @Override
    public void showOldRequestsGuideList(List<OldRequestsGuideData> oldRequestsGuideDataList) {
        oldRequestsGuideAdapter=new OldRequestsGuideAdapter( getContext(),oldRequestsGuideDataList );
       // homeGuideAdapter.onClick(this);
        recyclerViewOldRequests.setLayoutManager( new LinearLayoutManager(getContext()));
        recyclerViewOldRequests.setAdapter( oldRequestsGuideAdapter );
    }

    @Override
    public void showOldRequestsError() {

    }
}
