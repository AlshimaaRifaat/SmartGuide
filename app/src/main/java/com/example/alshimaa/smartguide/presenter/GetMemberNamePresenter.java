package com.example.alshimaa.smartguide.presenter;

import android.content.Context;

import com.example.alshimaa.smartguide.api.Client;
import com.example.alshimaa.smartguide.api.Service;
import com.example.alshimaa.smartguide.model.GetGuideNameResponse;
import com.example.alshimaa.smartguide.model.GetMemeberNameResponse;
import com.example.alshimaa.smartguide.view.GetGuideNameView;
import com.example.alshimaa.smartguide.view.GetMemberNameView;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GetMemberNamePresenter {
    Context context;
    GetMemberNameView getMemberNameView;

    public GetMemberNamePresenter(Context context, GetMemberNameView getMemberNameView) {
        this.context = context;
        this.getMemberNameView = getMemberNameView;
    }

    public void getMemberNameResult(String Lang)
    {
        HashMap<String,String> hashMap=new HashMap<>(  );
        hashMap.put("lang",Lang);
        // hashMap.put("id",ID);

        Service service= Client.getClient().create( Service.class );
        Call<GetMemeberNameResponse> call=service.getMemeberNameData( hashMap );

        call.enqueue( new Callback<GetMemeberNameResponse>() {
            @Override
            public void onResponse(Call<GetMemeberNameResponse> call, Response<GetMemeberNameResponse> response) {
                if(response.isSuccessful())
                {

                    getMemberNameView.showMemeberNameList( response.body().getData() );

                }
            }

            @Override
            public void onFailure(Call<GetMemeberNameResponse> call, Throwable t) {
                getMemberNameView.showMemeberNameError();
            }
        } );
    }
}
