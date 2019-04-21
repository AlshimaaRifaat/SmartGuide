package com.example.alshimaa.smartguide.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.alshimaa.smartguide.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class SortByFragment extends Fragment {
    @BindView(R.id.sort_by_relative_status) RelativeLayout sortByStatusRelative;
    @BindView(R.id.sort_by_relative_date) RelativeLayout sortByDateRelative;

     Unbinder unbinder;

    public SortByFragment() {
        // Required empty public constructor
    }

View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_sort_by, container, false);
        unbinder= ButterKnife.bind(this,view);
        sortByStatusRelative.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().replace(R.id.content_navigation,new SortByStatusFragment())
                        .addToBackStack(null).commit();
            }
        });
        sortByDateRelative.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().replace(R.id.content_navigation,new SortByDateFragment())
                        .addToBackStack(null).commit();
            }
        });
        return view;
    }

}
