package com.example.alshimaa.smartguide.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.example.alshimaa.smartguide.R;
import com.example.alshimaa.smartguide.model.FollowFlightsData;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class SortByStatusFragment extends Fragment {
    @BindView(R.id.sort_by_status_relative_mosnda) RelativeLayout mosndaRelative;
    @BindView(R.id.sort_by_status_relative_kayd_tnfez) RelativeLayout kayd_tnfezRelative;
    @BindView(R.id.sort_by_status_relative_moalaq) RelativeLayout moalaqRelative;
    @BindView(R.id.sort_by_status_relative_malghia) RelativeLayout malghiaRelative;

    @BindView(R.id.sort_by_status_relative_mokfl_nhaey) RelativeLayout mokfl_nhaeyRelative;
    @BindView(R.id.sort_by_status_relative_mokfl_gozey) RelativeLayout mokfl_gozeyRelative;
    @BindView(R.id.sort_by_status_relative_mogdwla) RelativeLayout mogdwlaRelative;

    Unbinder unbinder;

    Bundle bundle;
    public SortByStatusFragment() {
        // Required empty public constructor
    }

    View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_sort_by_status, container, false);
        unbinder= ButterKnife.bind(this,view);
        mosndaRelative.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


              /*  FragmentManager fm = getChildFragmentManager(); // or 'getSupportFragmentManager();'
                int count = fm.getBackStackEntryCount();
                if(count!=0) {
                    for (int i = 0; i < count; ++i) {
                        fm.popBackStack();
                    }
                }*/
                FollowFlightsFragment followFlightsFragment=new FollowFlightsFragment();
                bundle=new Bundle();
                bundle.putString("mosnda","1");
                followFlightsFragment.setArguments(bundle);
                getFragmentManager().beginTransaction().replace(R.id.content_navigation,
                        followFlightsFragment).commit();
            }
        });

        kayd_tnfezRelative.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


              /*  FragmentManager fm = getChildFragmentManager(); // or 'getSupportFragmentManager();'
                int count = fm.getBackStackEntryCount();
                if(count!=0) {
                    for (int i = 0; i < count; ++i) {
                        fm.popBackStack();
                    }
                }*/
                FollowFlightsFragment followFlightsFragment=new FollowFlightsFragment();
                bundle=new Bundle();
                bundle.putString("kayd_tnfez","2");
                followFlightsFragment.setArguments(bundle);
                getFragmentManager().beginTransaction().replace(R.id.content_navigation,
                        followFlightsFragment).commit();
            }
        });
        moalaqRelative.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


               /* FragmentManager fm = getChildFragmentManager(); // or 'getSupportFragmentManager();'
                int count = fm.getBackStackEntryCount();
                if(count!=0) {
                    for (int i = 0; i < count; ++i) {
                        fm.popBackStack();
                    }
                }*/
                FollowFlightsFragment followFlightsFragment=new FollowFlightsFragment();
                bundle=new Bundle();
                bundle.putString("moalaq","3");
                followFlightsFragment.setArguments(bundle);
                getFragmentManager().beginTransaction().replace(R.id.content_navigation,
                        followFlightsFragment).commit();
            }
        });
        malghiaRelative.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


               /* FragmentManager fm = getChildFragmentManager(); // or 'getSupportFragmentManager();'
                int count = fm.getBackStackEntryCount();
                if(count!=0) {
                    for (int i = 0; i < count; ++i) {
                        fm.popBackStack();
                    }
                }*/
                FollowFlightsFragment followFlightsFragment=new FollowFlightsFragment();
                bundle=new Bundle();
                bundle.putString("malghia","4");
                followFlightsFragment.setArguments(bundle);
                getFragmentManager().beginTransaction().replace(R.id.content_navigation,
                        followFlightsFragment).commit();
            }
        });
        mokfl_nhaeyRelative.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                /*FragmentManager fm = getChildFragmentManager(); // or 'getSupportFragmentManager();'
                int count = fm.getBackStackEntryCount();
                if(count!=0) {
                    for (int i = 0; i < count; ++i) {
                        fm.popBackStack();
                    }
                }*/
                FollowFlightsFragment followFlightsFragment=new FollowFlightsFragment();
                bundle=new Bundle();
                bundle.putString("mokfl_nhaey","5");
                followFlightsFragment.setArguments(bundle);
                getFragmentManager().beginTransaction().replace(R.id.content_navigation,
                        followFlightsFragment).commit();
            }
        });
        mokfl_gozeyRelative.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


               /* FragmentManager fm = getChildFragmentManager(); // or 'getSupportFragmentManager();'
                int count = fm.getBackStackEntryCount();
                if(count!=0) {
                    for (int i = 0; i < count; ++i) {
                        fm.popBackStack();
                    }
                }*/
                FollowFlightsFragment followFlightsFragment=new FollowFlightsFragment();
                bundle=new Bundle();
                bundle.putString("mokfl_gozey","6");
                followFlightsFragment.setArguments(bundle);
                getFragmentManager().beginTransaction().replace(R.id.content_navigation,
                        followFlightsFragment).commit();
            }
        });
        mogdwlaRelative.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               /* FragmentManager fm = getChildFragmentManager(); // or 'getSupportFragmentManager();'
                int count = fm.getBackStackEntryCount();
                if(count!=0) {
                    for (int i = 0; i < count; ++i) {
                        fm.popBackStack();
                    }
                }*/
                FollowFlightsFragment followFlightsFragment=new FollowFlightsFragment();
                bundle=new Bundle();
                bundle.putString("mogdwla","7");
                followFlightsFragment.setArguments(bundle);
                getFragmentManager().beginTransaction().replace(R.id.content_navigation,
                        followFlightsFragment).commit();
            }
        });
        return view;
    }

}
