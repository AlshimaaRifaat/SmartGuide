package com.example.alshimaa.smartguide.presenter;

import android.content.Context;

import com.example.alshimaa.smartguide.api.Client;
import com.example.alshimaa.smartguide.api.Service;
import com.example.alshimaa.smartguide.model.FollowFlightsResponse;
import com.example.alshimaa.smartguide.model.HomeMemberResponse;
import com.example.alshimaa.smartguide.view.HomeGuideView;
import com.example.alshimaa.smartguide.view.HomeMemberView;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeMemberPresenter {
    Context context;
    HomeMemberView homeMemberView;

    public HomeMemberPresenter(Context context, HomeMemberView homeMemberView) {
        this.context = context;
        this.homeMemberView = homeMemberView;
    }

    public void getHomeMemberResult(String User_token)
    {
        HashMap<String,String> hashMap=new HashMap<>(  );
        hashMap.put("user_token",User_token);

        Service service= Client.getClient().create( Service.class );
        Call<HomeMemberResponse> call=service.getHomeMemberData( hashMap );

        call.enqueue( new Callback<HomeMemberResponse>() {
            @Override
            public void onResponse(Call<HomeMemberResponse> call, Response<HomeMemberResponse> response) {
                if(response.isSuccessful())
                {
                    homeMemberView.showHomeMemberList( response.body().getData() );
                }
            }

            @Override
            public void onFailure(Call<HomeMemberResponse> call, Throwable t) {
                homeMemberView.showHomeMemberError(  );
            }
        } );
    }
}

