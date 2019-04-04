package com.example.alshimaa.smartguide.adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.alshimaa.smartguide.R;
import com.example.alshimaa.smartguide.model.FollowFlightsData;

import java.util.List;

public class FollowFlightsAdapter extends RecyclerView.Adapter<FollowFlightsAdapter.ViewHolder> {
    Context context;
    List<FollowFlightsData> followFlightsDataList;

   // DetailsExhibtionView detailsExhibtionView;


    public FollowFlightsAdapter(Context context, List<FollowFlightsData> followFlightsDataList) {
        this.context = context;
        this.followFlightsDataList = followFlightsDataList;
    }

   /* public  void onClick(DetailsExhibtionView detailsExhibtionView)
    {
        this.detailsExhibtionView=detailsExhibtionView;
    }*/
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

        Typeface customFontMedium = Typeface.createFromAsset( context.getAssets(), "SST Arabic Light.ttf" );
        holder.busNumber.setTypeface( customFontMedium );
        holder.status.setTypeface( customFontMedium );

       /* holder.address.setTypeface( customFontRegular );*/

       /* holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CurrentExhibtionData currentExhibtionData=new CurrentExhibtionData();
                currentExhibtionData.setYoutube(currentExhibtionDataList.get(position).getYoutube());
                currentExhibtionData.setTitle(currentExhibtionDataList.get(position).getTitle());
                currentExhibtionData.setDescription(currentExhibtionDataList.get(position).getDescription());
                currentExhibtionData.setAddress(currentExhibtionDataList.get(position).getAddress());
                currentExhibtionData.setId(currentExhibtionDataList.get(position).getId());
                currentExhibtionData.setIdUser(currentExhibtionDataList.get(position).getIdUser());
                currentExhibtionData.setLogo(currentExhibtionDataList.get(position).getLogo());
                detailsExhibtionView.showExhibtionDetails(currentExhibtionData);
            }
        });*/

    }

    @Override
    public int getItemCount() {
        return followFlightsDataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView busNumber;
        private TextView status;

        public ViewHolder(View itemView) {
            super( itemView );

            busNumber=itemView.findViewById(R.id.row_follow_flights_bus_number);
            status=itemView.findViewById(R.id.row_follow_flights_status);


        }
    }
}