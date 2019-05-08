package com.example.alshimaa.smartguide.adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.alshimaa.smartguide.R;
import com.example.alshimaa.smartguide.model.HomeMemberData;
import com.example.alshimaa.smartguide.model.OldRequestsGuideData;

import java.util.List;

public class HomeMemberAdapter extends RecyclerView.Adapter<HomeMemberAdapter.ViewHolder> {
    Context context;
    List<HomeMemberData> homeMemberDataList;



    //DetailsFollowFlightsView detailsFollowFlightsView;


    public HomeMemberAdapter(Context context, List<HomeMemberData> homeMemberDataList) {
        this.context = context;
        this.homeMemberDataList = homeMemberDataList;
    }

    /*public  void onClick(DetailsFollowFlightsView detailsFollowFlightsView)
        {
            this.detailsFollowFlightsView=detailsFollowFlightsView;
        }*/
    @Override
    public HomeMemberAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from( context ).inflate(R.layout.row_home_member,parent,false);
        return new HomeMemberAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeMemberAdapter.ViewHolder holder, final int position) {

        holder.supervisorName.setText(homeMemberDataList.get( position ).getName());

        Typeface customFontBold= Typeface.createFromAsset( context.getAssets(), "DroidKufi-Bold.ttf" );
        holder.supervisorName.setTypeface( customFontBold );






/*
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                detailsFollowFlightsView.showDetailsFollowFlights(followFlightsDataList.get(position));
            }
        });*/

    }

    @Override
    public int getItemCount() {
        return homeMemberDataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView supervisorName;

        // RelativeLayout relativeItem;

        public ViewHolder(View itemView) {
            super( itemView );

            supervisorName=itemView.findViewById(R.id.row_home_member_supervisor_name);

        }
    }
}


