package com.example.alshimaa.smartguide.fragment;


import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.alshimaa.smartguide.R;
import com.example.alshimaa.smartguide.model.FollowFlightsData;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetailsFollowFlightsFragment extends Fragment {

TextView flightNameTxt,guideNameTxt,busNumberTxt,driverNameTxt
        ,fromTxt,toTxt,startDateTxt,endDateTxt
        ,logoBusNumberTxt,logoStatusTxt;



    FollowFlightsData followFlightsData;
    Bundle bundle;

    Button viewOnMapBtn;
    public static String StartLat,StartLng,EndLat,EndLng,CompanyId,BusName;
    public DetailsFollowFlightsFragment() {
        // Required empty public constructor
    }

View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_details_follow_flights, container, false);
        init();
        bundle=this.getArguments();
        if (bundle!=null)
        {
            followFlightsData=bundle.getParcelable("follow_flight_item");
            flightNameTxt.setText("اسم الرحله:"+followFlightsData.getTripName());
            guideNameTxt.setText("اسم المشرف:"+followFlightsData.getGuideName());
            BusName=followFlightsData.getBusName();
            busNumberTxt.setText("رقم الحافله:"+BusName);
            driverNameTxt.setText("اسم السائق:"+followFlightsData.getDriverName());
            fromTxt.setText("مكان النزول:"+followFlightsData.getFrom());
            toTxt.setText("مكان الاستلام:"+followFlightsData.getTo());
            startDateTxt.setText("تاريخ بدايه الرحله:"+followFlightsData.getDateStart());
            endDateTxt.setText("تاريخ نهايه الرحله:"+followFlightsData.getDateEnd());
            logoBusNumberTxt.setText(BusName);
            logoStatusTxt.setText(followFlightsData.getStatus());

            StartLat=followFlightsData.getLatStart();
            StartLng=followFlightsData.getLngStart();
            EndLat=followFlightsData.getLatEnd();
            EndLng=followFlightsData.getLngEnd();

            CompanyId=followFlightsData.getCompanyId();


         // Toast.makeText(getContext(), CompanyId, Toast.LENGTH_SHORT).show();




            Typeface customFontBold = Typeface.createFromAsset(getContext().getAssets(), "DroidKufi-Bold.ttf");
            flightNameTxt.setTypeface(customFontBold);
            guideNameTxt.setTypeface(customFontBold);
            busNumberTxt.setTypeface(customFontBold);
            driverNameTxt.setTypeface(customFontBold);
            fromTxt.setTypeface(customFontBold);
            toTxt.setTypeface(customFontBold);
            startDateTxt.setTypeface(customFontBold);
            endDateTxt.setTypeface(customFontBold);
            logoBusNumberTxt.setTypeface(customFontBold);
            logoStatusTxt.setTypeface(customFontBold);

        }
        viewOnMapBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().replace(R.id.content_navigation,
                       new ViewOnMapFragment()).addToBackStack(null).commit();
            }
        });
        return view;
    }

    private void init() {
        flightNameTxt=view.findViewById(R.id.details_follow_flights_trip_name);
        guideNameTxt=view.findViewById(R.id.details_follow_flights_guide_name);
        busNumberTxt=view.findViewById(R.id.details_follow_flights_bus_number);
        driverNameTxt=view.findViewById(R.id.details_follow_flights_driver_name);
        fromTxt=view.findViewById(R.id.details_follow_flights_going_down_Place);
        toTxt=view.findViewById(R.id.details_follow_flights_delivery_Place);
        startDateTxt=view.findViewById(R.id.details_follow_flights_start_date);
        endDateTxt=view.findViewById(R.id.details_follow_flights_end_date);
        logoBusNumberTxt=view.findViewById(R.id.details_follow_flights_logo_bus_number);
        logoStatusTxt=view.findViewById(R.id.details_follow_flights_logo_satus);
        viewOnMapBtn=view.findViewById(R.id.details_follow_flights_btn_view_on_map);
    }

}
