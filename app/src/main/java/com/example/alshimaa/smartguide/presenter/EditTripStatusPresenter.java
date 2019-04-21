package com.example.alshimaa.smartguide.presenter;

import android.content.Context;

import com.example.alshimaa.smartguide.api.Client;
import com.example.alshimaa.smartguide.api.Service;
import com.example.alshimaa.smartguide.model.EditTripStatusResponse;
import com.example.alshimaa.smartguide.model.GetBusNumberResponse;
import com.example.alshimaa.smartguide.view.EditTripStatusView;
import com.example.alshimaa.smartguide.view.GetBusNumberView;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EditTripStatusPresenter {
    Context context;
    EditTripStatusView editTripStatusView;

    public EditTripStatusPresenter(Context context, EditTripStatusView editTripStatusView) {
        this.context = context;
        this.editTripStatusView = editTripStatusView;
    }

    public void getEditTripStatusResult(String Trip_id, String User_token,String Status )
    {
        HashMap<String,String> hashMap=new HashMap<>(  );
        hashMap.put("trip_id",Trip_id);
        hashMap.put("user_token",User_token);
        hashMap.put("status",Status);
        Service service= Client.getClient().create( Service.class );
        Call<EditTripStatusResponse> call=service.getEditTripStatusData( hashMap );

        call.enqueue( new Callback<EditTripStatusResponse>() {
            @Override
            public void onResponse(Call<EditTripStatusResponse> call, Response<EditTripStatusResponse> response) {
                if(response.isSuccessful())
                {

                    editTripStatusView.showEditTripStatusMsg( response.body().getData() );

                }
            }

            @Override
            public void onFailure(Call<EditTripStatusResponse> call, Throwable t) {
                editTripStatusView.showEditTripStatusError(  );
            }
        } );
    }
}
