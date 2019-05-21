package com.example.alshimaa.smartguide.presenter;

import android.content.Context;

import com.example.alshimaa.smartguide.api.Client;
import com.example.alshimaa.smartguide.api.Service;
import com.example.alshimaa.smartguide.model.FollowFlightsResponse;
import com.example.alshimaa.smartguide.model.GetTripsMemberSupervisorResponse;
import com.example.alshimaa.smartguide.view.GetTripsMemberSupervisorView;
import com.example.alshimaa.smartguide.view.HomeGuideView;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GetTripsMemberSupervisorPresenter {
    Context context;
    GetTripsMemberSupervisorView getTripsMemberSupervisorView;

    public GetTripsMemberSupervisorPresenter(Context context, GetTripsMemberSupervisorView getTripsMemberSupervisorView) {
        this.context = context;
        this.getTripsMemberSupervisorView = getTripsMemberSupervisorView;
    }

    public void getTripsMemberSupervisorResult(String supervisor_id)
    {
        HashMap<String,String> hashMap=new HashMap<>(  );
        hashMap.put("supervisor_id",supervisor_id);

        Service service= Client.getClient().create( Service.class );
        Call<GetTripsMemberSupervisorResponse> call=service.getTripsMemberSupervisorData( hashMap );

        call.enqueue( new Callback<GetTripsMemberSupervisorResponse>() {
            @Override
            public void onResponse(Call<GetTripsMemberSupervisorResponse> call, Response<GetTripsMemberSupervisorResponse> response) {
                if(response.isSuccessful())
                {
                    getTripsMemberSupervisorView.showTripsMemberSupervisorList( response.body().getData() );
                }
            }

            @Override
            public void onFailure(Call<GetTripsMemberSupervisorResponse> call, Throwable t) {
                getTripsMemberSupervisorView.showTripsMemberSupervisorError(  );
            }
        } );
    }
}

