package com.example.alshimaa.smartguide.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Spinner;

import com.example.alshimaa.smartguide.NetworkConnection;
import com.example.alshimaa.smartguide.R;
import com.example.alshimaa.smartguide.activity.NavigationActivity;
import com.example.alshimaa.smartguide.adapter.BusNumberSpinnerAdapter;
import com.example.alshimaa.smartguide.adapter.DriverNameSpinnerAdapter;
import com.example.alshimaa.smartguide.adapter.GuideNameSpinnerAdapter;
import com.example.alshimaa.smartguide.model.GetBusNumberData;
import com.example.alshimaa.smartguide.model.GetDriverNameData;
import com.example.alshimaa.smartguide.model.GetGuideNameData;
import com.example.alshimaa.smartguide.presenter.GetBusNumberPresenter;
import com.example.alshimaa.smartguide.presenter.GetDriverNamePresenter;
import com.example.alshimaa.smartguide.presenter.GetGuideNamePresenter;
import com.example.alshimaa.smartguide.view.GetBusNumberView;
import com.example.alshimaa.smartguide.view.GetDriverNameView;
import com.example.alshimaa.smartguide.view.GetGuideNameView;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewTripFragment extends Fragment implements GetGuideNameView,GetBusNumberView
,GetDriverNameView{

    GetGuideNamePresenter getGuideNamePresenter;
    Spinner guideNameSpinner;
    Integer GuideNameModelID;
    String GuideNameModel;
    GuideNameSpinnerAdapter guideNameSpinnerAdapter;

    GetBusNumberPresenter getBusNumberPresenter;
    Spinner busNumberSpinner;
    Integer BusNumberModelID;
    String BusNumberModel;
    BusNumberSpinnerAdapter busNumberSpinnerAdapter;

    GetDriverNamePresenter getDriverNamePresenter;
    Spinner driverNameSpinner;
    Integer DriverNameModelID;
    String DriverNameModel;
    DriverNameSpinnerAdapter driverNameSpinnerAdapter;

    NetworkConnection networkConnection;
    Toolbar toolbar;
    public NewTripFragment() {
        // Required empty public constructor
    }

View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_new_trip, container, false);
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
        GuideName();
        BusNumber();
        driverName();

        return view;
    }

    private void driverName() {
        getDriverNamePresenter=new GetDriverNamePresenter(getContext(),this);
        getDriverNamePresenter.getDriverNameResult( "ar" );
    }

    private void BusNumber() {
        getBusNumberPresenter=new GetBusNumberPresenter(getContext(),this);
        getBusNumberPresenter.getBusNumberResult( "ar" );
    }

    private void GuideName() {
        getGuideNamePresenter=new GetGuideNamePresenter(getContext(),this);
        getGuideNamePresenter.getGuideNameResult( "ar" );
    }

    private void init() {
        guideNameSpinner=view.findViewById( R.id.new_trip_spinner_guide_name );
        toolbar=view.findViewById( R.id.new_trip_tool_bar );
        busNumberSpinner=view.findViewById( R.id.new_trip_spinner_bus_number );
        driverNameSpinner=view.findViewById( R.id.new_trip_spinner_driver_name );
    }

    @Override
    public void showGuideNameList(List<GetGuideNameData> getGuideNameDataList) {
        ArrayList<String> guideNames=new ArrayList<>(  );
        for(int i=0;i<getGuideNameDataList.size();i++)
        {
            guideNames.add( getGuideNameDataList.get( i ).getName() );
        }
        guideNameSpinnerAdapter =new GuideNameSpinnerAdapter( getContext(), R.layout.guide_name_spinner_item);
        guideNameSpinnerAdapter.addAll( guideNames );
        guideNameSpinnerAdapter.add( "اسم المرشد");
        guideNameSpinner.setAdapter( guideNameSpinnerAdapter );
        guideNameSpinner.setPrompt("اسم المرشد");
        guideNameSpinner.setSelection( guideNameSpinnerAdapter.getCount() );
        guideNameSpinner.setOnItemSelectedListener( new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (guideNameSpinner.getSelectedItem()=="اسم المرشد")
                {

                }
                else
                {
                    GuideNameModel=guideNameSpinner.getSelectedItem().toString();
                    /*for (i=0;i<locationDatalist.size();i++)
                    {
                        if(locationDatalist.get(i).getCountry().equals( LocationModel ))
                        {
                            LocationModelID=locationDatalist.get(i).getId();
                        }
                    }*/

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        } );

    }

    @Override
    public void showBusNumberList(List<GetBusNumberData> getBusNumberDataListt) {
        ArrayList<String> buses=new ArrayList<>(  );
        for(int i=0;i<getBusNumberDataListt.size();i++)
        {
            buses.add( getBusNumberDataListt.get( i ).getName() );
        }
        busNumberSpinnerAdapter =new BusNumberSpinnerAdapter( getContext(), R.layout.guide_name_spinner_item);
        busNumberSpinnerAdapter.addAll( buses );
        busNumberSpinnerAdapter.add( "رقم الحافلة");
        busNumberSpinner.setAdapter( busNumberSpinnerAdapter );
        busNumberSpinner.setPrompt("رقم الحافلة");
        busNumberSpinner.setSelection( busNumberSpinnerAdapter.getCount() );
        busNumberSpinner.setOnItemSelectedListener( new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (busNumberSpinner.getSelectedItem()=="رقم الحافلة")
                {

                }
                else
                {
                    BusNumberModel=busNumberSpinner.getSelectedItem().toString();
                    /*for (i=0;i<locationDatalist.size();i++)
                    {
                        if(locationDatalist.get(i).getCountry().equals( LocationModel ))
                        {
                            LocationModelID=locationDatalist.get(i).getId();
                        }
                    }*/

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        } );

    }

    @Override
    public void showDriverNameList(List<GetDriverNameData> getDriverNameDataList) {
        ArrayList<String> driverNames=new ArrayList<>(  );
        for(int i=0;i<getDriverNameDataList.size();i++)
        {
            driverNames.add( getDriverNameDataList.get( i ).getName() );
        }
        driverNameSpinnerAdapter =new DriverNameSpinnerAdapter( getContext(), R.layout.guide_name_spinner_item);
        driverNameSpinnerAdapter.addAll( driverNames );
        driverNameSpinnerAdapter.add( "اسم السائق");
        driverNameSpinner.setAdapter(  driverNameSpinnerAdapter );
        driverNameSpinner.setPrompt("اسم السائق");
        driverNameSpinner.setSelection(  driverNameSpinnerAdapter.getCount() );
        driverNameSpinner.setOnItemSelectedListener( new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if ( driverNameSpinner.getSelectedItem()=="اسم السائق")
                {

                }
                else
                {
                    DriverNameModel= driverNameSpinner.getSelectedItem().toString();
                    /*for (i=0;i<locationDatalist.size();i++)
                    {
                        if(locationDatalist.get(i).getCountry().equals( LocationModel ))
                        {
                            LocationModelID=locationDatalist.get(i).getId();
                        }
                    }*/

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        } );

    }

    @Override
    public void showError() {

    }
}
