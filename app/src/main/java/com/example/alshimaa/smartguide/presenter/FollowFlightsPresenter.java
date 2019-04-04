package com.example.alshimaa.smartguide.presenter;

import android.content.Context;

import com.example.alshimaa.smartguide.api.Client;
import com.example.alshimaa.smartguide.api.Service;
import com.example.alshimaa.smartguide.model.FollowFlightsResponse;
import com.example.alshimaa.smartguide.model.GetBusNumberResponse;
import com.example.alshimaa.smartguide.view.FollowFlightsView;
import com.example.alshimaa.smartguide.view.GetBusNumberView;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FollowFlightsPresenter {
    Context context;
    FollowFlightsView followFlightsView;

    public FollowFlightsPresenter(Context context, FollowFlightsView followFlightsView) {
        this.context = context;
        this.followFlightsView = followFlightsView;
    }

    public void getFollowFlightsResult(String Lang,String User_token,String Type)
    {
        HashMap<String,String> hashMap=new HashMap<>(  );
        hashMap.put("lang",Lang);
        hashMap.put("user_token",User_token);
        hashMap.put("type",Type);
        Service service= Client.getClient().create( Service.class );
        Call<FollowFlightsResponse> call=service.getFollowFlightsData( hashMap );

        call.enqueue( new Callback<FollowFlightsResponse>() {
            @Override
            public void onResponse(Call<FollowFlightsResponse> call, Response<FollowFlightsResponse> response) {
                if(response.isSuccessful())
                {

                    followFlightsView.showFollowFlightsList( response.body().getData() );

                }
            }

            @Override
            public void onFailure(Call<FollowFlightsResponse> call, Throwable t) {
                followFlightsView.showFollowFlightsError(  );
            }
        } );
    }
}
