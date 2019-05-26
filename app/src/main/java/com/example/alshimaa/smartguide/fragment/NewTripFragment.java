package com.example.alshimaa.smartguide.fragment;


import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.SharedPreferences;
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
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.alshimaa.smartguide.NetworkConnection;
import com.example.alshimaa.smartguide.R;
import com.example.alshimaa.smartguide.SplashActivity;
import com.example.alshimaa.smartguide.activity.NavigationActivity;
import com.example.alshimaa.smartguide.adapter.BusNumberSpinnerAdapter;
import com.example.alshimaa.smartguide.adapter.DriverNameSpinnerAdapter;
import com.example.alshimaa.smartguide.adapter.GuideNameSpinnerAdapter;
import com.example.alshimaa.smartguide.adapter.MemberNameSpinnerAdapter;
import com.example.alshimaa.smartguide.adapter.PathSpinnerAdapter;
import com.example.alshimaa.smartguide.adapter.StatusSpinnerAdapter;
import com.example.alshimaa.smartguide.model.GetBusNumberData;
import com.example.alshimaa.smartguide.model.GetDriverNameData;
import com.example.alshimaa.smartguide.model.GetGuideNameData;
import com.example.alshimaa.smartguide.model.GetMemberNameData;
import com.example.alshimaa.smartguide.model.GetPathData;
import com.example.alshimaa.smartguide.presenter.AddTripPresenter;
import com.example.alshimaa.smartguide.presenter.GetBusNumberPresenter;
import com.example.alshimaa.smartguide.presenter.GetDriverNamePresenter;
import com.example.alshimaa.smartguide.presenter.GetGuideNamePresenter;
import com.example.alshimaa.smartguide.presenter.GetMemberNamePresenter;
import com.example.alshimaa.smartguide.presenter.GetPathPresenter;
import com.example.alshimaa.smartguide.view.AddTripView;
import com.example.alshimaa.smartguide.view.GetBusNumberView;
import com.example.alshimaa.smartguide.view.GetDriverNameView;
import com.example.alshimaa.smartguide.view.GetGuideNameView;
import com.example.alshimaa.smartguide.view.GetMemberNameView;
import com.example.alshimaa.smartguide.view.GetPathView;
import com.fourhcode.forhutils.FUtilsValidation;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewTripFragment extends Fragment implements GetGuideNameView,GetBusNumberView
,GetDriverNameView,AddTripView,GetPathView{
   @BindView(R.id.new_trip_text_start_date) TextView startDateTxt;
    @BindView(R.id.new_trip_text_end_date) TextView endDateTxt;
  //  @BindView(R.id.new_trip_btn_new_trip) Button newTripBtn;
    private Unbinder unbinder;

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
    public Integer DriverNameModelID;
    String DriverNameModel;
    DriverNameSpinnerAdapter driverNameSpinnerAdapter;

    GetMemberNamePresenter getMemberNamePresenter;
    Spinner memberNameSpinner;
    Integer MemberNameModelID;
    String MemberNameModel;
    MemberNameSpinnerAdapter memberNameSpinnerAdapter;

    NetworkConnection networkConnection;
    Toolbar toolbar;
    @BindView(R.id.new_trip_Etext_trip_arabic_name)EditText tripArabicName;
    @BindView(R.id.new_trip_Etext_trip_Latin_name)EditText tripLatinName;

    Context context;
    Button addTripBtn;
    AddTripPresenter addTripPresenter;

    private SimpleDateFormat mSimpleDateFormat;
    private Calendar startDateCalendar,endDateCalendar;

    GetPathPresenter getPathPresenter;
   @BindView(R.id.new_trip_spinner_path) Spinner pathSpinner;
    Integer PathModelID;
    Double Price;

    String PathModel;
    PathSpinnerAdapter pathSpinnerAdapter;

   /* SharedPreferences sharedPreferences;
    public static String CompanyId;*/
   SharedPreferences sharedPreferences_company_id;
    public static String CompanyId;


    String[] statusValueSpinner = {
            "مسندة",
            "مجدولة",
            "فوريه"
    };
   /* List<String> SpinnerValueList = new ArrayList<>();
        SpinnerValueList.add("Item 1");
        SpinnerValueList.add("Item 2");
        SpinnerValueList.add("Item 3");*/

    StatusSpinnerAdapter statusSpinnerAdapter;
    Spinner statusSpinner;
   public static String statusSelectedItemSpinner;
    public NewTripFragment() {
        // Required empty public constructor
    }

View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_new_trip, container, false);
        context=this.getActivity();
        unbinder= ButterKnife.bind(this,view);
        init();
        sharedPreferences_company_id=this.getActivity().getSharedPreferences("def", Context.MODE_PRIVATE);
        CompanyId=sharedPreferences_company_id.getString("company_id",null);
      // Toast.makeText(getContext(), CompanyId, Toast.LENGTH_SHORT).show();
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
        PathFromTo();
        TripStatus();
       // MemberName();

        mSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm", Locale.getDefault());

        startDateTxt.setOnClickListener(startDateTxtListener);

        endDateTxt.setOnClickListener(endDateTxtListener);
        addTrip();

       /* public void showDateTimePicker() {
            final Calendar currentDate = Calendar.getInstance();
            date = Calendar.getInstance();
            new DatePickerDialog(getContext(), new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, final int year, final int monthOfYear, final int dayOfMonth) {
                    date.set(year, monthOfYear, dayOfMonth);
                    new TimePickerDialog(getContext(), new TimePickerDialog.OnTimeSetListener() {
                        @Override
                        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                            date.set(Calendar.HOUR_OF_DAY, hourOfDay);
                            date.set(Calendar.MINUTE, minute);
                            textdate.setText(""+year+"-"+monthOfYear+"-"+dayOfMonth+" "+hourOfDay+":"+minute);
                        }
                    }, currentDate.get(Calendar.HOUR_OF_DAY), currentDate.get(Calendar.MINUTE), false).show();
                }
            }, currentDate.get(Calendar.YEAR), currentDate.get(Calendar.MONTH), currentDate.get(Calendar.DATE)).show();
        }*/

        addTripBtn.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PerformAddingTrip();
            }
        } );

       /* immediateTripBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                immediateTripBtn.setBackgroundColor(getResources().getColor(R.color.colorBlue));
                immediateTripBtn.setTextColor(getResources().getColor(R.color.colorWhite));

                newTripBtn.setBackgroundColor(getResources().getColor(R.color.colorWhite));
                newTripBtn.setTextColor(getResources().getColor(R.color.colorBlue));

                getFragmentManager().beginTransaction().replace(R.id.new_trip_frame_layout,
                        new ImmediateTripFragment()).addToBackStack(null).commit();
            }
        });*/
        /*newTripBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newTripBtn.setBackgroundColor(getResources().getColor(R.color.colorBlue));
                newTripBtn.setTextColor(getResources().getColor(R.color.colorWhite));

                immediateTripBtn.setBackgroundColor(getResources().getColor(R.color.colorWhite));
                immediateTripBtn.setTextColor(getResources().getColor(R.color.colorBlue));


                getFragmentManager().beginTransaction().replace(R.id.new_trip_frame_layout,
                        new AlternativeNewTripFragment()).addToBackStack(null).commit();
            }
        });*/


        return view;
    }

    private void TripStatus() {
        StatusSpinnerAdapter statusSpinnerAdapter = new StatusSpinnerAdapter(getContext(), R.layout.guide_name_spinner_item);

       /* for (int i=0;i<SpinnerValueList.size();i++)
        {
            SelectedItemSpinner=SpinnerValueList.get(i);
        }*/
        statusSpinnerAdapter.addAll(statusValueSpinner);
        statusSpinnerAdapter.add("حالة الرحله");
        statusSpinner.setAdapter(statusSpinnerAdapter);
        statusSpinner.setPrompt("حالة الرحله");

        statusSpinner.setSelection(statusSpinnerAdapter.getCount());

        statusSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                // TODO Auto-generated method stub

                if(statusSpinner.getSelectedItem() == "حالة الرحله")
                {

                    //Do nothing.
                }
                else{

                    //  SpinnerValue=reasonSpinner.getSelectedItem();
                    statusSelectedItemSpinner=statusSpinner.getSelectedItem().toString();

                    /*callUsPresenter.getCallUsResult( userNameEtext.getText().toString(),
                            userEmailEtext.getText().toString(),userPhoneEtext.getText().toString()
                            ,userMsgEtext.getText().toString(),SelectedItemSpinner);*/
                  //  Toast.makeText(getContext(), statusSelectedItemSpinner, Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub

            }
        });

    }

    private void PathFromTo() {
        getPathPresenter=new GetPathPresenter(getContext(),this);
        getPathPresenter.getPathResult( "ar" );
    }

    /* Define the onClickListener, and start the DatePickerDialog with users current time */
    private final View.OnClickListener startDateTxtListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            startDateCalendar = Calendar.getInstance();
            new DatePickerDialog(getContext(), startDateTxtDataSet, startDateCalendar.get(Calendar.YEAR),
                    startDateCalendar.get(Calendar.MONTH), startDateCalendar.get(Calendar.DAY_OF_MONTH)).show();
        }
    };
    /* After user decided on a date, store those in our calendar variable and then start the TimePickerDialog immediately */
    private final DatePickerDialog.OnDateSetListener startDateTxtDataSet = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            startDateCalendar.set(Calendar.YEAR, year);
            startDateCalendar.set(Calendar.MONTH, monthOfYear);
            startDateCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            new TimePickerDialog(getContext(), startTimeTxtDataSet, startDateCalendar.get(Calendar.HOUR_OF_DAY), startDateCalendar.get(Calendar.MINUTE), false).show();
        }
    };

    /* After user decided on a time, save them into our calendar instance, and now parse what our calendar has into the TextView */
    private final TimePickerDialog.OnTimeSetListener startTimeTxtDataSet = new TimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            startDateCalendar.set(Calendar.HOUR_OF_DAY, hourOfDay);
            startDateCalendar.set(Calendar.MINUTE, minute);
            startDateTxt.setText(mSimpleDateFormat.format(startDateCalendar.getTime()));
        }
    };

    /* Define the onClickListener, and start the DatePickerDialog with users current time */
    private final View.OnClickListener endDateTxtListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            endDateCalendar = Calendar.getInstance();
            new DatePickerDialog(getContext(), endDateTxtDataSet, endDateCalendar.get(Calendar.YEAR),
                    endDateCalendar.get(Calendar.MONTH), endDateCalendar.get(Calendar.DAY_OF_MONTH)).show();
        }
    };

    /* After user decided on a date, store those in our calendar variable and then start the TimePickerDialog immediately */
    private final DatePickerDialog.OnDateSetListener endDateTxtDataSet = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            endDateCalendar.set(Calendar.YEAR, year);
            endDateCalendar.set(Calendar.MONTH, monthOfYear);
            endDateCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            new TimePickerDialog(getContext(), endTimeTxtDataSet, endDateCalendar.get(Calendar.HOUR_OF_DAY), endDateCalendar.get(Calendar.MINUTE), false).show();
        }
    };
    /* After user decided on a time, save them into our calendar instance, and now parse what our calendar has into the TextView */
    private final TimePickerDialog.OnTimeSetListener endTimeTxtDataSet = new TimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            endDateCalendar.set(Calendar.HOUR_OF_DAY, hourOfDay);
            endDateCalendar.set(Calendar.MINUTE, minute);
            endDateTxt.setText(mSimpleDateFormat.format(endDateCalendar.getTime()));
        }
    };
    private void PerformAddingTrip() {
        FUtilsValidation.isEmpty( tripArabicName,getResources().getString(R.string.pleaseEnterTripArabicName) );
        FUtilsValidation.isEmpty( tripLatinName,getResources().getString(R.string.pleaseEnterTripLatinName));

        NetworkConnection networkConnection=new NetworkConnection( getContext() );
        if (networkConnection.isNetworkAvailable( getContext()))
        {
           /* Toast.makeText(getContext(), "arabic name "+tripArabicName.getText().toString()+
                    "latin "+tripLatinName.getText().toString()+"GuideNameModelID "+String.valueOf(GuideNameModelID)
        +"DriverNameModelID "+String.valueOf(DriverNameModelID)+"BusNumberModelID "+
                    String.valueOf(BusNumberModelID)+"startDateTxt "+startDateTxt.getText()+"endDateTxt "+endDateTxt.getText().toString()
                    +"PathModelID "+String.valueOf(PathModelID)+"token "+SplashActivity.Login, Toast.LENGTH_SHORT).show();*/

           // status/**/,price
                if (!tripArabicName.getText().toString().equals("") &&
                        !tripLatinName.getText().toString().equals("") &&
                        GuideNameModelID.toString()!=null &&
                       String.valueOf(DriverNameModelID) !=null&&
                        String.valueOf(BusNumberModelID)!=null&&
                        String.valueOf(PathModelID)!=null&&
                        statusSelectedItemSpinner!=null&&
                        !startDateTxt.getText().toString().equals("") &&
                        !endDateTxt.getText().toString().equals("")  &&

                        SplashActivity.Login!=null &&
                        String.valueOf(Price)!=null) {
                    if (statusSelectedItemSpinner=="مسندة") {
                        addTripPresenter.getAddTripResult(tripLatinName.getText().toString(),
                                tripArabicName.getText().toString(), String.valueOf(GuideNameModelID), String.valueOf(DriverNameModelID)
                                , String.valueOf(BusNumberModelID), startDateTxt.getText().toString(), endDateTxt.getText().toString()
                                , String.valueOf(PathModelID), CompanyId, SplashActivity.Login, String.valueOf(Price), "1");
                    }
                   /* else if (statusSelectedItemSpinner=="معلق") {
                        addTripPresenter.getAddTripResult(tripLatinName.getText().toString(),
                                tripArabicName.getText().toString(), String.valueOf(GuideNameModelID), String.valueOf(DriverNameModelID)
                                , String.valueOf(BusNumberModelID), startDateTxt.getText().toString(), endDateTxt.getText().toString()
                                , String.valueOf(PathModelID), CompanyId, SplashActivity.Login, String.valueOf(Price), "3");
                    }*/ else if (statusSelectedItemSpinner=="مجدولة") {
                        addTripPresenter.getAddTripResult(tripLatinName.getText().toString(),
                                tripArabicName.getText().toString(), String.valueOf(GuideNameModelID), String.valueOf(DriverNameModelID)
                                , String.valueOf(BusNumberModelID), startDateTxt.getText().toString(), endDateTxt.getText().toString()
                                , String.valueOf(PathModelID), CompanyId, SplashActivity.Login, String.valueOf(Price), "7");
                    }
                    else if (statusSelectedItemSpinner=="فوريه") {
                        addTripPresenter.getAddTripResult(tripLatinName.getText().toString(),
                                tripArabicName.getText().toString(), String.valueOf(GuideNameModelID), String.valueOf(DriverNameModelID)
                                , String.valueOf(BusNumberModelID), startDateTxt.getText().toString(), endDateTxt.getText().toString()
                                , String.valueOf(PathModelID), CompanyId, SplashActivity.Login, String.valueOf(Price), "8");
                    }
                    // still not done
                }




        }else
        {
            Toast.makeText( getContext(), "تأكد من اتصالك بالانترنت", Toast.LENGTH_SHORT ).show();
        }

    }


    private void addTrip() {
        addTripPresenter=new AddTripPresenter(getContext(),this);
    }

    /*private void MemberName() {
        getMemberNamePresenter=new GetMemberNamePresenter(getContext(),this);
        getMemberNamePresenter.getMemberNameResult( "ar" );
    }*/

    private void driverName() {
        getDriverNamePresenter=new GetDriverNamePresenter(getContext(),this);
        getDriverNamePresenter.getDriverNameResult( "ar" );
    }

    private void BusNumber() {
        getBusNumberPresenter=new GetBusNumberPresenter(getContext(),this);
        //getBusNumberPresenter.getBusNumberResult( "ar",String.valueOf(DriverNameModelID));
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
       // memberNameSpinner=view.findViewById( R.id.new_trip_spinner_member_name);
        addTripBtn=view.findViewById(R.id.new_trip_btn_Create_atrip);
        statusSpinner=view.findViewById( R.id.new_trip_spinner_status);

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
        if(context!=null) {
            guideNameSpinnerAdapter = new GuideNameSpinnerAdapter(context, R.layout.guide_name_spinner_item);
            guideNameSpinnerAdapter.addAll(guidesName);

            guideNameSpinnerAdapter.add("اسم المرشد");
            guideNameSpinner.setAdapter(guideNameSpinnerAdapter);
            guideNameSpinner.setPrompt("اسم المرشد");
            guideNameSpinner.setSelection(guideNameSpinnerAdapter.getCount());
            guideNameSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    if (guideNameSpinner.getSelectedItem() == "اسم المرشد") {

                    } else {
                        GuideNameModel = guideNameSpinner.getSelectedItem().toString();
                        for (i = 0; i < getGuideNameDataList.size(); i++) {
                            if (getGuideNameDataList.get(i).getName().equals(GuideNameModel)) {
                                GuideNameModelID = Integer.valueOf(getGuideNameDataList.get(i).getId());

                            }


                        }


                    /*for (i=0;i<locationDatalist.size();i++)
                    {
                        if(locationDatalist.get(i).getCountry().equals( LocationModel ))
                        {
                            LocationModelID=locationDatalist.get(i).getId();
                        }
                    }*/
                        // Toast.makeText(getContext(),String.valueOf(GuideNameModelID), Toast.LENGTH_SHORT).show();

                    }


                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {

                }
            });
        }

    }

    @Override
    public void showBusNumberList(final List<GetBusNumberData> getBusNumberDataListt) {
        ArrayList<String> buses=new ArrayList<>(  );
        for(int i=0;i<getBusNumberDataListt.size();i++)
        {
            buses.add( getBusNumberDataListt.get( i ).getName() );
        }
        if(context!=null) {
            busNumberSpinnerAdapter = new BusNumberSpinnerAdapter(context, R.layout.guide_name_spinner_item);
            busNumberSpinnerAdapter.addAll(buses);
            busNumberSpinnerAdapter.add("رقم الحافلة");
            busNumberSpinner.setAdapter(busNumberSpinnerAdapter);
            busNumberSpinner.setPrompt("رقم الحافلة");
            busNumberSpinner.setSelection(busNumberSpinnerAdapter.getCount());
            busNumberSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    if (busNumberSpinner.getSelectedItem() == "رقم الحافلة") {

                    } else {
                        BusNumberModel = busNumberSpinner.getSelectedItem().toString();
                    /*for (i=0;i<locationDatalist.size();i++)
                    {
                        if(locationDatalist.get(i).getCountry().equals( LocationModel ))
                        {
                            LocationModelID=locationDatalist.get(i).getId();
                        }
                    }*/
                        for (i = 0; i < getBusNumberDataListt.size(); i++) {
                            if (getBusNumberDataListt.get(i).getName().equals(BusNumberModel)) {
                                BusNumberModelID = Integer.valueOf(getBusNumberDataListt.get(i).getId());
                            }
                        }

                        // Toast.makeText(getContext(),"id in bus "+String.valueOf(DriverNameModelID), Toast.LENGTH_SHORT).show();
                        // getBusNumberPresenter.getBusNumberResult("ar",String.valueOf(DriverNameModelID));

                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {

                }
            });
        }

    }

    @Override
    public void showDriverNameList(final List<GetDriverNameData> getDriverNameDataList) {
        ArrayList<String> DriverNames=new ArrayList<>(  );
        for(int i=0;i<getDriverNameDataList.size();i++)
        {
            DriverNames.add( getDriverNameDataList.get( i ).getName() );
        }
        if(context!=null) {
            driverNameSpinnerAdapter = new DriverNameSpinnerAdapter(context, R.layout.guide_name_spinner_item);
            driverNameSpinnerAdapter.addAll(DriverNames);
            driverNameSpinnerAdapter.add("اسم السائق");
            driverNameSpinner.setAdapter(driverNameSpinnerAdapter);
            driverNameSpinner.setPrompt("اسم السائق");
            driverNameSpinner.setSelection(driverNameSpinnerAdapter.getCount());
            driverNameSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    if (driverNameSpinner.getSelectedItem() == "اسم السائق") {

                    } else {
                        DriverNameModel = driverNameSpinner.getSelectedItem().toString();
                        for (i = 0; i < getDriverNameDataList.size(); i++) {
                            if (getDriverNameDataList.get(i).getName().equals(DriverNameModel)) {
                                DriverNameModelID = Integer.valueOf(getDriverNameDataList.get(i).getId());

                            }
                            //Toast.makeText(getContext(),String.valueOf(DriverNameModelID), Toast.LENGTH_SHORT).show();
                        }

                        getBusNumberPresenter.getBusNumberResult("ar", String.valueOf(DriverNameModelID));
                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {

                }
            });
        }

    }

    @Override
    public void showDriverError() {
      //  Toast.makeText(getContext(), re, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showError() {

    }

   /* @Override
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
                    *//*for (i=0;i<locationDatalist.size();i++)
                    {
                        if(locationDatalist.get(i).getCountry().equals( LocationModel ))
                        {
                            LocationModelID=locationDatalist.get(i).getId();
                        }
                    }*//*
                    for ( i=0;i<getMemberNameDataList.size();i++)
                    {
                        if(getMemberNameDataList.get(i).getName().equals(GuideNameModel))
                        {
                            GuideNameModelID=Integer.valueOf(getMemberNameDataList.get(i).getId());
                        }
                    }

                }
            }
*/
          /*  @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        } );


    }

    @Override
    public void showMemeberNameError() {

    }*/

    @Override
    public void showAddTripResult(String Msg) {
        Toast.makeText(getContext(), Msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showAddTripError() {

    }

    @Override
    public void showGetPathList(final List<GetPathData> getPathDataList) {
        ArrayList<String> Pathes = new ArrayList<>();
        for (int i = 0; i < getPathDataList.size(); i++) {
            Pathes.add(getPathDataList.get(i).getFromTo());
        }
        if (context != null) {
            {
                pathSpinnerAdapter = new PathSpinnerAdapter(context, R.layout.guide_name_spinner_item);
                pathSpinnerAdapter.addAll(Pathes);
                pathSpinnerAdapter.add("المسار");
                pathSpinner.setAdapter(pathSpinnerAdapter);
                pathSpinner.setPrompt("المسار");
                pathSpinner.setSelection(pathSpinnerAdapter.getCount());
                pathSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                        if (pathSpinner.getSelectedItem() == "اسم المرشد") {

                        } else {
                            PathModel = pathSpinner.getSelectedItem().toString();
                            for (i = 0; i < getPathDataList.size(); i++) {
                                if (getPathDataList.get(i).getFromTo().equals(PathModel)) {
                                    PathModelID = Integer.valueOf(getPathDataList.get(i).getId());
                                    Price = Double.parseDouble(getPathDataList.get(i).getPrice());


                                }


                            }
                            // Toast.makeText(getContext(),String.valueOf(Price), Toast.LENGTH_SHORT).show();
                    /*for (i=0;i<locationDatalist.size();i++)
                    {
                        if(locationDatalist.get(i).getCountry().equals( LocationModel ))
                        {
                            LocationModelID=locationDatalist.get(i).getId();
                        }
                    }*/


                        }

                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> adapterView) {

                    }
                });
            }

        }
    }

    @Override
    public void showGetPathError() {

    }
}
