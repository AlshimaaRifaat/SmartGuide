package com.example.alshimaa.smartguide.presenter;

import android.content.Context;

import com.example.alshimaa.smartguide.api.Client;
import com.example.alshimaa.smartguide.api.Service;
import com.example.alshimaa.smartguide.model.GetGuideNameResponse;
import com.example.alshimaa.smartguide.model.LoginResponse;
import com.example.alshimaa.smartguide.view.GetGuideNameView;
import com.example.alshimaa.smartguide.view.LoginView;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GetGuideNamePresenter {
    Context context;
    GetGuideNameView getGuideNameView;

    public GetGuideNamePresenter(Context context, GetGuideNameView getGuideNameView) {
        this.context = context;
        this.getGuideNameView = getGuideNameView;
    }

    public void getGuideNameResult( String Lang)
    {
        HashMap<String,String> hashMap=new HashMap<>(  );
        hashMap.put("lang",Lang);
       // hashMap.put("id",ID);

        Service service= Client.getClient().create( Service.class );
        Call<GetGuideNameResponse> call=service.getGuideNameData( hashMap );

        call.enqueue( new Callback<GetGuideNameResponse>() {
            @Override
            public void onResponse(Call<GetGuideNameResponse> call, Response<GetGuideNameResponse> response) {
                if(response.isSuccessful())
                {

                    getGuideNameView.showGuideNameList( response.body().getData() );

                }
            }

            @Override
            public void onFailure(Call<GetGuideNameResponse> call, Throwable t) {
                getGuideNameView.showError(  );
            }
        } );
    }
}
