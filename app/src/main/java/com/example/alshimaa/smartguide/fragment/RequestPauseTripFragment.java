package com.example.alshimaa.smartguide.fragment;


import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.alshimaa.smartguide.NetworkConnection;
import com.example.alshimaa.smartguide.R;
import com.example.alshimaa.smartguide.SplashActivity;
import com.example.alshimaa.smartguide.activity.NavigationActivity;
import com.example.alshimaa.smartguide.presenter.LoginPresenter;
import com.example.alshimaa.smartguide.presenter.StartTripPresenter;
import com.example.alshimaa.smartguide.view.StartTripView;
import com.fourhcode.forhutils.FUtilsValidation;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class RequestPauseTripFragment extends Fragment implements StartTripView{

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


    @BindView(R.id.request_pause_text_pause_reason)
    EditText pauseReasonEtxt;
    @BindView(R.id.request_pause_text_msg)
    EditText msgEtxt;

    @BindView(R.id.request_pause_trip_btn_send)
    Button sendBtn;

    @BindView(R.id.request_pause_trip_tool_bar)
    Toolbar toolbar;


    Unbinder unbinder;
    StartTripPresenter startTripPresenter;

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

        Typeface customFontBold = Typeface.createFromAsset(getContext().getAssets(), "DroidKufi-Bold.ttf");
        tripNameTxt.setTypeface(customFontBold);
        guideNameTxt.setTypeface(customFontBold);
        busNumberTxt.setTypeface(customFontBold);
        driverNameTxt.setTypeface(customFontBold);
        fromTxt.setTypeface(customFontBold);
        toTxt.setTypeface(customFontBold);
        startDateTxt.setTypeface(customFontBold);
        endDateTxt.setTypeface(customFontBold);

        RequestPause();
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

        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performSending();
            }
        });
        return view;
    }

    private void performSending() {
        FUtilsValidation.isEmpty( pauseReasonEtxt,"من فضلك,اكتب سبب التعليق" );
        FUtilsValidation.isEmpty( msgEtxt,"من فضك,اترك رسالتك" );
        NetworkConnection networkConnection=new NetworkConnection( getContext() );
        if (networkConnection.isNetworkAvailable( getContext() ))
        {

          //  Toast.makeText(getContext(),DetailsFollowFlightsFragment.TripId+ SplashActivity.Login+ " "+pauseReasonEtxt.getText().toString()+" "+msgEtxt.getText().toString(), Toast.LENGTH_SHORT).show();
            if(!pauseReasonEtxt.getText().toString().equals( "" )&&
                    !msgEtxt.getText().toString().equals(""))
            {
                startTripPresenter.getRequestPauseResult(SplashActivity.Login,DetailsFollowFlightsFragment.TripId,pauseReasonEtxt.getText().toString(),msgEtxt.getText().toString(),"10");
            }

            else
            {
                Toast.makeText( getContext(),"من فضلك, املأ البيانات ", Toast.LENGTH_SHORT ).show();
            }

        }else {
            Toast.makeText( getContext(), "تأكد من اتصالك بالانترنت", Toast.LENGTH_SHORT ).show();
        }

    }

    private void RequestPause() {
        startTripPresenter=new StartTripPresenter( getContext(),this );

    }

    @Override
    public void showStartTripMsg(String Msg) {

    }

    @Override
    public void showStartTripError() {

    }

    @Override
    public void showPauseTripMsg(String Msg) {

    }

    @Override
    public void showPauseTripError() {

    }

    @Override
    public void showRequestPauseTripMsg(String Msg) {
        Toast.makeText(getContext(), Msg, Toast.LENGTH_SHORT).show();

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
}
