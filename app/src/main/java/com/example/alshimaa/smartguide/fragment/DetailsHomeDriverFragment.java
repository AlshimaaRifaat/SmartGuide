package com.example.alshimaa.smartguide.fragment;


import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.alshimaa.smartguide.R;
import com.example.alshimaa.smartguide.model.FollowFlightsData;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetailsHomeDriverFragment extends Fragment {

    @BindView(R.id.details_home_driver_trip_name)
    TextView tripNameTxt;
    @BindView(R.id.details_home_driver_guide_name)
    TextView guideNameTxt;
    @BindView(R.id.details_home_driver_bus_number)
    TextView busNumberTxt;
    @BindView(R.id.details_home_driver_driver_name)
    TextView driverNameTxt;
    @BindView(R.id.details_home_driver_going_down_Place)
    TextView fromTxt;
    @BindView(R.id.details_home_driver_delivery_Place)
    TextView toTxt;
    @BindView(R.id.details_home_driver_start_date)
    TextView startDateTxt;
    @BindView(R.id.details_home_driver_end_date)
    TextView endDateTxt;
    @BindView(R.id.details_home_driver_btn_view_on_map)
    Button viewOnMapBtn;
    Unbinder unbinder;

    FollowFlightsData followFlightsData;
    Bundle bundle;

    public static String TripName,GuideName,BusNumber,DriverName,From,To,StartDate,EndDate,TripId
            ,StatusId,CompanyId,StartLat,StartLng,EndLat,EndLng;
    public DetailsHomeDriverFragment() {
        // Required empty public constructor
    }

View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_details_home_driver, container, false);

        unbinder= ButterKnife.bind(this,view);
        bundle=this.getArguments();
        if (bundle!=null)
        {
            followFlightsData=bundle.getParcelable("driver_item");
            TripName=followFlightsData.getTripName();
            tripNameTxt.setText("اسم الرحله:"+TripName);

            GuideName=followFlightsData.getGuideName();
            guideNameTxt.setText("اسم المشرف:"+GuideName);

            BusNumber=followFlightsData.getBusName();
            busNumberTxt.setText("رقم الحافله:"+BusNumber);

            DriverName=followFlightsData.getDriverName();
            driverNameTxt.setText("اسم السائق:"+DriverName);

            From=followFlightsData.getFrom();
            fromTxt.setText("مكان النزول:"+From);

            To=followFlightsData.getTo();
            toTxt.setText("مكان الاستلام:"+To);

            StartDate= followFlightsData.getDateStart();
            startDateTxt.setText("تاريخ بدايه الرحله:"+StartDate);

            EndDate=followFlightsData.getDateEnd();
            endDateTxt.setText("تاريخ نهايه الرحله:"+EndDate);

            TripId=followFlightsData.getTripId();

            StatusId=followFlightsData.getStatusId();

            StartLat=followFlightsData.getLatStart();
            StartLng=followFlightsData.getLngStart();
            EndLat=followFlightsData.getLatEnd();
            EndLng=followFlightsData.getLngEnd();

            CompanyId=followFlightsData.getCompanyId();

            TripId=followFlightsData.getTripId();




            // Toast.makeText(getContext(), CompanyId, Toast.LENGTH_SHORT).show();




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





       /* startTripBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performStartTripGuide();
            }
        });
        viewOnMapBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().replace(R.id.content_navigation_guide,
                        new ViewOnMapGuideFragment()).addToBackStack(null).commit();
            }
        });*/
        viewOnMapBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().replace(R.id.content_navigation_driver,
                        new ViewOnMapDriverFragment()).addToBackStack(null).commit();
            }
        });

        return view;
    }

}
