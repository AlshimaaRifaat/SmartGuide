package com.example.alshimaa.smartguide.fragment;


import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.alshimaa.smartguide.R;
import com.example.alshimaa.smartguide.model.FollowFlightsData;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

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
    String Status;

    public static Button startTripBtn,endTripBtn;

    FollowFlightsData followFlightsData;
    Bundle bundle;
   public static String clicked;


    public static String TripName,GuideName,BusNumber,DriverName,From,To,StartDate,EndDate,TripId
            ,StatusId,CompanyId,StartLat,StartLng,EndLat,EndLng;

    private DatabaseReference mDatabase;
    public DetailsHomeDriverFragment() {
        // Required empty public constructor
    }

View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_details_home_driver, container, false);
        init();
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




            /*Toast.makeText(getContext(),CompanyId , Toast.LENGTH_SHORT).show();
            Toast.makeText(getContext(),TripId , Toast.LENGTH_SHORT).show();*/
        }

        mDatabase = FirebaseDatabase.getInstance().getReference();
        checkStatusFromFirebase();


       startTripBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clicked="start_clicked";
                endTripBtn.setVisibility(View.VISIBLE);
                if (clicked.equals("start_clicked")) {
                    mDatabase.child("buses").child(DetailsHomeDriverFragment.CompanyId).child(DetailsHomeDriverFragment.TripId).child("status").setValue("on");
                }
            }
        });

        endTripBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clicked="end_clicked";
                startTripBtn.setVisibility(View.VISIBLE);
                if (clicked.equals("end_clicked")) {
                    mDatabase.child("buses").child(DetailsHomeDriverFragment.CompanyId).child(DetailsHomeDriverFragment.TripId).child("status").setValue("off");
                }
              //  Toast.makeText(getContext(),String.valueOf(clicked) , Toast.LENGTH_SHORT).show();

            }
        });

       /* viewOnMapBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().replace(R.id.content_navigation_guide,
                        new ViewOnMapGuideFragment()).addToBackStack(null).commit();
            }
        });*/
        viewOnMapBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ViewOnMapDriverFragment viewOnMapDriverFragment=new ViewOnMapDriverFragment();
                /*Bundle bundle=new Bundle();
                if (String.valueOf(clicked).equals("start_clicked")) {
                    bundle.putString(clicked, "start_clicked");
                }else if(String.valueOf(clicked).equals("end_clicked"))
                {
                    bundle.putString(clicked, "end_clicked");
                }*/
                viewOnMapDriverFragment.setArguments(bundle);
                getFragmentManager().beginTransaction().replace(R.id.content_navigation_driver,
                        viewOnMapDriverFragment).addToBackStack(null).commit();
            }
        });

        return view;
    }

    private void checkStatusFromFirebase() {
        mDatabase.child("buses").child(CompanyId).child(TripId).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                if (dataSnapshot.getValue() != null)
                {
                    Status=dataSnapshot.child("status").getValue().toString();

                 //   Toast.makeText(getContext(), Status, Toast.LENGTH_SHORT).show();
                    if (Status.equals("on"))
                    {
                       endTripBtn.setVisibility(View.VISIBLE);
                    }else if (Status.equals("off"))
                    {
                        startTripBtn.setVisibility(View.VISIBLE);
                    }
                    if(getContext()!=null) {
                        //Toast.makeText(context, String.valueOf(BusLat) + " " + String.valueOf(BusLng), Toast.LENGTH_SHORT).show();
                    }
                    // mGoogleMap.addMarker(new MarkerOptions().position(Bus).title("bus"));
                    // Toast.makeText(getContext(), String.valueOf(CurrentLat)+" "+String.valueOf(CurrentLng), Toast.LENGTH_SHORT).show();
                   /* Map<String,String> map=dataSnapshot.getValue(Map.class);
                    String Lat=map.get("lat");
                    String Lng=map.get("lng");
                    String Speed=map.get("speed");
                    Toast.makeText(getContext(), "lat "+Lat+"lng "+Lng+"speed "+Speed, Toast.LENGTH_SHORT).show();*/
                }


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    private void init() {
        startTripBtn=view.findViewById(R.id.details_home_driver_btn_start_trip);
        endTripBtn=view.findViewById(R.id.details_home_driver_btn_finish_trip);
    }

}
