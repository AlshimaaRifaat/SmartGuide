package com.example.alshimaa.smartguide.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.alshimaa.smartguide.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class RequestPauseTripFragment extends Fragment {

    /*flightNameTxt,guideNameTxt,busNumberTxt,driverNameTxt
        ,fromTxt,toTxt,startDateTxt,endDateTxt*/

    @BindView(R.id.request_pause_trip_name)
    TextView tripNameTxt;

    @BindView(R.id.request_pause_guide_name)
    TextView guideNameTxt;

    @BindView(R.id.request_pause_bus_number)
    TextView busNumberTxt;

    @BindView(R.id.request_pause_driver_name)
    TextView driverNameTxt;

    @BindView(R.id.request_pause_going_down_Place)
    TextView fromTxt;

    @BindView(R.id.request_pause_delivery_Place)
    TextView toTxt;

    @BindView(R.id.request_pause_start_date)
    TextView startDateTxt;

    @BindView(R.id.request_pause_end_date)
    TextView endDateTxt;
    Unbinder unbinder;

    View view;
    public RequestPauseTripFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_request_pause_trip, container, false);
        unbinder= ButterKnife.bind(this,view);
        tripNameTxt.setText("اسم الرحله:"+DetailsFollowFlightsFragment.TripName);
        guideNameTxt.setText("اسم المشرف:"+DetailsFollowFlightsFragment.GuideName);
        busNumberTxt.setText("رقم الحافله:"+DetailsFollowFlightsFragment.BusName);
        driverNameTxt.setText("اسم السائق:"+DetailsFollowFlightsFragment.DriverName);
        fromTxt.setText("مكان النزول:"+DetailsFollowFlightsFragment.From);
        toTxt.setText("مكان الاستلام:"+DetailsFollowFlightsFragment.To);
        startDateTxt.setText("تاريخ بدايه الرحله:"+DetailsFollowFlightsFragment.StartDate);
        endDateTxt.setText("تاريخ نهايه الرحله:"+DetailsFollowFlightsFragment.EndDate);
        return view;
    }

}
