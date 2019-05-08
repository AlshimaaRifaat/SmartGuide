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
import com.example.alshimaa.smartguide.activity.NavigationDriverActivity;
import com.example.alshimaa.smartguide.activity.NavigationGuideActivity;
import com.example.alshimaa.smartguide.activity.NavigationMemberActivity;
import com.example.alshimaa.smartguide.model.LoginData;
import com.example.alshimaa.smartguide.presenter.LoginPresenter;
import com.example.alshimaa.smartguide.view.DetailsNavHeaderProfileView;
import com.example.alshimaa.smartguide.view.LoginView;
import com.fourhcode.forhutils.FUtilsValidation;

/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment implements LoginView{
    Button loginBtn;
    EditText userEmail,userPassword;
    LoginPresenter loginPresenter;

    SharedPreferences.Editor sharedPref,sharedPref_guide,sharedPref_driver,sharedPref_member;

    SharedPreferences.Editor sharedPref_company_id,sharedPref_role;
     public  static String CompanyId;

    SharedPreferences.Editor sharedPref_Name;
    SharedPreferences.Editor sharedPref_Phone;
    SharedPreferences.Editor sharedPref_Img;
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

        sharedPref_Name=getContext().getSharedPreferences("nav_name", Context.MODE_PRIVATE).edit();
        sharedPref_Phone=getContext().getSharedPreferences("nav_phone", Context.MODE_PRIVATE).edit();
        sharedPref_Img=getContext().getSharedPreferences("nav_img", Context.MODE_PRIVATE).edit();

        sharedPref_role=getContext().getSharedPreferences("role_to_home", Context.MODE_PRIVATE).edit();

        sharedPref_guide=getContext().getSharedPreferences("guide", Context.MODE_PRIVATE).edit();
        sharedPref_driver=getContext().getSharedPreferences("driver", Context.MODE_PRIVATE).edit();
        sharedPref_member=getContext().getSharedPreferences("member", Context.MODE_PRIVATE).edit();
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
        FUtilsValidation.isEmpty( userEmail,"من فضلك ,ادخل بريدك الالكترونى" );
        FUtilsValidation.isEmpty( userPassword,"من فضك,ادخل كلمه المرور" );

        NetworkConnection networkConnection=new NetworkConnection( getContext() );
        if (networkConnection.isNetworkAvailable( getContext() ))
        {
            if(userPassword.getText().toString().length()<6)
            {
                Toast.makeText(getContext(), "من فضلك ادخل كلمه المرور فيما لا يقل عن سته ارقام !", Toast.LENGTH_SHORT).show();
            }
               if (!userEmail.getText().toString().equals("") &&
                       !userPassword.getText().toString().equals("") &&
                       validateEmail()) {
                   loginPresenter.getLoginResult(userEmail.getText().toString(),
                           userPassword.getText().toString(), "ar");
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
    public void showLoginResult(LoginData loginData) {

        sharedPref_role.putString("role",loginData.getRole());
        sharedPref_role.apply();
       // Toast.makeText(getContext(), loginData.getUserToken(), Toast.LENGTH_SHORT).show();
        if(loginData.getRole().equals("guides"))
        {
            sharedPref_guide.putString("guide_user_token", loginData.getUserToken());
            sharedPref_guide.apply();
            SplashActivity.Guide_user_token = loginData.getUserToken();

            sharedPref_Name.putString("name", loginData.getName());
            sharedPref_Name.apply();
            sharedPref_Phone.putString("phone", loginData.getPhone());
            sharedPref_Phone.apply();
            sharedPref_Img.putString("img", loginData.getImage());
            sharedPref_Img.apply();

            Intent i = new Intent(getActivity(), NavigationGuideActivity.class);
            startActivity(i);
            ((Activity) getActivity()).overridePendingTransition(0,0);
            getActivity().finish();
        }else if(loginData.getRole().equals("supervisors")) {

            sharedPref.putString("login_to_follow_flight", loginData.getUserToken());
            sharedPref.apply();
            // Toast.makeText(getContext(), CompanyId, Toast.LENGTH_SHORT).show();
            sharedPref_company_id.putString("company_id", loginData.getCompanyId());
            sharedPref_company_id.apply();
            SplashActivity.Login = loginData.getUserToken();

            // Toast.makeText(getContext(), UserToken, Toast.LENGTH_SHORT).show();

            sharedPref_Name.putString("name", loginData.getName());
            sharedPref_Name.apply();
            sharedPref_Phone.putString("phone", loginData.getPhone());
            sharedPref_Phone.apply();
            sharedPref_Img.putString("img", loginData.getImage());
            sharedPref_Img.apply();


            Intent i = new Intent(getActivity(), NavigationActivity.class);
        /*i.putExtra("img",loginData.getImage());

        i.putExtra("name",loginData.getName());
        i.putExtra("phone",loginData.getPhone());*/
            startActivity(i);
            ((Activity) getActivity()).overridePendingTransition(0, 0);
            getActivity().finish();
        }else if(loginData.getRole().equals("drivers"))
        {
                sharedPref_driver.putString("driver_user_token", loginData.getUserToken());
                sharedPref_driver.apply();
                SplashActivity.Driver_user_token = loginData.getUserToken();

                sharedPref_Name.putString("name", loginData.getName());
                sharedPref_Name.apply();
                sharedPref_Phone.putString("phone", loginData.getPhone());
                sharedPref_Phone.apply();
                sharedPref_Img.putString("img", loginData.getImage());
                sharedPref_Img.apply();

                Intent i = new Intent(getActivity(), NavigationDriverActivity.class);
                startActivity(i);
                ((Activity) getActivity()).overridePendingTransition(0,0);
                getActivity().finish();
            }

        else if(loginData.getRole().equals("members"))
        {
            sharedPref_member.putString("member_user_token", loginData.getUserToken());
            sharedPref_member.apply();
            SplashActivity.Member_user_token = loginData.getUserToken();

            sharedPref_Name.putString("name", loginData.getName());
            sharedPref_Name.apply();
            sharedPref_Phone.putString("phone", loginData.getPhone());
            sharedPref_Phone.apply();
            sharedPref_Img.putString("img", loginData.getImage());
            sharedPref_Img.apply();

            Intent i = new Intent(getActivity(), NavigationMemberActivity.class);
            startActivity(i);
            ((Activity) getActivity()).overridePendingTransition(0,0);
            getActivity().finish();
        }


    }

    @Override
    public void showError() {

    }

   /* @Override
    public void showDetailsNavHeaderProfile(LoginData loginData) {
       *//* DetailsFollowFlightsFragment detailsFollowFlightsFragment=new DetailsFollowFlightsFragment();
        Bundle bundle=new Bundle();
        bundle.putParcelable("follow_flight_item",loginData);
        detailsFollowFlightsFragment.setArguments(bundle);
        getFragmentManager().beginTransaction().replace(R.id.content_navigation,
                detailsFollowFlightsFragment).addToBackStack(null).commit();*//*

     *//*   Intent i = new Intent(getActivity(), NavigationActivity.class);
        startActivity(i);
        ((Activity) getActivity()).overridePendingTransition(0,0);*//*

        Intent i = new Intent(getActivity(), NavigationActivity.class);


        i.putExtra("img",loginData.getImage());

        i.putExtra("name",loginData.getName());
        i.putExtra("phone",loginData.getPhone());

        //Toast.makeText(getContext(), Under, Toast.LENGTH_SHORT).show();
        startActivity(i);
        ((Activity) getActivity()).overridePendingTransition(0,0);
    }*/
}
