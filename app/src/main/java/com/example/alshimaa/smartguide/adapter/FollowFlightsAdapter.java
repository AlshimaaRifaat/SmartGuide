package com.example.alshimaa.smartguide.adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.alshimaa.smartguide.R;
import com.example.alshimaa.smartguide.model.FollowFlightsData;
import com.example.alshimaa.smartguide.view.DetailsFollowFlightsView;

import java.util.List;

public class FollowFlightsAdapter extends RecyclerView.Adapter<FollowFlightsAdapter.ViewHolder> {
    Context context;
    List<FollowFlightsData> followFlightsDataList;
    List<FollowFlightsData> ListAfterRemoveItems;


   DetailsFollowFlightsView detailsFollowFlightsView;


    public FollowFlightsAdapter(Context context, List<FollowFlightsData> followFlightsDataList) {
        this.context = context;
        this.followFlightsDataList = followFlightsDataList;
    }

    public  void onClick(DetailsFollowFlightsView detailsFollowFlightsView)
    {
        this.detailsFollowFlightsView=detailsFollowFlightsView;
    }
    @Override
    public FollowFlightsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from( context ).inflate(R.layout.row_follow_flights,parent,false);
        return new FollowFlightsAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FollowFlightsAdapter.ViewHolder holder, final int position) {
       /* Glide.with( context ).load( "http://omelqoura.com"
                +followFlightsDataList.get( position ).getImg() ).into(holder.imageView);*/
        holder.busNumber.setText(followFlightsDataList.get( position ).getBusName());
        holder.status.setText(followFlightsDataList.get( position ).getStatus());
        // Typeface customFontBold = Typeface.createFromAsset( context.getAssets(), "DroidKufi-Bold.ttf" );
       /* holder.address.setText(currentExhibtionDataList.get( position ).getAddress());*/

        Typeface customFontBold= Typeface.createFromAsset( context.getAssets(), "DroidKufi-Bold.ttf" );
        holder.busNumber.setTypeface( customFontBold );
        holder.status.setTypeface( customFontBold );

       /* holder.address.setTypeface( customFontRegular );*/




        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             /*   FollowFlightsData followFlightsData=new FollowFlightsData();
                followFlightsData.setTripName(followFlightsDataList.get(position).getTripName());
                followFlightsData.setGuideName(followFlightsDataList.get(position).getGuideName());
                followFlightsData.setBusName(followFlightsDataList.get(position).getBusName());
                followFlightsData.setDriverName(followFlightsDataList.get(position).getDriverName());
                followFlightsData.setFrom(followFlightsDataList.get(position).getFrom());
                followFlightsData.setTo(followFlightsDataList.get(position).getTo());
                followFlightsData.setDateStart(followFlightsDataList.get(position).getDateStart());
                followFlightsData.setDateEnd(followFlightsDataList.get(position).getDateEnd());*/
                detailsFollowFlightsView.showDetailsFollowFlights(followFlightsDataList.get(position));
            }
        });

    }

    @Override
    public int getItemCount() {
        return followFlightsDataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView busNumber;
        private TextView status;
       // RelativeLayout relativeItem;

        public ViewHolder(View itemView) {
            super( itemView );

            busNumber=itemView.findViewById(R.id.row_follow_flights_bus_number);
            status=itemView.findViewById(R.id.row_follow_flights_status);
         //   relativeItem=itemView.findViewById(R.id.row_follow_flights_relative_item);

        }
    }
}