package com.example.alshimaa.smartguide.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Spinner;

import com.example.alshimaa.smartguide.NetworkConnection;
import com.example.alshimaa.smartguide.R;
import com.example.alshimaa.smartguide.adapter.GuideNameSpinnerAdapter;
import com.example.alshimaa.smartguide.model.GetGuideNameData;
import com.example.alshimaa.smartguide.presenter.GetGuideNamePresenter;
import com.example.alshimaa.smartguide.view.GetGuideNameView;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewTripFragment extends Fragment implements GetGuideNameView{

    GetGuideNamePresenter getGuideNamePresenter;
    Spinner guideNameSpinner;
    Integer GuideNameModelID;
    String GuideNameModel;
    GuideNameSpinnerAdapter guideNameSpinnerAdapter;

    NetworkConnection networkConnection;
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
        networkConnection=new NetworkConnection( getContext() );
        GuideName();

        return view;
    }

    private void GuideName() {
        getGuideNamePresenter=new GetGuideNamePresenter(getContext(),this);
        getGuideNamePresenter.getGuideNameResult( "ar" );
    }

    private void init() {
        guideNameSpinner=view.findViewById( R.id.new_trip_spinner_guide_name );
    }

    @Override
    public void showGuideNameList(List<GetGuideNameData> getGuideNameDataList) {
        ArrayList<String> locations=new ArrayList<>(  );
        for(int i=0;i<getGuideNameDataList.size();i++)
        {
            locations.add( getGuideNameDataList.get( i ).getName() );
        }

        guideNameSpinnerAdapter =new GuideNameSpinnerAdapter( getContext(), R.layout.guide_name_spinner_item);
        guideNameSpinnerAdapter.addAll( locations );
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
        } );

    }

    @Override
    public void showError() {

    }
}
