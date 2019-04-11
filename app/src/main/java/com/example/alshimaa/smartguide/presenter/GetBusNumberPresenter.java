package com.example.alshimaa.smartguide.presenter;

import android.content.Context;

import com.example.alshimaa.smartguide.api.Client;
import com.example.alshimaa.smartguide.api.Service;
import com.example.alshimaa.smartguide.model.GetBusNumberResponse;
import com.example.alshimaa.smartguide.model.GetGuideNameResponse;
import com.example.alshimaa.smartguide.view.GetBusNumberView;
import com.example.alshimaa.smartguide.view.GetGuideNameView;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GetBusNumberPresenter {
    Context context;
    GetBusNumberView getBusNumberView;

    public GetBusNumberPresenter(Context context, GetBusNumberView getBusNumberView) {
        this.context = context;
        this.getBusNumberView = getBusNumberView;
    }

    public void getBusNumberResult(String Lang,String Driver_Id)
    {
        HashMap<String,String> hashMap=new HashMap<>(  );
        hashMap.put("lang",Lang);
        hashMap.put("driver_id",Driver_Id);
        Service service= Client.getClient().create( Service.class );
        Call<GetBusNumberResponse> call=service.getBusNumberData( hashMap );

        call.enqueue( new Callback<GetBusNumberResponse>() {
            @Override
            public void onResponse(Call<GetBusNumberResponse> call, Response<GetBusNumberResponse> response) {
                if(response.isSuccessful())
                {

                    getBusNumberView.showBusNumberList( response.body().getData() );

                }
            }

            @Override
            public void onFailure(Call<GetBusNumberResponse> call, Throwable t) {
                getBusNumberView.showError(  );
            }
        } );
    }
}
