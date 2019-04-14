package com.example.alshimaa.smartguide;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;


import com.example.alshimaa.smartguide.activity.MainActivity;
import com.example.alshimaa.smartguide.activity.NavigationActivity;

public class SplashActivity extends AppCompatActivity {
SharedPreferences sharedPreferences;
public static String Login;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);

        sharedPreferences=getSharedPreferences("default", Context.MODE_PRIVATE);
        Login=sharedPreferences.getString("login_to_follow_flight",null);


        Thread timer=new Thread(  )
        {
            @Override
            public void run() {
                super.run();
                try {
                    sleep( 4000 );

                }catch (InterruptedException e)
                {
                    e.printStackTrace();
                }finally {
                    if (Login!=null )
                    {
                        Intent intent=new Intent( SplashActivity.this,NavigationActivity.class);
                        startActivity( intent );
                    }else if (Login==null)
                    {
                        Intent intent=new Intent( SplashActivity.this,MainActivity.class);
                        startActivity( intent );
                    }

                    finish();
                }
            }
        };

        timer.start();

    }

}