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
import com.example.alshimaa.smartguide.activity.NavigationDriverActivity;
import com.example.alshimaa.smartguide.activity.NavigationGuideActivity;
import com.example.alshimaa.smartguide.activity.NavigationMemberActivity;

public class SplashActivity extends AppCompatActivity {
SharedPreferences sharedPreferences,sharedPreferences_guide_user_token,
        sharedPreferences_name,sharedPreferences_phone,sharedPreferences_img,
        sharedPreferences_driver_user_token,sharedPreferences_member_user_token;
public static String Login,Name,Phone,Img,Guide_user_token,Driver_user_token,Member_user_token;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);

        sharedPreferences=getSharedPreferences("default", Context.MODE_PRIVATE);
        Login=sharedPreferences.getString("login_to_follow_flight",null);

        sharedPreferences_guide_user_token=getSharedPreferences("guide", Context.MODE_PRIVATE);
        Guide_user_token=sharedPreferences_guide_user_token.getString("guide_user_token",null);

       sharedPreferences_driver_user_token=getSharedPreferences("driver", Context.MODE_PRIVATE);
        Driver_user_token=sharedPreferences_driver_user_token.getString("driver_user_token",null);

        sharedPreferences_member_user_token=getSharedPreferences("member", Context.MODE_PRIVATE);
       Member_user_token=sharedPreferences_member_user_token.getString("member_user_token",null);

        sharedPreferences_name=getSharedPreferences("nav_name", Context.MODE_PRIVATE);
        Name=sharedPreferences_name.getString("name",null);

        sharedPreferences_phone=getSharedPreferences("nav_phone", Context.MODE_PRIVATE);
        Phone=sharedPreferences_phone.getString("phone",null);

        sharedPreferences_img=getSharedPreferences("nav_img", Context.MODE_PRIVATE);
        Img=sharedPreferences_img.getString("img",null);


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
                    if (Login!=null &&Name!=null&&Phone!=null&Img!=null )
                    {
                        Intent intent=new Intent( SplashActivity.this,NavigationActivity.class);
                        startActivity( intent );
                    }else if (Guide_user_token!=null &&Name!=null&&Phone!=null&Img!=null )
                    {
                            Intent intent=new Intent( SplashActivity.this,NavigationGuideActivity.class);
                            startActivity( intent );

                    }else if (Driver_user_token!=null &&Name!=null&&Phone!=null&Img!=null )
                    {
                        Intent intent=new Intent( SplashActivity.this,NavigationDriverActivity.class);
                        startActivity( intent );

                    }else if (Member_user_token!=null &&Name!=null&&Phone!=null&Img!=null )
                    {
                        Intent intent=new Intent( SplashActivity.this,NavigationMemberActivity.class);
                        startActivity( intent );

                    }
                    else if (Login==null &&Guide_user_token==null&&Driver_user_token==null&&Member_user_token==null)
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