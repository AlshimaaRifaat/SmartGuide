package com.example.alshimaa.smartguide.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.alshimaa.smartguide.NetworkConnection;
import com.example.alshimaa.smartguide.R;
import com.example.alshimaa.smartguide.SplashActivity;
import com.example.alshimaa.smartguide.adapter.OldRequestsGuideAdapter;
import com.example.alshimaa.smartguide.adapter.OldRequestsSupervisorAdapter;
import com.example.alshimaa.smartguide.model.OldRequestsSupervisorData;
import com.example.alshimaa.smartguide.presenter.OldRequestsGuidePresenter;
import com.example.alshimaa.smartguide.presenter.OldRequestsSupervisorPresenter;
import com.example.alshimaa.smartguide.view.DetailsOldRequestsSupervisorView;
import com.example.alshimaa.smartguide.view.OldRequestsSupervisorView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class OldRequestsPauseTripSupervisorFragment extends Fragment implements OldRequestsSupervisorView
,DetailsOldRequestsSupervisorView{
    @BindView(R.id.old_requests_supervisor_recycler)
    RecyclerView recyclerViewOldRequestsSupervisor;
    @BindView(R.id.old_requests_supervisor_tool_bar)
    Toolbar toolbar;;
    Unbinder unbinder;

    OldRequestsSupervisorAdapter oldRequestsSupervisorAdapter;
    OldRequestsSupervisorPresenter oldRequestsSupervisorPresenter;

    NetworkConnection networkConnection;

    View view;
    public OldRequestsPauseTripSupervisorFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_old_requests_pause_trip_supervisor, container, false);
        unbinder= ButterKnife.bind(this,view);

        networkConnection=new NetworkConnection( getContext() );
        OldRequestsSupervisor();
        return view;
    }

    private void OldRequestsSupervisor() {
        oldRequestsSupervisorPresenter=new OldRequestsSupervisorPresenter(getContext(),this);
        oldRequestsSupervisorPresenter.getOldRequestsSupervisorResult( SplashActivity.Login);
    }

    @Override
    public void showOldRequestsSupervisorList(List<OldRequestsSupervisorData> oldRequestsSupervisorDataList) {
        oldRequestsSupervisorAdapter=new OldRequestsSupervisorAdapter( getContext(),oldRequestsSupervisorDataList );
        oldRequestsSupervisorAdapter.onClick(this);
        recyclerViewOldRequestsSupervisor.setLayoutManager( new LinearLayoutManager(getContext()));
        recyclerViewOldRequestsSupervisor.setAdapter( oldRequestsSupervisorAdapter );
    }

    @Override
    public void showOldRequestsSupervisorError() {

    }

    @Override
    public void showDetailsOldRequestsSupervisor(OldRequestsSupervisorData oldRequestsSupervisorData) {
        DetailsOldRequestsSupervisorFragment detailsOldRequestsSupervisorFragment=new DetailsOldRequestsSupervisorFragment();

        Bundle bundle=new Bundle();
        bundle.putParcelable("old_request_pause_item",oldRequestsSupervisorData);
        detailsOldRequestsSupervisorFragment.setArguments(bundle);
        getFragmentManager().beginTransaction().replace(R.id.content_navigation,
                detailsOldRequestsSupervisorFragment ).addToBackStack(null).commit();
    }
}
