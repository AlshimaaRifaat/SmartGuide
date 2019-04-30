package com.example.alshimaa.smartguide.presenter;

import android.content.Context;

import com.example.alshimaa.smartguide.api.Client;
import com.example.alshimaa.smartguide.api.Service;
import com.example.alshimaa.smartguide.model.FollowFlightsResponse;
import com.example.alshimaa.smartguide.model.OldRequestsGuideResponse;
import com.example.alshimaa.smartguide.view.HomeGuideView;
import com.example.alshimaa.smartguide.view.OldRequestsGuideView;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OldRequestsGuidePresenter {
    Context context;
    OldRequestsGuideView oldRequestsGuideView;

    public OldRequestsGuidePresenter(Context context, OldRequestsGuideView oldRequestsGuideView) {
        this.context = context;
        this.oldRequestsGuideView = oldRequestsGuideView;
    }

    public void getOldRequestsGuideResult(String User_token)
    {
        HashMap<String,String> hashMap=new HashMap<>(  );
        hashMap.put("user_token",User_token);

        Service service= Client.getClient().create( Service.class );
        Call<OldRequestsGuideResponse> call=service.getOldRequestsGuideData( hashMap );

        call.enqueue( new Callback<OldRequestsGuideResponse>() {
            @Override
            public void onResponse(Call<OldRequestsGuideResponse> call, Response<OldRequestsGuideResponse> response) {
                if(response.isSuccessful())
                {

                    oldRequestsGuideView.showOldRequestsGuideList( response.body().getData() );

                }
            }

            @Override
            public void onFailure(Call<OldRequestsGuideResponse> call, Throwable t) {
                oldRequestsGuideView.showOldRequestsError(  );
            }
        } );
    }
}


