package com.example.alshimaa.smartguide.fragment;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.alshimaa.smartguide.R;
import com.example.alshimaa.smartguide.activity.NavigationActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment {
    Button registerBtn;

    public LoginFragment() {
        // Required empty public constructor
    }

View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_login, container, false);
        init();
        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performRegister();
            }
        });
        return view;
    }

    private void performRegister() {
        Intent i = new Intent(getActivity(), NavigationActivity.class);
        startActivity(i);
        ((Activity) getActivity()).overridePendingTransition(0,0);
    }

    private void init() {
        registerBtn=view.findViewById(R.id.login_btn_register);
    }

}
