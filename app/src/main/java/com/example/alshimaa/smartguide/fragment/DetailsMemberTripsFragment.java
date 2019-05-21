package com.example.alshimaa.smartguide.fragment;


import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.alshimaa.smartguide.R;
import com.example.alshimaa.smartguide.model.FollowFlightsData;
import com.example.alshimaa.smartguide.model.GetTripsMemberSupervisorData;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetailsMemberTripsFragment extends Fragment {
    @BindView(R.id.details_member_trips_trip_name)
    TextView tripNameTxt;
    @BindView(R.id.details_member_trips_guide_name)
    TextView guideNameTxt;
    @BindView(R.id.details_member_trips_bus_number)
    TextView busNumberTxt;
    @BindView(R.id.details_member_trips_driver_name)
    TextView driverNameTxt;
    @BindView(R.id.details_member_trips_going_down_Place)
    TextView fromTxt;
    @BindView(R.id.details_member_trips_delivery_Place)
    TextView toTxt;
    @BindView(R.id.details_member_trips_start_date)
    TextView startDateTxt;
    @BindView(R.id.details_member_trips_end_date)
    TextView endDateTxt;


    @BindView(R.id.details_member_trips_btn_delivered)
    Button deliveredBtn;
    @BindView(R.id.details_member_trips_btn_view_on_map) Button viewOnMapBtn;
    Unbinder unbinder;

    GetTripsMemberSupervisorData getTripsMemberSupervisorData;
    Bundle bundle;


    public static String TripName,GuideName,BusNumber,DriverName,From,To,StartDate,EndDate,TripId
            ,StatusId,CompanyId,StartLat,StartLng,EndLat,EndLng;

    public DetailsMemberTripsFragment() {
        // Required empty public constructor
    }

View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_details_member_trips, container, false);
        unbinder= ButterKnife.bind(this,view);
        bundle=this.getArguments();
        if (bundle!=null)
        {
            getTripsMemberSupervisorData=bundle.getParcelable("trip_item");
            TripName=getTripsMemberSupervisorData.getTripName();
            tripNameTxt.setText("اسم الرحله:"+TripName);

            GuideName=getTripsMemberSupervisorData.getGuideName();
            guideNameTxt.setText("اسم المرشد:"+GuideName);

            BusNumber=getTripsMemberSupervisorData.getBusName();
            busNumberTxt.setText("رقم الحافله:"+BusNumber);

            DriverName=getTripsMemberSupervisorData.getDriverName();
            driverNameTxt.setText("اسم السائق:"+DriverName);

            From=getTripsMemberSupervisorData.getFrom();
            fromTxt.setText("مكان النزول:"+From);

            To=getTripsMemberSupervisorData.getTo();
            toTxt.setText("مكان الاستلام:"+To);

            StartDate= getTripsMemberSupervisorData.getDateStart();
            startDateTxt.setText("تاريخ بدايه الرحله:"+StartDate);

            EndDate=getTripsMemberSupervisorData.getDateEnd();
            endDateTxt.setText("تاريخ نهايه الرحله:"+EndDate);

            /*TripId=getTripsMemberSupervisorData.getTripId();

            StatusId=getTripsMemberSupervisorData.getStatusId();*/

            StartLat=String.valueOf(getTripsMemberSupervisorData.getLatStart());
            StartLng=String.valueOf(getTripsMemberSupervisorData.getLngStart());
            EndLat=String.valueOf(getTripsMemberSupervisorData.getLatEnd());
            EndLng=String.valueOf(getTripsMemberSupervisorData.getLngEnd());

            CompanyId=String.valueOf(getTripsMemberSupervisorData.getCompanyId());

            TripId=String.valueOf(getTripsMemberSupervisorData.getTripId());




            Typeface customFontBold = Typeface.createFromAsset(getContext().getAssets(), "DroidKufi-Bold.ttf");
            tripNameTxt.setTypeface(customFontBold);
            guideNameTxt.setTypeface(customFontBold);
            busNumberTxt.setTypeface(customFontBold);

            driverNameTxt.setTypeface(customFontBold);
            fromTxt.setTypeface(customFontBold);
            toTxt.setTypeface(customFontBold);
            startDateTxt.setTypeface(customFontBold);
            endDateTxt.setTypeface(customFontBold);

        }

        viewOnMapBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().replace(R.id.content_navigation_member,
                        new ViewOnMapMemberFragment()).addToBackStack(null).commit();
            }
        });
        return view;
    }

}
