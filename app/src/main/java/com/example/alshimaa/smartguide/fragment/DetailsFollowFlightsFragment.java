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
import com.example.alshimaa.smartguide.SplashActivity;
import com.example.alshimaa.smartguide.model.FollowFlightsData;
import com.example.alshimaa.smartguide.presenter.StartTripPresenter;
import com.example.alshimaa.smartguide.view.StartTripView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetailsFollowFlightsFragment extends Fragment implements StartTripView {

TextView flightNameTxt,guideNameTxt,busNumberTxt,driverNameTxt
        ,fromTxt,toTxt,startDateTxt,endDateTxt
        ,logoBusNumberTxt,logoStatusTxt;
    @BindView(R.id.details_follow_flights_icon_edit) ImageView iconEdit;
    @BindView(R.id.details_follow_flights_btn_start_trip) Button startTripBtn;
    @BindView(R.id.details_follow_flights_btn_pause_trip) Button pauseTripBtn;
    @BindView(R.id.details_follow_flights_btn_finish_trip) Button finishTripBtn;
    Unbinder unbinder;



    FollowFlightsData followFlightsData;
    Bundle bundle;

    Button viewOnMapBtn;
    public static String StartLat,StartLng,EndLat,EndLng,CompanyId,BusName,TripId,TripStatus
            ,TripName,GuideName,DriverName,From,To,StartDate,EndDate,StatusId;
    StartTripPresenter startTripPresenter;
    public DetailsFollowFlightsFragment() {
        // Required empty public constructor
    }

View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_details_follow_flights, container, false);
        unbinder= ButterKnife.bind(this,view);
        init();
        bundle=this.getArguments();
        if (bundle!=null)
        {
            followFlightsData=bundle.getParcelable("follow_flight_item");
            TripName=followFlightsData.getTripName();
            flightNameTxt.setText("اسم الرحله:"+TripName);

            GuideName=followFlightsData.getGuideName();
            guideNameTxt.setText("اسم المشرف:"+GuideName);

            BusName=followFlightsData.getBusName();
            busNumberTxt.setText("رقم الحافله:"+BusName);

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

            logoBusNumberTxt.setText(BusName);
            TripStatus=followFlightsData.getStatus();
            logoStatusTxt.setText(TripStatus);


            StartLat=followFlightsData.getLatStart();
            StartLng=followFlightsData.getLngStart();
            EndLat=followFlightsData.getLatEnd();
            EndLng=followFlightsData.getLngEnd();

            CompanyId=followFlightsData.getCompanyId();

            TripId=followFlightsData.getTripId();

            StatusId=followFlightsData.getStatusId();
           // BusId=followFlightsData.getBusId();


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
        if(StatusId.equals("1"))
        {
            startTripBtn.setVisibility(View.VISIBLE);
            viewOnMapBtn.setVisibility(View.VISIBLE);

        }
        if(StatusId.equals("2"))
        {
            finishTripBtn.setVisibility(View.VISIBLE);
            viewOnMapBtn.setVisibility(View.VISIBLE);
            pauseTripBtn.setVisibility(View.VISIBLE);
        }
        if(StatusId.equals("3"))
        {
            startTripBtn.setVisibility(View.VISIBLE);
            viewOnMapBtn.setVisibility(View.VISIBLE);

        }if(StatusId.equals("4"))
        {
            viewOnMapBtn.setVisibility(View.VISIBLE);
        }if(StatusId.equals("5"))
        {
            viewOnMapBtn.setVisibility(View.VISIBLE);
            //finishTripBtn.setVisibility(View.VISIBLE);
        }if(StatusId.equals("6"))
        {
            viewOnMapBtn.setVisibility(View.VISIBLE);
            finishTripBtn.setVisibility(View.VISIBLE);
            //startTripBtn.setVisibility(View.VISIBLE);
        }if(StatusId.equals("7"))
        {
            viewOnMapBtn.setVisibility(View.VISIBLE);
            startTripBtn.setVisibility(View.VISIBLE);
        }
        /*if(TripStatus.equals("مسنده"))
        {
            startTripBtn.setVisibility(View.VISIBLE);
            viewOnMapBtn.setVisibility(View.VISIBLE);
        }
        if(TripStatus.equals("قيد التنفيذ"))
        {
            finishTripBtn.setVisibility(View.VISIBLE);
            viewOnMapBtn.setVisibility(View.VISIBLE);
            pauseTripBtn.setVisibility(View.VISIBLE);
        }
        if(TripStatus.equals("معلق"))
        {
            startTripBtn.setVisibility(View.VISIBLE);
            viewOnMapBtn.setVisibility(View.VISIBLE);
            finishTripBtn.setVisibility(View.VISIBLE);
        }if(TripStatus.equals("ملغيه"))
        {
            viewOnMapBtn.setVisibility(View.VISIBLE);
        }if(TripStatus.equals("مقفل جزئي"))
        {
            viewOnMapBtn.setVisibility(View.VISIBLE);
            finishTripBtn.setVisibility(View.VISIBLE);
        }if(TripStatus.equals("مجدوله"))
        {
            viewOnMapBtn.setVisibility(View.VISIBLE);
            startTripBtn.setVisibility(View.VISIBLE);
        }*/
        viewOnMapBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().replace(R.id.content_navigation,
                       new ViewOnMapFragment()).addToBackStack(null).commit();
            }
        });
        iconEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().replace(R.id.content_navigation,
                        new EditFlightFragment()).addToBackStack(null).commit();
            }
        });
        startTripBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishTripBtn.setVisibility(View.VISIBLE);
               performStartTrip();
            }
        });
        pauseTripBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performPauseTrip();
            }
        });
        return view;
    }

    private void performPauseTrip() {
        startTripPresenter=new StartTripPresenter(getContext(),this);
        startTripPresenter.getPauseResult(SplashActivity.Login,TripId,"مرحبا بك سوف تبدا الرحلة الان","تفاصيل ابن الوسخة بقى زى ما هو عاوز","3");

    }

    private void performStartTrip() {
        startTripPresenter=new StartTripPresenter(getContext(),this);
        startTripPresenter.getStartTripResult(SplashActivity.Login,TripId,"مرحبا بك سوف تبدا الرحلة الان","تفاصيل ابن الوسخة بقى زى ما هو عاوز");

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

    @Override
    public void showStartTripMsg(String Msg) {
        Toast.makeText(getContext(), Msg, Toast.LENGTH_SHORT).show();
        pauseTripBtn.setVisibility(View.VISIBLE);
    }

    @Override
    public void showStartTripError() {

    }

    @Override
    public void showPauseTripMsg(String Msg) {
        Toast.makeText(getContext(), Msg, Toast.LENGTH_SHORT).show();
        getFragmentManager().beginTransaction().replace(R.id.content_navigation,
                new RequestPauseTripFragment()).addToBackStack(null).commit();
    }

    @Override
    public void showPauseTripError() {

    }

    @Override
    public void showRequestPauseTripMsg(String Msg) {

    }

    @Override
    public void showRequestPauseTripError() {

    }

    @Override
    public void showRequestPauseTripGuideMsg(String Msg) {

    }

    @Override
    public void showRequestPauseTripGuideError() {

    }
}
