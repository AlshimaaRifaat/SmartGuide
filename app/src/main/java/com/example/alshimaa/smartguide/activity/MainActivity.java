package com.example.alshimaa.smartguide.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.alshimaa.smartguide.R;
import com.example.alshimaa.smartguide.fragment.LoginFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportFragmentManager().beginTransaction().replace(R.id.main_frame_container
        ,new LoginFragment()).commit();
    }
}
