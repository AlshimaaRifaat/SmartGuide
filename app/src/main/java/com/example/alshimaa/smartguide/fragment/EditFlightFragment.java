package com.example.alshimaa.smartguide.fragment;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.alshimaa.smartguide.NetworkConnection;
import com.example.alshimaa.smartguide.R;
import com.example.alshimaa.smartguide.SplashActivity;
import com.example.alshimaa.smartguide.adapter.StatusSpinnerAdapter;
import com.example.alshimaa.smartguide.model.FollowFlightsData;
import com.example.alshimaa.smartguide.presenter.EditTripStatusPresenter;
import com.example.alshimaa.smartguide.view.EditTripStatusView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class EditFlightFragment extends Fragment implements EditTripStatusView {

    @BindView(R.id.edit_trip_btn_save_edit) Button saveEdit;


EditTripStatusPresenter editTripStatusPresenter;
NetworkConnection networkConnection;

    String[] statusValueSpinner = {
            "قيد التنفيذ",
            "معلق",
            "ملغيه"
    };

   public static String statusSelectedItemSpinner;
    @BindView(R.id.edit_trip_spinner_status) Spinner statusSpinner;
    Unbinder unbinder;
    SharedPreferences.Editor sharedPref_status;
    public EditFlightFragment() {
        // Required empty public constructor
    }

View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_edit_flight, container, false);
        unbinder= ButterKnife.bind(this,view);

      //  DetailsFollowFlightsFragment.TripStatus = followFlightsData.getStatus();
        EditTripStatus();
        saveEdit.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                performSaveEditTripStatus();
                sharedPref_status=getContext().getSharedPreferences("status", Context.MODE_PRIVATE).edit();
                sharedPref_status.putString("trip_status", statusSelectedItemSpinner);
                sharedPref_status.apply();

            }
        } );
      //  Toast.makeText(getContext(), DetailsFollowFlightsFragment.TripStatus, Toast.LENGTH_SHORT).show();
        return view;
    }

    private void performSaveEditTripStatus() {
        networkConnection=new NetworkConnection(getContext());
        if (networkConnection.isNetworkAvailable( getContext() ))
        {
            if(!statusSelectedItemSpinner.equals("") )
            {
                if(statusSelectedItemSpinner=="قيد التنفيذ") {
                    editTripStatusPresenter.getEditTripStatusResult(DetailsFollowFlightsFragment.TripId,
                            SplashActivity.Login, "2");
                }else if(statusSelectedItemSpinner=="معلق") {
                    editTripStatusPresenter.getEditTripStatusResult(DetailsFollowFlightsFragment.TripId,
                            SplashActivity.Login, "3");
                }else if(statusSelectedItemSpinner=="ملغيه") {
                    editTripStatusPresenter.getEditTripStatusResult(DetailsFollowFlightsFragment.TripId,
                            SplashActivity.Login, "4");
                }

            }
            else
            {
                Toast.makeText( getContext(),   "من فضلك املا البيانات الخاصه بك", Toast.LENGTH_SHORT ).show();
            }

        }
        else
        {
            Toast.makeText( getContext(), "تاكد من اتصالك بالانترنت"
                    , Toast.LENGTH_SHORT ).show();
        }
    }

    private void EditTripStatus() {
        editTripStatusPresenter=new EditTripStatusPresenter(getContext(),this);
        StatusSpinnerAdapter statusSpinnerAdapter = new StatusSpinnerAdapter(getContext(), R.layout.guide_name_spinner_item);

        statusSpinnerAdapter.addAll(statusValueSpinner);
        statusSpinnerAdapter.add( DetailsFollowFlightsFragment.TripStatus);
        statusSpinner.setAdapter(statusSpinnerAdapter);
       // statusSpinner.setPrompt("حالة الرحله");

        statusSpinner.setSelection(statusSpinnerAdapter.getCount());

        statusSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                // TODO Auto-generated method stub



                    //  SpinnerValue=reasonSpinner.getSelectedItem();
                    statusSelectedItemSpinner=statusSpinner.getSelectedItem().toString();
                    /*callUsPresenter.getCallUsResult( userNameEtext.getText().toString(),
                            userEmailEtext.getText().toString(),userPhoneEtext.getText().toString()
                            ,userMsgEtext.getText().toString(),SelectedItemSpinner);*/
                    //  Toast.makeText(getContext(), statusSelectedItemSpinner, Toast.LENGTH_SHORT).show();


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub

            }
        });

    }


    @Override
    public void showEditTripStatusMsg(String Message) {
        Toast.makeText(getContext(),Message , Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showEditTripStatusError() {

    }
}
