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
import com.example.alshimaa.smartguide.model.OldRequestsSupervisorData;
import com.example.alshimaa.smartguide.presenter.OldRequestsSupervisorPresenter;
import com.example.alshimaa.smartguide.presenter.RequestAnswerPresenter;
import com.example.alshimaa.smartguide.presenter.StartTripPresenter;
import com.example.alshimaa.smartguide.view.RequestAnswerView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetailsOldRequestsSupervisorFragment extends Fragment implements RequestAnswerView{
    TextView busNumberTxt,guideNameTxt,driverNameTxt
            ,fromTxt,toTxt,startDateTxt,endDateTxt
            ,logoBusNumberTxt;

    @BindView(R.id.details_old_requests_supervisor_btn_accept)
    Button acceptBtn;
    @BindView(R.id.details_old_requests_btn_refuse) Button refuseBtn;
    Unbinder unbinder;



    OldRequestsSupervisorData oldRequestsSupervisorData;
    Bundle bundle;


    public static String BusName
            ,GuideName,DriverName,From,To,StartDate,RequestId;
    RequestAnswerPresenter requestAnswerPresenter;
    View view;
    public DetailsOldRequestsSupervisorFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_details_old_requests_supervisor, container, false);
        unbinder= ButterKnife.bind(this,view);
     init();
        bundle=this.getArguments();
        if (bundle!=null)
        {
           oldRequestsSupervisorData =bundle.getParcelable("old_request_pause_item");
            BusName=String.valueOf(oldRequestsSupervisorData.getBusNumber());
            logoBusNumberTxt.setText("رقم الحافله:"+BusName); // check problem

            GuideName=oldRequestsSupervisorData.getGuideName();
            guideNameTxt.setText("اسم المرشد:"+GuideName);



            DriverName=oldRequestsSupervisorData.getDriverName();
            driverNameTxt.setText("اسم السائق:"+DriverName);

            From=oldRequestsSupervisorData.getFrom();
            fromTxt.setText("مكان النزول:"+From);

            To=oldRequestsSupervisorData.getTo();
            toTxt.setText("مكان الاستلام:"+To);

            StartDate= oldRequestsSupervisorData.getStartDate()+" "+
                    oldRequestsSupervisorData.getStartTime();
            startDateTxt.setText("تاريخ بدايه الرحله:"+StartDate);

            RequestId=String.valueOf(oldRequestsSupervisorData.getRequestId());



           // TripId=followFlightsData.getTripId();



            Typeface customFontBold = Typeface.createFromAsset(getContext().getAssets(), "DroidKufi-Bold.ttf");
            logoBusNumberTxt.setTypeface(customFontBold);
            guideNameTxt.setTypeface(customFontBold);
            driverNameTxt.setTypeface(customFontBold);
            fromTxt.setTypeface(customFontBold);
            toTxt.setTypeface(customFontBold);
            startDateTxt.setTypeface(customFontBold);

        }


        acceptBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performAccepting();
            }
        });
        refuseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performRefusing();
            }
        });
        return view;
    }

    private void performRefusing() {
        requestAnswerPresenter=new RequestAnswerPresenter(getContext(),this);
        requestAnswerPresenter.getRequestAnswerResult(SplashActivity.Login,RequestId,"no","adsdasdasdasdsad","adasdsadasdasdasdasdsad");
    }

    private void performAccepting() {
        requestAnswerPresenter=new RequestAnswerPresenter(getContext(),this);
        requestAnswerPresenter.getRequestAnswerResult(SplashActivity.Login,RequestId,"yes","adsdasdasdasdsad","adasdsadasdasdasdasdsad");

    }

    private void init() {
        guideNameTxt=view.findViewById(R.id.details_old_requests_supervisor_guide_name);
        driverNameTxt=view.findViewById(R.id.details_old_requests_supervisor_driver_name);
        fromTxt=view.findViewById(R.id.details_old_requests_supervisor_going_down_Place);
        toTxt=view.findViewById(R.id.details_old_requests_supervisor_delivery_Place);
        startDateTxt=view.findViewById(R.id.details_old_requests_supervisor_start_date);
        logoBusNumberTxt=view.findViewById(R.id.details_old_requests_supervisor_logo_bus_number);

    }

    @Override
    public void showRequestAnswerMsg(String Msg) {
        Toast.makeText(getContext(), Msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showRequestAnswerError() {

    }
}
