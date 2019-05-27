package com.example.alshimaa.smartguide.activity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.alshimaa.smartguide.R;
import com.example.alshimaa.smartguide.fragment.FollowFlightsFragment;
import com.example.alshimaa.smartguide.fragment.LoginFragment;
import com.example.alshimaa.smartguide.fragment.OldRequestsPauseTripSupervisorFragment;

public class NavigationActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    Fragment fragment;
    private int currentSelectedPosition=0;
    NavigationView navigationView;
    public static ActionBarDrawerToggle toggle;
    public static DrawerLayout drawer;

    public static Toolbar toolbar;
   // @BindView(R.id.nav_header_profile_img)
    ImageView imgProfile;

   // @BindView(R.id.nav_header_text_name)
    TextView nameTxt;

   // @BindView(R.id.nav_header_text_phone)
    TextView phoneTxt ;
 View header;

    SharedPreferences sharedPreferences_name,
            sharedPreferences_phone,sharedPreferences_img,sharedPreferences_role;

      String Img,Name,Phone,Role;

    SharedPreferences.Editor shared;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);
        shared=getSharedPreferences("default",Context.MODE_PRIVATE ).edit();


        // ButterKnife.bind(this);
       /* Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

        NavigationView navigationView = (NavigationView) findViewById( R.id.nav_view );
        header=navigationView.getHeaderView(0);
        navigationView.setNavigationItemSelectedListener(this);

        imgProfile=header.findViewById(R.id.nav_header_profile_img);
        nameTxt=header.findViewById(R.id.nav_header_text_name);
        phoneTxt=header.findViewById(R.id.nav_header_text_phone);

        onNavigationItemSelected(navigationView.getMenu().getItem(0));
        drawer = (DrawerLayout) findViewById( R.id.drawer_layout );
        toggle = new ActionBarDrawerToggle(
                this, drawer, R.string.navigation_drawer_open, R.string.navigation_drawer_close );
        drawer.addDrawerListener( toggle );
        toggle.syncState();


        navigationView.setNavigationItemSelectedListener( this );

      /*toolbar.setNavigationOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               if (drawer.isDrawerOpen(GravityCompat.START)) {
                    drawer.closeDrawer(GravityCompat.START);
               } else {
                drawer.openDrawer(GravityCompat.START);
               }
           }
      });*/
      /*sharedPreferences_role=getSharedPreferences("role_to_home", Context.MODE_PRIVATE);
      Role=sharedPreferences_role.getString("role",null);*/

        sharedPreferences_name=getSharedPreferences("nav_name", Context.MODE_PRIVATE);
        Name=sharedPreferences_name.getString("name",null);

        sharedPreferences_phone=getSharedPreferences("nav_phone", Context.MODE_PRIVATE);
        Phone=sharedPreferences_phone.getString("phone",null);

        sharedPreferences_img=getSharedPreferences("nav_img", Context.MODE_PRIVATE);
        Img=sharedPreferences_img.getString("img",null);

       // Toast.makeText(this, Img+" "+Name+" "+Phone, Toast.LENGTH_SHORT).show();
      Glide.with(getApplicationContext()).load("http://omelqoura.com/"+Img).into(imgProfile);
        nameTxt.setText(Name);
        phoneTxt.setText(Phone);




    }



    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById( R.id.drawer_layout );
        if (drawer.isDrawerOpen( GravityCompat.START )) {
            drawer.closeDrawer( GravityCompat.START );
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate( R.menu.navigation, menu );
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected( item );
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        switch (item.getItemId())
        {
            case R.id.nav_follow_flights:
                currentSelectedPosition=0;
                fragment=new FollowFlightsFragment();
                break;
          case R.id.nav_old_requests_supervisor:
                currentSelectedPosition=1;
                fragment=new OldRequestsPauseTripSupervisorFragment();
                break;
           case R.id.nav_LogOut:
               currentSelectedPosition=2;
               shared.putString( "login_to_follow_flight",null );
               shared.apply();
               fragment=new LoginFragment();
                break;

          /*  case R.id.nav_OldTrip:
                currentSelectedPosition=1;
                fragment=new OldTripFragment();
                break;
            case R.id.nav_ViewMyGuides:
                currentSelectedPosition=2;
                fragment=new ViewMyGuidesFragment();
                break;*/


            default:
                currentSelectedPosition=0;
                break;
        }
        if(item.isChecked())
        {
            item.setCheckable( false );
        }else
        {
            item.setChecked( true );
        }

        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.add( R.id.content_navigation,fragment )
                .commit();


        DrawerLayout drawer = (DrawerLayout) findViewById( R.id.drawer_layout );
        drawer.closeDrawer( GravityCompat.START );
        return true;
    }
/*
    private void Log_Out() {

        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.add( R.id.content_navigation,new LoginFragment())
                .addToBackStack( null ).commit();
    }*/
}