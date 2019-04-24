package com.example.alshimaa.smartguide.presenter;

import android.content.Context;

import com.example.alshimaa.smartguide.api.Client;
import com.example.alshimaa.smartguide.api.Service;
import com.example.alshimaa.smartguide.model.FollowFlightsResponse;
import com.example.alshimaa.smartguide.view.FollowFlightsView;
import com.example.alshimaa.smartguide.view.HomeGuideView;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeGuidePresenter {
    Context context;
    HomeGuideView homeGuideView;

    public HomeGuidePresenter(Context context, HomeGuideView homeGuideView) {
        this.context = context;
        this.homeGuideView = homeGuideView;
    }

    public void getHomeGuideResult(String User_token, String Lang)
    {
        HashMap<String,String> hashMap=new HashMap<>(  );
        hashMap.put("user_token",User_token);
        hashMap.put("lang",Lang);

        Service service= Client.getClient().create( Service.class );
        Call<FollowFlightsResponse> call=service.getHomeGuideData( hashMap );

        call.enqueue( new Callback<FollowFlightsResponse>() {
            @Override
            public void onResponse(Call<FollowFlightsResponse> call, Response<FollowFlightsResponse> response) {
                if(response.isSuccessful())
                {

                    homeGuideView.showHomeGuideList( response.body().getData() );

                }
            }

            @Override
            public void onFailure(Call<FollowFlightsResponse> call, Throwable t) {
                homeGuideView.showHomeGuideError(  );
            }
        } );
    }
}
