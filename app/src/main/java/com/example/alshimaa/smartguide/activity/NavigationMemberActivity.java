package com.example.alshimaa.smartguide.activity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.alshimaa.smartguide.R;
import com.example.alshimaa.smartguide.fragment.HomeDriverFragment;
import com.example.alshimaa.smartguide.fragment.HomeMemberFragment;
import com.example.alshimaa.smartguide.fragment.LoginFragment;

public class NavigationMemberActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    Fragment fragment;
    private int currentSelectedPosition=0;
    NavigationView navigationView_member;
    public static ActionBarDrawerToggle toggle_member;
    public static DrawerLayout drawer_member;

    public static Toolbar toolbar;

    SharedPreferences.Editor shared_role;
    View header;

    SharedPreferences sharedPreferences_name,
            sharedPreferences_phone,sharedPreferences_img;

    String Img,Name,Phone;

    ImageView imgProfile;

    // @BindView(R.id.nav_header_text_name)
    TextView nameTxt,phoneTxt;

    // @BindView(R.id.nav_header_text_phone)
    SharedPreferences.Editor shared_member;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_member);

        shared_member=getSharedPreferences("member",Context.MODE_PRIVATE ).edit();
       /* Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
*/
        drawer_member = (DrawerLayout) findViewById(R.id.drawer_layout);
        toggle_member = new ActionBarDrawerToggle(
                this, drawer_member, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer_member.addDrawerListener(toggle_member);
        toggle_member.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        header=navigationView.getHeaderView(0);
        navigationView.setNavigationItemSelectedListener(this);

        imgProfile=header.findViewById(R.id.nav_header_member_profile_img);
        nameTxt=header.findViewById(R.id.nav_header_member_text_name);
        phoneTxt=header.findViewById(R.id.nav_header_member_text_phone);

        onNavigationItemSelected(navigationView.getMenu().getItem(0));
        drawer_member = (DrawerLayout) findViewById( R.id.drawer_layout );
        toggle_member = new ActionBarDrawerToggle(
                this, drawer_member, R.string.navigation_drawer_open, R.string.navigation_drawer_close );
        drawer_member.addDrawerListener( toggle_member );
        toggle_member.syncState();

        navigationView.setNavigationItemSelectedListener( this );

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
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.navigation_member, menu);
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

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        switch (item.getItemId())
        {
            case R.id.nav_home_member:
                currentSelectedPosition=0;
              fragment=new HomeMemberFragment();
                break;

            case R.id.nav_member_logOut:
                currentSelectedPosition=1;
                shared_member.putString( "member_user_token",null );
                shared_member.apply();
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
        fragmentTransaction.add( R.id.content_navigation_member,fragment )
                .addToBackStack( null ).commit();


        drawer_member = (DrawerLayout) findViewById( R.id.drawer_layout );
        drawer_member.closeDrawer( GravityCompat.START );
        return true;
    }
}
