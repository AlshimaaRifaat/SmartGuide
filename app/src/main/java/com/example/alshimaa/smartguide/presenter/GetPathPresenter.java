package com.example.alshimaa.smartguide.presenter;

import android.content.Context;

import com.example.alshimaa.smartguide.api.Client;
import com.example.alshimaa.smartguide.api.Service;
import com.example.alshimaa.smartguide.model.GetGuideNameResponse;
import com.example.alshimaa.smartguide.model.GetPathResponse;
import com.example.alshimaa.smartguide.view.GetGuideNameView;
import com.example.alshimaa.smartguide.view.GetPathView;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GetPathPresenter {
    Context context;
    GetPathView getPathView;

    public GetPathPresenter(Context context, GetPathView getPathView) {
        this.context = context;
        this.getPathView = getPathView;
    }

    public void getPathResult(String Lang)
    {
        HashMap<String,String> hashMap=new HashMap<>(  );
        hashMap.put("lang",Lang);
        // hashMap.put("id",ID);

        Service service= Client.getClient().create( Service.class );
        Call<GetPathResponse> call=service.getPathData( hashMap );

        call.enqueue( new Callback<GetPathResponse>() {
            @Override
            public void onResponse(Call<GetPathResponse> call, Response<GetPathResponse> response) {
                if(response.isSuccessful())
                {

                    getPathView.showGetPathList( response.body().getData() );

                }
            }

            @Override
            public void onFailure(Call<GetPathResponse> call, Throwable t) {
                getPathView.showGetPathError(  );
            }
        } );
    }
}
