package com.example.alshimaa.smartguide.presenter;

import android.content.Context;
import android.widget.Toast;

import com.example.alshimaa.smartguide.api.Client;
import com.example.alshimaa.smartguide.api.Service;
import com.example.alshimaa.smartguide.model.LoginResponse;
import com.example.alshimaa.smartguide.view.LoginView;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginPresenter {
    Context context;
    LoginView loginView;

    public LoginPresenter(Context context, LoginView loginView) {
        this.context = context;
        this.loginView = loginView;
    }

    public void getLoginResult(String Email,String Password,String Lang)
    {
        HashMap<String,String> hashMap=new HashMap<>(  );
        hashMap.put( "email",Email );
        hashMap.put( "password",Password );
        hashMap.put("lang",Lang);

        Service service= Client.getClient().create( Service.class );
        Call<LoginResponse> call=service.getLoginData( hashMap );

        call.enqueue( new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                if(response.isSuccessful())
                {

                    loginView.showLoginResult( response.body().getData());

                }else if(response.code()==400)
                {
                    //loginView.showError();
                    Toast.makeText(context, "البريد الالكترونى او كلمه المرور غير صحيح!", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                loginView.showError(  );
            }
        } );
    }
}