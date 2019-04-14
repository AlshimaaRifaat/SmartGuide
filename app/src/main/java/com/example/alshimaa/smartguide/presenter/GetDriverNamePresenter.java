package com.example.alshimaa.smartguide.presenter;

import android.content.Context;
import android.widget.Toast;

import com.example.alshimaa.smartguide.api.Client;
import com.example.alshimaa.smartguide.api.Service;
import com.example.alshimaa.smartguide.model.GetDriverNameResponse;
import com.example.alshimaa.smartguide.model.GetGuideNameResponse;
import com.example.alshimaa.smartguide.view.GetDriverNameView;
import com.example.alshimaa.smartguide.view.GetGuideNameView;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GetDriverNamePresenter {
    Context context;
    GetDriverNameView getDriverNameView;

    public GetDriverNamePresenter(Context context, GetDriverNameView getDriverNameView) {
        this.context = context;
        this.getDriverNameView = getDriverNameView;
    }

    public void getDriverNameResult(String Lang)
    {
        HashMap<String,String> hashMap=new HashMap<>(  );
        hashMap.put("lang",Lang);
        // hashMap.put("id",ID);

        Service service= Client.getClient().create( Service.class );
        Call<GetDriverNameResponse> call=service.getDriverNameData( hashMap );

        call.enqueue( new Callback<GetDriverNameResponse>() {
            @Override
            public void onResponse(Call<GetDriverNameResponse> call, Response<GetDriverNameResponse> response) {
//                if(response.isSuccessful())
//                {
//
//                    getDriverNameView.showDriverNameList( response.body().getData() );
//
//                }else
//                {
//                    getDriverNameView.showDriverError();
//                }
                if(response.code()==200){
                    getDriverNameView.showDriverNameList( response.body().getData() );

                }else if(response.code()==400){
                    Toast.makeText(context, response.body().getError(), Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onFailure(Call<GetDriverNameResponse> call, Throwable t) {
                getDriverNameView.showDriverError();
            }
        } );
    }
}
