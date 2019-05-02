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
import com.example.alshimaa.smartguide.model.FollowFlightsData;
import com.example.alshimaa.smartguide.model.OldRequestsGuideData;
import com.example.alshimaa.smartguide.view.DetailsFollowFlightsView;

import java.util.List;

public class OldRequestsGuideAdapter extends RecyclerView.Adapter<OldRequestsGuideAdapter.ViewHolder> {
    Context context;
    List<OldRequestsGuideData> oldRequestsGuideDataList;



    //DetailsFollowFlightsView detailsFollowFlightsView;


    public OldRequestsGuideAdapter(Context context, List<OldRequestsGuideData> oldRequestsGuideDataList) {
        this.context = context;
        this.oldRequestsGuideDataList = oldRequestsGuideDataList;
    }

    /*public  void onClick(DetailsFollowFlightsView detailsFollowFlightsView)
    {
        this.detailsFollowFlightsView=detailsFollowFlightsView;
    }*/
    @Override
    public OldRequestsGuideAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from( context ).inflate(R.layout.row_old_requests_guide,parent,false);
        return new OldRequestsGuideAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OldRequestsGuideAdapter.ViewHolder holder, final int position) {

        holder.fromTo.setText(" المسار: "+oldRequestsGuideDataList.get( position ).getFrom()+" الى "+oldRequestsGuideDataList.get( position ).getTo());
      if(oldRequestsGuideDataList.get( position ).getStatus().equals("3"))
      {
         holder.status.setText("تم الموافقه على طلبك");
         holder.acceptIcon.setVisibility(View.VISIBLE);
      }else
      {
          holder.status.setText("تم رفض طلبك");
          holder.refuseIcon.setVisibility(View.VISIBLE);
      }
        Typeface customFontBold= Typeface.createFromAsset( context.getAssets(), "DroidKufi-Bold.ttf" );
        holder.fromTo.setTypeface( customFontBold );
        holder.status.setTypeface( customFontBold );





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
        return oldRequestsGuideDataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView fromTo;
        private TextView status;
        ImageView acceptIcon;
        ImageView refuseIcon;

        // RelativeLayout relativeItem;

        public ViewHolder(View itemView) {
            super( itemView );

            fromTo=itemView.findViewById(R.id.row_old_requests_text_fromTo);
            status=itemView.findViewById(R.id.row_old_requests_text_status);
            acceptIcon=itemView.findViewById(R.id.row_old_requests_icon_alarm_yes);
            refuseIcon=itemView.findViewById(R.id.row_old_requests_icon_alarm_no);
            //   relativeItem=itemView.findViewById(R.id.row_follow_flights_relative_item);

        }
    }
}

