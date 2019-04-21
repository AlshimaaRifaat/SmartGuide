package com.example.alshimaa.smartguide.presenter;

import android.content.Context;
import android.widget.Toast;

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
    public void getSortByStatusResult(String User_token,String Lang,String Status)
    {
        HashMap<String,String> hashMap=new HashMap<>(  );
        hashMap.put("user_token",User_token);
        hashMap.put("lang",Lang);
        hashMap.put("status",Status);
        Service service= Client.getClient().create( Service.class );
        Call<FollowFlightsResponse> call=service.getSortByStatusData( hashMap );

        call.enqueue( new Callback<FollowFlightsResponse>() {
            @Override
            public void onResponse(Call<FollowFlightsResponse> call, Response<FollowFlightsResponse> response) {
                if(response.code()==200)
                {

                    followFlightsView.showSortByStatusList( response.body().getData() );

                }else if (response.code()==404)
                {
                    Toast.makeText(context, "لا توجد نتيجه", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<FollowFlightsResponse> call, Throwable t) {
                followFlightsView.showSortByStatusError( );
            }
        } );
    }

    public void getSortByDateResult(String User_token,String Lang,String Status)
    {
        HashMap<String,String> hashMap=new HashMap<>(  );
        hashMap.put("user_token",User_token);
        hashMap.put("lang",Lang);
        hashMap.put("status",Status);
        Service service= Client.getClient().create( Service.class );
        Call<FollowFlightsResponse> call=service.getSortByDateData( hashMap );

        call.enqueue( new Callback<FollowFlightsResponse>() {
            @Override
            public void onResponse(Call<FollowFlightsResponse> call, Response<FollowFlightsResponse> response) {
                if(response.code()==200)
                {

                    followFlightsView.showSortByDateList( response.body().getData() );

                }else if (response.code()==404)
                {
                    Toast.makeText(context, "لا توجد نتيجه", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<FollowFlightsResponse> call, Throwable t) {
                followFlightsView.showSortByDateError( );
            }
        } );
    }
}
