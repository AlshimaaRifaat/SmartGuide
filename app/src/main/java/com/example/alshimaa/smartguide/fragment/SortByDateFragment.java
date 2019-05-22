package com.example.alshimaa.smartguide.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.example.alshimaa.smartguide.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class SortByDateFragment extends Fragment {
    @BindView(R.id.sort_by_date_relative_oldest) RelativeLayout oldestRelative;
    @BindView(R.id.sort_by_date_relative_recent) RelativeLayout recentRelative;
    Unbinder unbinder;

    Bundle bundle;
    public SortByDateFragment() {
        // Required empty public constructor
    }

View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_sort_by_date, container, false);
        unbinder= ButterKnife.bind(this,view);
        bundle=new Bundle();
        oldestRelative.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getFragmentManager(); // or 'getSupportFragmentManager();'
                int count = fm.getBackStackEntryCount();
                if(count!=0) {
                    for (int i = 0; i < count; ++i) {
                        fm.popBackStack();
                    }
                }
                FollowFlightsFragment followFlightsFragment=new FollowFlightsFragment();

                bundle.putString("old","old");
                followFlightsFragment.setArguments(bundle);
                getFragmentManager().beginTransaction().replace(R.id.content_navigation,
                        followFlightsFragment).commit();


            }
        });

        recentRelative.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getFragmentManager(); // or 'getSupportFragmentManager();'
                int count = fm.getBackStackEntryCount();
                if(count!=0) {
                    for (int i = 0; i < count; ++i) {
                        fm.popBackStack();
                    }
                }
                FollowFlightsFragment followFlightsFragment=new FollowFlightsFragment();

                bundle.putString("new","new");
                followFlightsFragment.setArguments(bundle);
                getFragmentManager().beginTransaction().replace(R.id.content_navigation,
                        followFlightsFragment).commit();


            }
        });
        return view;
    }

}
