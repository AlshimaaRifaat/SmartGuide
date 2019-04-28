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
public class DetailsHomeGuideFragment extends Fragment implements StartTripView {

    @BindView(R.id.details_home_guide_trip_name)
    TextView tripNameTxt;
    @BindView(R.id.details_home_guide_guide_name)
    TextView guideNameTxt;
    @BindView(R.id.details_home_guide_bus_number)
    TextView busNumberTxt;
    @BindView(R.id.details_home_guide_driver_name)
    TextView driverNameTxt;
    @BindView(R.id.details_home_guide_going_down_Place)
    TextView fromTxt;
    @BindView(R.id.details_home_guide_delivery_Place)
    TextView toTxt;
    @BindView(R.id.details_home_guide_start_date)
    TextView startDateTxt;
    @BindView(R.id.details_home_guide_end_date)
    TextView endDateTxt;


    @BindView(R.id.details_home_guide_btn_start_trip) Button startTripBtn;
    @BindView(R.id.details_home_guide_btn_pause_trip) Button pauseTripBtn;
    @BindView(R.id.details_home_guide_btn_finish_trip) Button finishTripBtn;

    Unbinder unbinder;

    FollowFlightsData followFlightsData;
    Bundle bundle;


    public static String TripName,GuideName,BusNumber,DriverName,From,To,StartDate,EndDate,TripId;
    StartTripPresenter startTripPresenter;
    public DetailsHomeGuideFragment() {
        // Required empty public constructor
    }

View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_details_home_guide, container, false);
        unbinder= ButterKnife.bind(this,view);
        bundle=this.getArguments();
        if (bundle!=null)
        {
            followFlightsData=bundle.getParcelable("guide_item");
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
        pauseTripBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performPauseTripGuide();
            }
        });
        return view;
    }

    private void performPauseTripGuide() {
        startTripPresenter=new StartTripPresenter(getContext(),this);
        startTripPresenter.getPauseResult(SplashActivity.Login,TripId,"مرحبا بك سوف تبدا الرحلة الان","تفاصيل ابن الوسخة بقى زى ما هو عاوز","3");
    }

    @Override
    public void showStartTripMsg(String Msg) {

    }

    @Override
    public void showStartTripError() {

    }

    @Override
    public void showPauseTripMsg(String Msg) {
        Toast.makeText(getContext(), Msg, Toast.LENGTH_SHORT).show();

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


}
