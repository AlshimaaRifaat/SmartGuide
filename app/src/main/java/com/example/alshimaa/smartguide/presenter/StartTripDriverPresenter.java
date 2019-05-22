package com.example.alshimaa.smartguide.presenter;

import android.content.Context;

import com.example.alshimaa.smartguide.api.Client;
import com.example.alshimaa.smartguide.api.Service;
import com.example.alshimaa.smartguide.model.StartTripResponse;
import com.example.alshimaa.smartguide.view.StartTripDriverView;
import com.example.alshimaa.smartguide.view.StartTripGuideView;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StartTripDriverPresenter {
    Context context;
    StartTripDriverView startTripDriverView;

    public StartTripDriverPresenter(Context context, StartTripDriverView startTripDriverView) {
        this.context = context;
        this.startTripDriverView = startTripDriverView;
    }

    public void getStartTripDriverResult(String user_token, String trip_id, String headings, String message)
    {
        HashMap<String,String> hashMap=new HashMap<>(  );
        hashMap.put("user_token",user_token);
        hashMap.put("trip_id",trip_id);
        hashMap.put("headings",headings);
        hashMap.put("message",message);
        // hashMap.put("id",ID);

        Service service= Client.getClient().create( Service.class );
        Call<StartTripResponse> call=service.getstartTripDriverData( hashMap );

        call.enqueue( new Callback<StartTripResponse>() {
            @Override
            public void onResponse(Call<StartTripResponse> call, Response<StartTripResponse> response) {
                if(response.isSuccessful())
                {
                    startTripDriverView.showStartTripDriverMsg( response.body().getData() );
                }
            }

            @Override
            public void onFailure(Call<StartTripResponse> call, Throwable t) {
                startTripDriverView.showStartTripDriverError();
            }
        } );
    }


}
