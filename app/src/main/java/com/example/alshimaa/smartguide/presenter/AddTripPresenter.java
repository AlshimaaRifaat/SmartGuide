package com.example.alshimaa.smartguide.presenter;

import android.content.Context;
import android.widget.Toast;

import com.example.alshimaa.smartguide.api.Client;
import com.example.alshimaa.smartguide.api.Service;
import com.example.alshimaa.smartguide.model.AddTripResponse;
import com.example.alshimaa.smartguide.model.GetGuideNameResponse;
import com.example.alshimaa.smartguide.view.AddTripView;
import com.example.alshimaa.smartguide.view.GetGuideNameView;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddTripPresenter {
    Context context;
    AddTripView addTripView;

    public AddTripPresenter(Context context, AddTripView addTripView) {
        this.context = context;
        this.addTripView = addTripView;
    }

    public void getAddTripResult(String name_en,String name_ar,String guide_id
    ,String driver_id,String bus_id,String date_time_start,String date_time_end
    ,String path_id,String company_id,String user_token
    ,String price,String status)
    {
        HashMap<String,String> hashMap=new HashMap<>(  );
        hashMap.put("name_en",name_en);
        hashMap.put("name_ar",name_ar);
        hashMap.put("guide_id",guide_id);
        hashMap.put("driver_id",driver_id);
        hashMap.put("bus_id",bus_id);
        hashMap.put("date_time_start",date_time_start);
        hashMap.put("date_time_end",date_time_end);
        hashMap.put("path_id",path_id);
        hashMap.put("company_id",company_id);
        hashMap.put("user_token",user_token);
        hashMap.put("price",price);
        hashMap.put("status",status);
        // hashMap.put("id",ID);

        Service service= Client.getClient().create( Service.class );
        Call<AddTripResponse> call=service.getAddTripData( hashMap );

        call.enqueue( new Callback<AddTripResponse>() {
            @Override
            public void onResponse(Call<AddTripResponse> call, Response<AddTripResponse> response) {
                if(response.code()==200)
                {
                    addTripView.showAddTripResult( response.body().getData() );
                }
                else if (response.code()==400)
                {
                    Toast.makeText(context, "this driver in trip now select date different", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<AddTripResponse> call, Throwable t) {
                addTripView.showAddTripError();
            }
        } );
    }
}
