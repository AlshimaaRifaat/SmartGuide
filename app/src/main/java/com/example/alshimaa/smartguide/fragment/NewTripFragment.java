package com.example.alshimaa.smartguide.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.alshimaa.smartguide.NetworkConnection;
import com.example.alshimaa.smartguide.R;
import com.example.alshimaa.smartguide.activity.NavigationActivity;
import com.example.alshimaa.smartguide.adapter.BusNumberSpinnerAdapter;
import com.example.alshimaa.smartguide.adapter.DriverNameSpinnerAdapter;
import com.example.alshimaa.smartguide.adapter.GuideNameSpinnerAdapter;
import com.example.alshimaa.smartguide.adapter.MemberNameSpinnerAdapter;
import com.example.alshimaa.smartguide.model.GetBusNumberData;
import com.example.alshimaa.smartguide.model.GetDriverNameData;
import com.example.alshimaa.smartguide.model.GetGuideNameData;
import com.example.alshimaa.smartguide.model.GetMemberNameData;
import com.example.alshimaa.smartguide.presenter.AddTripPresenter;
import com.example.alshimaa.smartguide.presenter.GetBusNumberPresenter;
import com.example.alshimaa.smartguide.presenter.GetDriverNamePresenter;
import com.example.alshimaa.smartguide.presenter.GetGuideNamePresenter;
import com.example.alshimaa.smartguide.presenter.GetMemberNamePresenter;
import com.example.alshimaa.smartguide.view.AddTripView;
import com.example.alshimaa.smartguide.view.GetBusNumberView;
import com.example.alshimaa.smartguide.view.GetDriverNameView;
import com.example.alshimaa.smartguide.view.GetGuideNameView;
import com.example.alshimaa.smartguide.view.GetMemberNameView;
import com.fourhcode.forhutils.FUtilsValidation;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewTripFragment extends Fragment implements GetGuideNameView,GetBusNumberView
,GetDriverNameView,GetMemberNameView,AddTripView{

    GetGuideNamePresenter getGuideNamePresenter;
    Spinner guideNameSpinner;
    Integer GuideNameModelID;
    String GuideNameModel;
   GuideNameSpinnerAdapter guideNameSpinnerAdapter;

    GetBusNumberPresenter getBusNumberPresenter;
    Spinner busNumberSpinner;
    Integer BusNumberModelID;
    String BusNumberModel;
    BusNumberSpinnerAdapter busNumberSpinnerAdapter;

    GetDriverNamePresenter getDriverNamePresenter;
    Spinner driverNameSpinner;
    Integer DriverNameModelID;
    String DriverNameModel;
    DriverNameSpinnerAdapter driverNameSpinnerAdapter;

    GetMemberNamePresenter getMemberNamePresenter;
    Spinner memberNameSpinner;
    Integer MemberNameModelID;
    String MemberNameModel;
    MemberNameSpinnerAdapter memberNameSpinnerAdapter;

    NetworkConnection networkConnection;
    Toolbar toolbar;
    EditText tripArabicName,tripLatinName,receiptPlace_Of_Pilgrims,downloadPlace_of_pilgrims
            ,tripStartDate,tripEndDate;
    Button addTripBtn;
    AddTripPresenter addTripPresenter;

    public NewTripFragment() {
        // Required empty public constructor
    }

View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_new_trip, container, false);
        init();
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
        networkConnection=new NetworkConnection( getContext() );
        GuideName();
        BusNumber();
        driverName();
        MemberName();

        addTrip();
        addTripBtn.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PerformAddingTrip();
            }
        } );


        return view;
    }

    private void PerformAddingTrip() {
        FUtilsValidation.isEmpty( tripArabicName,getResources().getString(R.string.pleaseEnterTripArabicName) );
        FUtilsValidation.isEmpty( tripLatinName,getResources().getString(R.string.pleaseEnterTripLatinName));
        FUtilsValidation.isEmpty( receiptPlace_Of_Pilgrims,getResources().getString(R.string.pleaseEnterReceiptPlace_Of_Pilgrims));
        FUtilsValidation.isEmpty( downloadPlace_of_pilgrims,getResources().getString(R.string.pleaseEnterDownloadPlace_of_pilgrims) );
        FUtilsValidation.isEmpty( tripStartDate,getResources().getString(R.string.pleaseEntertripStartDate));
        FUtilsValidation.isEmpty( tripEndDate,getResources().getString(R.string.pleaseEnterTripEndDate));
        validateEmail();
        NetworkConnection networkConnection=new NetworkConnection( getContext() );
        if (networkConnection.isNetworkAvailable( getContext()))
        {
            /*if ( validateEmail()) {
                if (!tripArabicName.getText().toString().equals("") &&
                        !tripLatinName.getText().toString().equals("") &&
                        !receiptPlace_Of_Pilgrims.getText().toString().equals("") &&
                        !downloadPlace_of_pilgrims.getText().toString().equals("") &&
                        !tripStartDate.getText().toString().equals("") &&
                        !tripEndDate.getText().toString().equals("") &&GuideNameModel!=null &&
                        BusNumberModel!=null &&DriverNameModel!=null &&MemberNameModel!=null) {

                    addTripPresenter.getAddTripResult(tripArabicName.getText().toString(),
                            tripLatinName.getText().toString(),
                            );  // still not done

                }
            }*/

        }else
        {
            Toast.makeText( getContext(), "تأكد من اتصالك بالانترنت", Toast.LENGTH_SHORT ).show();
        }

    }

    private void validateEmail() {
    }

    private void addTrip() {
        addTripPresenter=new AddTripPresenter(getContext(),this);
    }

    private void MemberName() {
        getMemberNamePresenter=new GetMemberNamePresenter(getContext(),this);
        getMemberNamePresenter.getMemberNameResult( "ar" );
    }

    private void driverName() {
        getDriverNamePresenter=new GetDriverNamePresenter(getContext(),this);
        getDriverNamePresenter.getDriverNameResult( "ar" );
    }

    private void BusNumber() {
        getBusNumberPresenter=new GetBusNumberPresenter(getContext(),this);
        getBusNumberPresenter.getBusNumberResult( "ar" );
    }

    private void GuideName() {
        getGuideNamePresenter=new GetGuideNamePresenter(getContext(),this);
        getGuideNamePresenter.getGuideNameResult( "ar" );
    }

    private void init() {
        guideNameSpinner=view.findViewById( R.id.new_trip_spinner_guide_name );
        toolbar=view.findViewById( R.id.new_trip_tool_bar );
        busNumberSpinner=view.findViewById( R.id.new_trip_spinner_bus_number );
        driverNameSpinner=view.findViewById( R.id.new_trip_spinner_driver_name );
        memberNameSpinner=view.findViewById( R.id.new_trip_spinner_member_name);
        tripArabicName=view.findViewById(R.id.new_trip_Etext_trip_arabic_name);
        tripLatinName=view.findViewById(R.id.new_trip_Etext_trip_Latin_name);
        receiptPlace_Of_Pilgrims=view.findViewById(R.id.new_trip_Etext_receipt_Place_of_pilgrims);
        downloadPlace_of_pilgrims=view.findViewById(R.id.new_trip_Etext_download_Place_of_pilgrims);
        tripStartDate=view.findViewById(R.id.new_trip_Etext_trip_start_date);
        tripEndDate=view.findViewById(R.id.new_trip_Etext_trip_end_date);
        addTripBtn=view.findViewById(R.id.new_trip_btn_Create_atrip);

    }

    @Override
    public void showGuideNameList(final List<GetGuideNameData> getGuideNameDataList) {


//        for(int i=0;i<getGuideNameDataList.size();i++)
//        {
//            Guides_Spinner guides_spinner=new Guides_Spinner();
//            guides_spinner.setName( getGuideNameDataList.get( i ).getName() );
//            guides_spinner.setId(getGuideNameDataList.get( i ).getId());
//            guides_List.add(guides_spinner);
//        }
        ArrayList<String> guidesName=new ArrayList<>(  );
        for(int i=0;i<getGuideNameDataList.size();i++)
        {
            guidesName.add( getGuideNameDataList.get( i ).getName() );
        }
        guideNameSpinnerAdapter =new GuideNameSpinnerAdapter( getContext(), R.layout.guide_name_spinner_item);
        guideNameSpinnerAdapter.addAll( guidesName );
       guideNameSpinnerAdapter.add( "اسم المرشد");
        guideNameSpinner.setAdapter( guideNameSpinnerAdapter );
        guideNameSpinner.setPrompt("اسم المرشد");
        guideNameSpinner.setSelection( guideNameSpinnerAdapter.getCount() );
        guideNameSpinner.setOnItemSelectedListener( new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (guideNameSpinner.getSelectedItem()=="اسم المرشد")
                {

                }
                else
                {
                    GuideNameModel=guideNameSpinner.getSelectedItem().toString();
                    for ( i=0;i<getGuideNameDataList.size();i++)
                    {
                        if(getGuideNameDataList.get(i).getName().equals(GuideNameModel))
                        {
                            GuideNameModelID=Integer.valueOf(getGuideNameDataList.get(i).getId());

                        }

                    }

                    /*for (i=0;i<locationDatalist.size();i++)
                    {
                        if(locationDatalist.get(i).getCountry().equals( LocationModel ))
                        {
                            LocationModelID=locationDatalist.get(i).getId();
                        }
                    }*/
                    Toast.makeText(getContext(),String.valueOf(GuideNameModelID), Toast.LENGTH_SHORT).show();

                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        } );

    }

    @Override
    public void showBusNumberList(final List<GetBusNumberData> getBusNumberDataListt) {
        ArrayList<String> buses=new ArrayList<>(  );
        for(int i=0;i<getBusNumberDataListt.size();i++)
        {
            buses.add( getBusNumberDataListt.get( i ).getName() );
        }
        busNumberSpinnerAdapter =new BusNumberSpinnerAdapter( getContext(), R.layout.guide_name_spinner_item);
        busNumberSpinnerAdapter.addAll( buses );
        busNumberSpinnerAdapter.add( "رقم الحافلة");
        busNumberSpinner.setAdapter( busNumberSpinnerAdapter );
        busNumberSpinner.setPrompt("رقم الحافلة");
        busNumberSpinner.setSelection( busNumberSpinnerAdapter.getCount() );
        busNumberSpinner.setOnItemSelectedListener( new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (busNumberSpinner.getSelectedItem()=="رقم الحافلة")
                {

                }
                else
                {
                    BusNumberModel=busNumberSpinner.getSelectedItem().toString();
                    /*for (i=0;i<locationDatalist.size();i++)
                    {
                        if(locationDatalist.get(i).getCountry().equals( LocationModel ))
                        {
                            LocationModelID=locationDatalist.get(i).getId();
                        }
                    }*/
                    for ( i=0;i<getBusNumberDataListt.size();i++)
                    {
                        if(getBusNumberDataListt.get(i).getName().equals(BusNumberModel))
                        {
                            BusNumberModelID=Integer.valueOf(getBusNumberDataListt.get(i).getId());
                        }
                    }

                    Toast.makeText(getContext(),String.valueOf(BusNumberModelID), Toast.LENGTH_SHORT).show();


                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        } );

    }

    @Override
    public void showDriverNameList(final List<GetDriverNameData> getDriverNameDataList) {
        ArrayList<String> driverNames=new ArrayList<>(  );
        for(int i=0;i<getDriverNameDataList.size();i++)
        {
            driverNames.add( getDriverNameDataList.get( i ).getName() );
        }
        driverNameSpinnerAdapter =new DriverNameSpinnerAdapter( getContext(), R.layout.guide_name_spinner_item);
        driverNameSpinnerAdapter.addAll( driverNames );
        driverNameSpinnerAdapter.add( "اسم السائق");
        driverNameSpinner.setAdapter(  driverNameSpinnerAdapter );
        driverNameSpinner.setPrompt("اسم السائق");
        driverNameSpinner.setSelection(  driverNameSpinnerAdapter.getCount() );
        driverNameSpinner.setOnItemSelectedListener( new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if ( driverNameSpinner.getSelectedItem()=="اسم السائق")
                {

                }
                else
                {
                    DriverNameModel= driverNameSpinner.getSelectedItem().toString();
                    /*for (i=0;i<locationDatalist.size();i++)
                    {
                        if(locationDatalist.get(i).getCountry().equals( LocationModel ))
                        {
                            LocationModelID=locationDatalist.get(i).getId();
                        }
                    }*/
                    for ( i=0;i<getDriverNameDataList.size();i++)
                    {
                        if(getDriverNameDataList.get(i).getName().equals(DriverNameModel))
                        {
                            DriverNameModelID=Integer.valueOf(getDriverNameDataList.get(i).getId());
                        }
                    }

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        } );

    }

    @Override
    public void showError() {

    }

    @Override
    public void showMemeberNameList(final List<GetMemberNameData> getMemberNameDataList) {
        ArrayList<String> memberNames=new ArrayList<>(  );
       for (int i=0;i<getMemberNameDataList.size();i++)
       {
           memberNames.add(getMemberNameDataList.get(i).getName());
       }
        memberNameSpinnerAdapter =new MemberNameSpinnerAdapter( getContext(), R.layout.guide_name_spinner_item);
        memberNameSpinnerAdapter.addAll( memberNames );
        memberNameSpinnerAdapter.add( "اسم المرشد");
        memberNameSpinner.setAdapter( memberNameSpinnerAdapter );
        memberNameSpinner.setPrompt("اسم المرشد");
        memberNameSpinner.setSelection( memberNameSpinnerAdapter.getCount() );
        memberNameSpinner.setOnItemSelectedListener( new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (memberNameSpinner.getSelectedItem()=="اسم المرشد")
                {

                }
                else
                {
                    MemberNameModel=memberNameSpinner.getSelectedItem().toString();
                    /*for (i=0;i<locationDatalist.size();i++)
                    {
                        if(locationDatalist.get(i).getCountry().equals( LocationModel ))
                        {
                            LocationModelID=locationDatalist.get(i).getId();
                        }
                    }*/
                    for ( i=0;i<getMemberNameDataList.size();i++)
                    {
                        if(getMemberNameDataList.get(i).getName().equals(GuideNameModel))
                        {
                            GuideNameModelID=Integer.valueOf(getMemberNameDataList.get(i).getId());
                        }
                    }

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        } );


    }

    @Override
    public void showMemeberNameError() {

    }

    @Override
    public void showAddTripResult(String Msg) {
        Toast.makeText(getContext(), Msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showAddTripError() {

    }
}
