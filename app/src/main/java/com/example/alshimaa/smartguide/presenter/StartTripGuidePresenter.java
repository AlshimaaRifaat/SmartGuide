package com.example.alshimaa.smartguide.presenter;

import android.content.Context;

import com.example.alshimaa.smartguide.api.Client;
import com.example.alshimaa.smartguide.api.Service;
import com.example.alshimaa.smartguide.model.StartTripResponse;
import com.example.alshimaa.smartguide.view.StartTripGuideView;
import com.example.alshimaa.smartguide.view.StartTripView;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StartTripGuidePresenter {
    Context context;
    StartTripGuideView startTripGuideView;

    public StartTripGuidePresenter(Context context, StartTripGuideView startTripGuideView) {
        this.context = context;
        this.startTripGuideView = startTripGuideView;
    }

    public void getStartTripGuideResult(String user_token, String trip_id, String headings, String message)
    {
        HashMap<String,String> hashMap=new HashMap<>(  );
        hashMap.put("user_token",user_token);
        hashMap.put("trip_id",trip_id);
        hashMap.put("headings",headings);
        hashMap.put("message",message);
        // hashMap.put("id",ID);

        Service service= Client.getClient().create( Service.class );
        Call<StartTripResponse> call=service.getstartTripGuideData( hashMap );

        call.enqueue( new Callback<StartTripResponse>() {
            @Override
            public void onResponse(Call<StartTripResponse> call, Response<StartTripResponse> response) {
                if(response.isSuccessful())
                {
                    startTripGuideView.showStartTripGuideMsg( response.body().getData() );
                }
            }

            @Override
            public void onFailure(Call<StartTripResponse> call, Throwable t) {
                startTripGuideView.showStartTripGuideError();
            }
        } );
    }


}

