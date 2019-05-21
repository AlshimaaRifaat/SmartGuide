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
import com.example.alshimaa.smartguide.activity.NavigationDriverActivity;
import com.example.alshimaa.smartguide.activity.NavigationMemberActivity;
import com.example.alshimaa.smartguide.adapter.HomeDriverAdapter;
import com.example.alshimaa.smartguide.adapter.HomeMemberAdapter;
import com.example.alshimaa.smartguide.model.HomeMemberData;
import com.example.alshimaa.smartguide.presenter.HomeDriverPresenter;
import com.example.alshimaa.smartguide.presenter.HomeMemberPresenter;
import com.example.alshimaa.smartguide.view.DetailsHomeMemberView;
import com.example.alshimaa.smartguide.view.HomeDriverView;
import com.example.alshimaa.smartguide.view.HomeMemberView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeMemberFragment extends Fragment implements HomeMemberView ,DetailsHomeMemberView {
    @BindView(R.id.home_member_recycler)
    RecyclerView recyclerViewHomeMember;
    @BindView(R.id.home_member_tool_bar)
    Toolbar toolbar;
    Unbinder unbinder;

    NetworkConnection networkConnection;

    HomeMemberAdapter homeMemberAdapter;
    HomeMemberPresenter homeMemberPresenter;

    public HomeMemberFragment() {
        // Required empty public constructor
    }

View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_home_member, container, false);
        unbinder= ButterKnife.bind(this,view);


        NavigationMemberActivity.toggle_member = new ActionBarDrawerToggle(
                getActivity(), NavigationMemberActivity.drawer_member, toolbar,R.string.navigation_drawer_open, R.string.navigation_drawer_close);

        NavigationMemberActivity.drawer_member.addDrawerListener(NavigationMemberActivity.toggle_member);
        NavigationMemberActivity.toggle_member.syncState();

        NavigationMemberActivity.toggle_member.setDrawerIndicatorEnabled(false);
        toolbar.setNavigationIcon(R.drawable.group151);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (NavigationMemberActivity.drawer_member.isDrawerOpen(GravityCompat.START)) {
                    NavigationMemberActivity.drawer_member.closeDrawer(GravityCompat.START);
                } else {
                    NavigationMemberActivity.drawer_member.openDrawer(GravityCompat.START);
                }
            }
        });
        networkConnection=new NetworkConnection( getContext() );

        HomeMemberSupervisor();
        return view;
    }

    private void HomeMemberSupervisor() {
        homeMemberPresenter=new HomeMemberPresenter(getContext(),this);
        homeMemberPresenter.getHomeMemberResult( SplashActivity.Member_user_token);
    }

    @Override
    public void showHomeMemberList(List<HomeMemberData> homeMemberDataList) {
        homeMemberAdapter=new HomeMemberAdapter( getContext(),homeMemberDataList );
      homeMemberAdapter.onClick(this);
        recyclerViewHomeMember.setLayoutManager( new LinearLayoutManager(getContext()));
        recyclerViewHomeMember.setAdapter( homeMemberAdapter );

    }

    @Override
    public void showHomeMemberError() {

    }

    @Override
    public void showDetailsHomeMember(HomeMemberData homeMemberData) {
        GetTripsMemberSupervisorFragment getTripsMemberSupervisorFragment=new GetTripsMemberSupervisorFragment();
        Bundle bundle=new Bundle();
        bundle.putParcelable("member_item",homeMemberData);
        getTripsMemberSupervisorFragment.setArguments(bundle);
        getFragmentManager().beginTransaction().replace(R.id.content_navigation_member,
                getTripsMemberSupervisorFragment ).addToBackStack(null).commit();
    }
}
