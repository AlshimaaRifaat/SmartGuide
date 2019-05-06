package com.example.alshimaa.smartguide.presenter;

import android.content.Context;
import android.widget.Toast;

import com.example.alshimaa.smartguide.api.Client;
import com.example.alshimaa.smartguide.api.Service;
import com.example.alshimaa.smartguide.model.EndTripDriverResponse;
import com.example.alshimaa.smartguide.model.FollowFlightsResponse;
import com.example.alshimaa.smartguide.view.EndTripDriverView;
import com.example.alshimaa.smartguide.view.FollowFlightsView;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EndTripDriverPresenter {
    Context context;
    EndTripDriverView endTripDriverView;

    public EndTripDriverPresenter(Context context, EndTripDriverView endTripDriverView) {
        this.context = context;
        this.endTripDriverView = endTripDriverView;
    }

    public void getEndTripDriverResult( String User_token, String trip_id,String headings,String message)
    {
        HashMap<String,String> hashMap=new HashMap<>(  );
        hashMap.put("user_token",User_token);
        hashMap.put("trip_id",trip_id);
        hashMap.put("headings",headings);
        hashMap.put("message",message);
        Service service= Client.getClient().create( Service.class );
        Call<EndTripDriverResponse> call=service.getEndTripDriverData( hashMap );

        call.enqueue( new Callback<EndTripDriverResponse>() {
            @Override
            public void onResponse(Call<EndTripDriverResponse> call, Response<EndTripDriverResponse> response) {
                if(response.isSuccessful())
                {

                    endTripDriverView.showEndTripDriverMsg( response.body().getData() );

                }
            }

            @Override
            public void onFailure(Call<EndTripDriverResponse> call, Throwable t) {
                endTripDriverView.showEndTripError(  );
            }
        } );
    }


}
