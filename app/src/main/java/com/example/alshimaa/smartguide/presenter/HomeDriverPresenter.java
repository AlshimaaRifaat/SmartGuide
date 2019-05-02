package com.example.alshimaa.smartguide.presenter;

import android.content.Context;

import com.example.alshimaa.smartguide.api.Client;
import com.example.alshimaa.smartguide.api.Service;
import com.example.alshimaa.smartguide.model.FollowFlightsResponse;
import com.example.alshimaa.smartguide.view.HomeDriverView;
import com.example.alshimaa.smartguide.view.HomeGuideView;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeDriverPresenter {
    Context context;
    HomeDriverView homeDriverView;

    public HomeDriverPresenter(Context context, HomeDriverView homeDriverView) {
        this.context = context;
        this.homeDriverView = homeDriverView;
    }

    public void getHomeDriverResult(String User_token, String Lang)
    {
        HashMap<String,String> hashMap=new HashMap<>(  );
        hashMap.put("user_token",User_token);
        hashMap.put("lang",Lang);

        Service service= Client.getClient().create( Service.class );
        Call<FollowFlightsResponse> call=service.getHomeDriverData( hashMap );

        call.enqueue( new Callback<FollowFlightsResponse>() {
            @Override
            public void onResponse(Call<FollowFlightsResponse> call, Response<FollowFlightsResponse> response) {
                if(response.isSuccessful())
                {

                    homeDriverView.showHomeDriverList( response.body().getData() );

                }
            }

            @Override
            public void onFailure(Call<FollowFlightsResponse> call, Throwable t) {
                homeDriverView.showHomeDriverError(  );
            }
        } );
    }
}

