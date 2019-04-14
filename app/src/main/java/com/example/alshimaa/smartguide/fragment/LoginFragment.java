package com.example.alshimaa.smartguide.fragment;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.alshimaa.smartguide.NetworkConnection;
import com.example.alshimaa.smartguide.R;
import com.example.alshimaa.smartguide.SplashActivity;
import com.example.alshimaa.smartguide.activity.NavigationActivity;
import com.example.alshimaa.smartguide.presenter.LoginPresenter;
import com.example.alshimaa.smartguide.view.LoginView;
import com.fourhcode.forhutils.FUtilsValidation;

/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment implements LoginView {
    Button loginBtn;
    EditText userEmail,userPassword;
    LoginPresenter loginPresenter;

    SharedPreferences.Editor sharedPref;

    SharedPreferences.Editor sharedPref_company_id;
     public  static String CompanyId;
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
        sharedPref=getContext().getSharedPreferences("default", Context.MODE_PRIVATE).edit();
        sharedPref_company_id=getContext().getSharedPreferences("def", Context.MODE_PRIVATE).edit();
        Login();

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performLogin();
            }
        });
        return view;
    }

    private void Login() {
        loginPresenter=new LoginPresenter( getContext(),this );
    }

    private void performLogin() {
        /*Intent i = new Intent(getActivity(), NavigationActivity.class);
        startActivity(i);
        ((Activity) getActivity()).overridePendingTransition(0,0);*/
        FUtilsValidation.isEmpty( userEmail,"من فضلك ادخل بريدك الالكترونى" );
        FUtilsValidation.isEmpty( userPassword,"من فضك,ادخل كلمه المرور" );
        validateEmail();
        NetworkConnection networkConnection=new NetworkConnection( getContext() );
        if (networkConnection.isNetworkAvailable( getContext() ))
        {

            if(!userEmail.getText().toString().equals( "" )&&
                    !userPassword.getText().toString().equals("")&&
                    validateEmail())
            {
                loginPresenter.getLoginResult( userEmail.getText().toString(),
                        userPassword.getText().toString(),"ar" );
            }

            else
            {
                Toast.makeText( getContext(),"من فضلك, املأ البيانات ", Toast.LENGTH_SHORT ).show();
            }

        }else {
            Toast.makeText( getContext(), "تأكد من اتصالك بالانترنت", Toast.LENGTH_SHORT ).show();
        }
    }
    private Boolean validateEmail(){
        String EMAIL=userEmail.getText().toString().trim();
        if (EMAIL.isEmpty()||!isValidEmail(EMAIL)){
            userEmail.setError("البريد الالكتروني خاطئ!");

            return false;
        }else if(!userEmail.getText().toString().matches("[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+")){
            userEmail.setError(("البريد الالكتروني خاطئ!"));
            return false;
        }
        return true;
    }

    public static boolean isValidEmail(String Email)
    {
        return !TextUtils.isEmpty( Email )&&  android.util.Patterns.EMAIL_ADDRESS.matcher(Email).matches();
    }

    private void init() {
        loginBtn=view.findViewById(R.id.login_btn_register);
        userEmail=view.findViewById(R.id.login_Etext_email);
        userPassword=view.findViewById(R.id.login_Etext_password);
    }



    @Override
    public void showLoginResult(String UserToken, String CompanyId) {
        sharedPref.putString("login_to_follow_flight",UserToken);
        sharedPref.apply();
        Toast.makeText(getContext(), CompanyId, Toast.LENGTH_SHORT).show();
       sharedPref_company_id.putString("company_id",CompanyId);
        sharedPref_company_id.apply();


        SplashActivity.Login=UserToken;
        // Toast.makeText(getContext(), UserToken, Toast.LENGTH_SHORT).show();
        Intent i = new Intent(getActivity(), NavigationActivity.class);
        startActivity(i);
        ((Activity) getActivity()).overridePendingTransition(0,0);
        getActivity().finish();
    }

    @Override
    public void showError() {

    }
}
