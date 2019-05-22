package com.example.alshimaa.smartguide.presenter;

import android.content.Context;

import com.example.alshimaa.smartguide.api.Client;
import com.example.alshimaa.smartguide.api.Service;
import com.example.alshimaa.smartguide.model.GetGuideNameResponse;
import com.example.alshimaa.smartguide.model.StartTripResponse;
import com.example.alshimaa.smartguide.view.GetGuideNameView;
import com.example.alshimaa.smartguide.view.StartTripView;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StartTripPresenter {
    Context context;
    StartTripView startTripView;

    public StartTripPresenter(Context context, StartTripView startTripView) {
        this.context = context;
        this.startTripView = startTripView;
    }

    public void getStartTripResult(String user_token,String trip_id,String headings,String message)
    {
        HashMap<String,String> hashMap=new HashMap<>(  );
        hashMap.put("user_token",user_token);
        hashMap.put("trip_id",trip_id);
        hashMap.put("headings",headings);
        hashMap.put("message",message);
        // hashMap.put("id",ID);

        Service service= Client.getClient().create( Service.class );
        Call<StartTripResponse> call=service.getStartTripData( hashMap );

        call.enqueue( new Callback<StartTripResponse>() {
            @Override
            public void onResponse(Call<StartTripResponse> call, Response<StartTripResponse> response) {
                if(response.isSuccessful())
                {
                    startTripView.showStartTripMsg( response.body().getData() );
                }
            }

            @Override
            public void onFailure(Call<StartTripResponse> call, Throwable t) {
                startTripView.showStartTripError();
            }
        } );
    }

    public void getPauseResult(String user_token,String trip_id,String headings,
                               String message,String status)
    {
        HashMap<String,String> hashMap=new HashMap<>(  );
        hashMap.put("user_token",user_token);
        hashMap.put("trip_id",trip_id);
        hashMap.put("headings",headings);
        hashMap.put("message",message);
        hashMap.put("status",status);
        // hashMap.put("id",ID);

        Service service= Client.getClient().create( Service.class );
        Call<StartTripResponse> call=service.getPauseTripData( hashMap );

        call.enqueue( new Callback<StartTripResponse>() {
            @Override
            public void onResponse(Call<StartTripResponse> call, Response<StartTripResponse> response) {
                if(response.isSuccessful())
                {
                    startTripView.showPauseTripMsg( response.body().getData() );
                }
            }

            @Override
            public void onFailure(Call<StartTripResponse> call, Throwable t) {
                startTripView.showPauseTripError();
            }
        } );
    }

    public void getRequestPauseResult(String user_token,String trip_id,String headings,
                               String message,String status)
    {
        HashMap<String,String> hashMap=new HashMap<>(  );
        hashMap.put("user_token",user_token);
        hashMap.put("trip_id",trip_id);
        hashMap.put("headings",headings);
        hashMap.put("message",message);
         hashMap.put("status",status);

        Service service= Client.getClient().create( Service.class );
        Call<StartTripResponse> call=service.getRequestPauseTripData( hashMap );

        call.enqueue( new Callback<StartTripResponse>() {
            @Override
            public void onResponse(Call<StartTripResponse> call, Response<StartTripResponse> response) {
                if(response.isSuccessful())
                {
                    startTripView.showRequestPauseTripMsg( response.body().getData() );
                }
            }

            @Override
            public void onFailure(Call<StartTripResponse> call, Throwable t) {
                startTripView.showRequestPauseTripError();
            }
        } );
    }

    public void getRequestPauseGuideResult(String user_token,String trip_id,String headings,
                                      String message)
    {
        HashMap<String,String> hashMap=new HashMap<>(  );
        hashMap.put("user_token",user_token);
        hashMap.put("trip_id",trip_id);
        hashMap.put("headings",headings);
        hashMap.put("message",message);

        Service service= Client.getClient().create( Service.class );
        Call<StartTripResponse> call=service.getRequestPauseGuideData( hashMap );

        call.enqueue( new Callback<StartTripResponse>() {
            @Override
            public void onResponse(Call<StartTripResponse> call, Response<StartTripResponse> response) {
                if(response.isSuccessful())
                {
                    startTripView.showRequestPauseTripGuideMsg( response.body().getData() );
                }
            }

            @Override
            public void onFailure(Call<StartTripResponse> call, Throwable t) {
                startTripView.showRequestPauseTripError();
            }
        } );
    }

    public void getEndTripResult(String user_token,String trip_id,String headings,String message)
    {
        HashMap<String,String> hashMap=new HashMap<>(  );
        hashMap.put("user_token",user_token);
        hashMap.put("trip_id",trip_id);
        hashMap.put("headings",headings);
        hashMap.put("message",message);
        // hashMap.put("id",ID);

        Service service= Client.getClient().create( Service.class );
        Call<StartTripResponse> call=service.getendTripSupervisorData( hashMap );

        call.enqueue( new Callback<StartTripResponse>() {
            @Override
            public void onResponse(Call<StartTripResponse> call, Response<StartTripResponse> response) {
                if(response.isSuccessful())
                {
                    startTripView.showStartTripMsg( response.body().getData() );
                }
            }

            @Override
            public void onFailure(Call<StartTripResponse> call, Throwable t) {
                startTripView.showStartTripError();
            }
        } );
    }

}
