package com.example.alshimaa.smartguide.presenter;

import android.content.Context;
import android.widget.Toast;

import com.example.alshimaa.smartguide.api.Client;
import com.example.alshimaa.smartguide.api.Service;
import com.example.alshimaa.smartguide.model.LoginResponse;
import com.example.alshimaa.smartguide.model.NotificationsResponse;
import com.example.alshimaa.smartguide.view.LoginView;
import com.example.alshimaa.smartguide.view.NotificationsView;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NotificationsPresenter {
    Context context;
    NotificationsView notificationsView;

    public NotificationsPresenter(Context context, NotificationsView notificationsView) {
        this.context = context;
        this.notificationsView = notificationsView;
    }

    public void getNotificationsResult(String User_token, String Type)
    {
        HashMap<String,String> hashMap=new HashMap<>(  );
        hashMap.put( "user_token",User_token );
        hashMap.put( "type",Type );

        Service service= Client.getClient().create( Service.class );
        Call<NotificationsResponse> call=service.getNotificationsData( hashMap );

        call.enqueue( new Callback<NotificationsResponse>() {
            @Override
            public void onResponse(Call<NotificationsResponse> call, Response<NotificationsResponse> response) {
                if(response.isSuccessful())
                {

                    notificationsView.showNotificationList( response.body().getData());

                }else if(response.code()==400||response.code()==404)
                {
                    //loginView.showError();
                    Toast.makeText(context, "عفوا,لا تتواجد اشعارات!", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<NotificationsResponse> call, Throwable t) {
                notificationsView.showNotificationError(  );
            }
        } );
    }
}
