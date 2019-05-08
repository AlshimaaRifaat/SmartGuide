package com.example.alshimaa.smartguide.presenter;

import android.content.Context;

import com.example.alshimaa.smartguide.api.Client;
import com.example.alshimaa.smartguide.api.Service;
import com.example.alshimaa.smartguide.model.OldRequestsGuideResponse;
import com.example.alshimaa.smartguide.model.OldRequestsSupervisorResponse;
import com.example.alshimaa.smartguide.view.OldRequestsGuideView;
import com.example.alshimaa.smartguide.view.OldRequestsSupervisorView;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OldRequestsSupervisorPresenter {
    Context context;
    OldRequestsSupervisorView oldRequestsSupervisorView;

    public OldRequestsSupervisorPresenter(Context context, OldRequestsSupervisorView oldRequestsSupervisorView) {
        this.context = context;
        this.oldRequestsSupervisorView = oldRequestsSupervisorView;
    }

    public void getOldRequestsSupervisorResult(String User_token)
    {
        HashMap<String,String> hashMap=new HashMap<>(  );
        hashMap.put("user_token",User_token);

        Service service= Client.getClient().create( Service.class );
        Call<OldRequestsSupervisorResponse> call=service.getOldRequestsSupervisorData( hashMap );

        call.enqueue( new Callback<OldRequestsSupervisorResponse>() {
            @Override
            public void onResponse(Call<OldRequestsSupervisorResponse> call, Response<OldRequestsSupervisorResponse> response) {
                if(response.isSuccessful())
                {

                    oldRequestsSupervisorView.showOldRequestsSupervisorList( response.body().getData() );

                }
            }

            @Override
            public void onFailure(Call<OldRequestsSupervisorResponse> call, Throwable t) {
                oldRequestsSupervisorView.showOldRequestsSupervisorError(  );
            }
        } );
    }
}



