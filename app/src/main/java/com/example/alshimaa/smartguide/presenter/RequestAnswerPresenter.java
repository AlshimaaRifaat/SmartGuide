package com.example.alshimaa.smartguide.presenter;

import android.content.Context;
import android.widget.Toast;

import com.example.alshimaa.smartguide.api.Client;
import com.example.alshimaa.smartguide.api.Service;
import com.example.alshimaa.smartguide.model.LoginResponse;
import com.example.alshimaa.smartguide.model.RequestAnswerResponse;
import com.example.alshimaa.smartguide.view.LoginView;
import com.example.alshimaa.smartguide.view.RequestAnswerView;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RequestAnswerPresenter {
    Context context;
    RequestAnswerView requestAnswerView;

    public RequestAnswerPresenter(Context context, RequestAnswerView requestAnswerView) {
        this.context = context;
        this.requestAnswerView = requestAnswerView;
    }

    public void getRequestAnswerResult(String user_token, String requestId, String type,
                                       String headings,String message)
    {
        HashMap<String,String> hashMap=new HashMap<>(  );
        hashMap.put( "user_token",user_token );
        hashMap.put( "requestId",requestId );
        hashMap.put("type",type);
        hashMap.put("headings",headings);
        hashMap.put("message",message);

        Service service= Client.getClient().create( Service.class );
        Call<RequestAnswerResponse> call=service.getRequestAnswerData( hashMap );

        call.enqueue( new Callback<RequestAnswerResponse>() {
            @Override
            public void onResponse(Call<RequestAnswerResponse> call, Response<RequestAnswerResponse> response) {
                if(response.isSuccessful())
                {
                    requestAnswerView.showRequestAnswerMsg( response.body().getData());
                }
            }

            @Override
            public void onFailure(Call<RequestAnswerResponse> call, Throwable t) {
                requestAnswerView.showRequestAnswerError(  );
            }
        } );
    }
}
