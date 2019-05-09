package com.example.alshimaa.smartguide.presenter;

import android.content.Context;

import com.example.alshimaa.smartguide.api.Client;
import com.example.alshimaa.smartguide.api.Service;
import com.example.alshimaa.smartguide.model.EndTripDriverResponse;
import com.example.alshimaa.smartguide.model.EndTripGuideResponse;
import com.example.alshimaa.smartguide.view.EndTripDriverView;
import com.example.alshimaa.smartguide.view.EndTripGuideView;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EndTripGuidePresenter {
    Context context;
    EndTripGuideView endTripGuideView;

    public EndTripGuidePresenter(Context context, EndTripGuideView endTripGuideView) {
        this.context = context;
        this.endTripGuideView = endTripGuideView;
    }

    public void getEndTripGuideResult(String User_token, String trip_id, String headings, String message)
    {
        HashMap<String,String> hashMap=new HashMap<>(  );
        hashMap.put("user_token",User_token);
        hashMap.put("trip_id",trip_id);
        hashMap.put("headings",headings);
        hashMap.put("message",message);
        Service service= Client.getClient().create( Service.class );
        Call<EndTripGuideResponse> call=service.getEndTripGuideData( hashMap );

        call.enqueue( new Callback<EndTripGuideResponse>() {
            @Override
            public void onResponse(Call<EndTripGuideResponse> call, Response<EndTripGuideResponse> response) {
                if(response.isSuccessful())
                {

                    endTripGuideView.showEndTripGuideMsg( response.body().getData() );

                }
            }

            @Override
            public void onFailure(Call<EndTripGuideResponse> call, Throwable t) {
                endTripGuideView.showEndTripGuideError();
            }
        } );
    }


}

