package com.example.alshimaa.smartguide.fragment;


import android.graphics.Typeface;
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
import android.widget.RelativeLayout;

import com.example.alshimaa.smartguide.NetworkConnection;
import com.example.alshimaa.smartguide.R;
import com.example.alshimaa.smartguide.SplashActivity;
import com.example.alshimaa.smartguide.activity.NavigationActivity;
import com.example.alshimaa.smartguide.activity.NavigationMemberActivity;
import com.example.alshimaa.smartguide.adapter.FollowFlightsAdapter;
import com.example.alshimaa.smartguide.adapter.GetTripsMemberSupervisorAdapter;
import com.example.alshimaa.smartguide.model.GetTripsMemberSupervisorData;
import com.example.alshimaa.smartguide.model.HomeMemberData;
import com.example.alshimaa.smartguide.presenter.FollowFlightsPresenter;
import com.example.alshimaa.smartguide.presenter.GetTripsMemberSupervisorPresenter;
import com.example.alshimaa.smartguide.presenter.StartTripPresenter;
import com.example.alshimaa.smartguide.view.DetailsMemberTripsView;
import com.example.alshimaa.smartguide.view.GetTripsMemberSupervisorView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class GetTripsMemberSupervisorFragment extends Fragment implements
        GetTripsMemberSupervisorView,DetailsMemberTripsView{

    @BindView(R.id.get_trips_member_tool_bar)
    Toolbar toolbar;

    @BindView(R.id.get_trips_member_recycler)
    RecyclerView recyclerViewMemberTrips;
    private Unbinder unbinder;




    GetTripsMemberSupervisorAdapter getTripsMemberSupervisorAdapter;
    GetTripsMemberSupervisorPresenter getTripsMemberSupervisorPresenter;

    NetworkConnection networkConnection;
    public static String Supervisor_id;
    HomeMemberData homeMemberData;
    Bundle bundle;

    View view;
    public GetTripsMemberSupervisorFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_get_trips_member_supervisor, container, false);
        unbinder= ButterKnife.bind(this,view);
        bundle=this.getArguments();
        if (bundle!=null)
        {
            homeMemberData=bundle.getParcelable("member_item");
            Supervisor_id=String.valueOf(homeMemberData.getId());

        }

        getTripsMemberSupervisorPresenter=new GetTripsMemberSupervisorPresenter(getContext(),this);


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
        TripsMember();
        return view;
    }

    private void TripsMember() {
        getTripsMemberSupervisorPresenter.getTripsMemberSupervisorResult(Supervisor_id);
    }

    @Override
    public void showTripsMemberSupervisorList(List<GetTripsMemberSupervisorData> getTripsMemberSupervisorDataList) {
        getTripsMemberSupervisorAdapter=new GetTripsMemberSupervisorAdapter( getContext(),getTripsMemberSupervisorDataList );
        getTripsMemberSupervisorAdapter.onClick(this);
        recyclerViewMemberTrips.setLayoutManager( new GridLayoutManager(getContext(),2));
        recyclerViewMemberTrips.setAdapter( getTripsMemberSupervisorAdapter );
    }

    @Override
    public void showTripsMemberSupervisorError() {

    }

    @Override
    public void showDetailsMemberTrips(GetTripsMemberSupervisorData getTripsMemberSupervisorData) {
        DetailsMemberTripsFragment detailsMemberTripsFragment=new DetailsMemberTripsFragment();
        Bundle bundle=new Bundle();
        bundle.putParcelable("trip_item",getTripsMemberSupervisorData);
        detailsMemberTripsFragment.setArguments(bundle);
        getFragmentManager().beginTransaction().replace(R.id.content_navigation_member,
                detailsMemberTripsFragment ).addToBackStack(null).commit();
    }
}
