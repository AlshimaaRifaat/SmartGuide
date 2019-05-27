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
import com.example.alshimaa.smartguide.presenter.EndTripDriverPresenter;
import com.example.alshimaa.smartguide.presenter.EndTripGuidePresenter;
import com.example.alshimaa.smartguide.presenter.StartTripGuidePresenter;
import com.example.alshimaa.smartguide.presenter.StartTripPresenter;
import com.example.alshimaa.smartguide.view.EndTripGuideView;
import com.example.alshimaa.smartguide.view.StartTripGuideView;
import com.example.alshimaa.smartguide.view.StartTripView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetailsHomeGuideFragment extends Fragment implements StartTripGuideView,EndTripGuideView,StartTripView {

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
    @BindView(R.id.details_home_guide_btn_view_on_map) Button viewOnMapBtn;
    Unbinder unbinder;

    FollowFlightsData followFlightsData;
    Bundle bundle;


    public static String TripName,GuideName,BusNumber,DriverName,From,To,StartDate,EndDate,TripId
            ,StatusId,CompanyId,StartLat,StartLng,EndLat,EndLng;
    StartTripGuidePresenter startTripGuidePresenter;
    EndTripGuidePresenter endTripGuidePresenter;
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
           // finishTripBtn.setVisibility(View.VISIBLE);
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


        pauseTripBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performPauseTripGuide();
            }
        });

        startTripBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startTripBtn.setVisibility(View.INVISIBLE);
                finishTripBtn.setVisibility(View.VISIBLE);
                pauseTripBtn.setVisibility(View.VISIBLE);
                performStartTripGuide();
            }
        });
        viewOnMapBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().replace(R.id.content_navigation_guide,
                        new ViewOnMapGuideFragment()).addToBackStack(null).commit();
            }
        });
        finishTripBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishTripBtn.setVisibility(View.INVISIBLE);
                startTripBtn.setVisibility(View.INVISIBLE);
                pauseTripBtn.setVisibility(View.GONE);
                performEndTripGuide();
            }
        });

        return view;
    }

    private void performEndTripGuide() {
        endTripGuidePresenter=new EndTripGuidePresenter(getContext(),this);
        endTripGuidePresenter.getEndTripGuideResult(SplashActivity.Guide_user_token,TripId,"مرحبا بك سوف تبدا الرحلة الان","hgg");
    }

    private void performStartTripGuide() {
       // Toast.makeText(getContext(), SplashActivity.Guide_user_token, Toast.LENGTH_SHORT).show();
        startTripGuidePresenter=new StartTripGuidePresenter(getContext(),this);
        startTripGuidePresenter.getStartTripGuideResult(SplashActivity.Guide_user_token,TripId,"مرحبا بك سوف تبدا الرحلة الان","تفاصيل ابن الوسخة بقى زى ما هو عاوز");
        pauseTripBtn.setVisibility(View.VISIBLE);
    }

    private void performPauseTripGuide() {
        getFragmentManager().beginTransaction().replace(R.id.content_navigation_guide,
                new RequestPauseTripGuideFragment()).addToBackStack(null).commit();
       /* startTripPresenter=new StartTripPresenter(getContext(),this);

        startTripPresenter.getPauseResult(SplashActivity.Guide_user_token,TripId,"مرحبا بك سوف تبدا الرحلة الان","تفاصيل ابن الوسخة بقى زى ما هو عاوز","3");
*/

    }


    @Override
    public void showStartTripMsg(String Msg) {

    }

    @Override
    public void showStartTripError() {

    }

    @Override
    public void showPauseTripMsg(String Msg) {
        /*Toast.makeText(getContext(), Msg, Toast.LENGTH_SHORT).show();*/
       /* getFragmentManager().beginTransaction().replace(R.id.content_navigation_guide,
                new RequestPauseTripGuideFragment()).addToBackStack(null).commit();*/

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

    @Override
    public void showEndTripMsg(String Msg) {

    }

    @Override
    public void showEndTripError() {

    }


    @Override
    public void showEndTripGuideMsg(String Msg) {
        Toast.makeText(getContext(), Msg, Toast.LENGTH_SHORT).show();
        pauseTripBtn.setVisibility(View.INVISIBLE);
    }

    @Override
    public void showEndTripGuideError() {

    }

    @Override
    public void showStartTripGuideMsg(String Msg) {
        Toast.makeText(getContext(), Msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showStartTripGuideError() {

    }
}
