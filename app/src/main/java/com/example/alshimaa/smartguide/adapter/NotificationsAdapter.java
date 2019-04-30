package com.example.alshimaa.smartguide.adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.alshimaa.smartguide.R;
import com.example.alshimaa.smartguide.model.FollowFlightsData;
import com.example.alshimaa.smartguide.model.NotificationsData;
import com.example.alshimaa.smartguide.view.DetailsFollowFlightsView;

import java.util.List;

public class NotificationsAdapter extends RecyclerView.Adapter<NotificationsAdapter.ViewHolder> {
    Context context;
    List<NotificationsData> notificationsDataList;



    //DetailsFollowFlightsView detailsFollowFlightsView;


    public NotificationsAdapter(Context context, List<NotificationsData> notificationsDataList) {
        this.context = context;
        this.notificationsDataList = notificationsDataList;
    }

   /* public  void onClick(DetailsFollowFlightsView detailsFollowFlightsView)
    {
        this.detailsFollowFlightsView=detailsFollowFlightsView;
    }*/
    @Override
    public NotificationsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from( context ).inflate(R.layout.row_notification,parent,false);
        return new NotificationsAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NotificationsAdapter.ViewHolder holder, final int position) {

        holder.supervisorName.setText(" اسم المشرف : "+notificationsDataList.get( position ).getSupervisorName());
        holder.driverName.setText(" اسم السائق : "+notificationsDataList.get( position ).getDriverName());
        holder.guideName.setText(" اسم المرشد : "+notificationsDataList.get( position ).getGuideName());
        holder.headerTxt.setText(" عنوان الرساله : "+notificationsDataList.get( position ).getHeadings());
        holder.msgTxt.setText(" الرساله : "+notificationsDataList.get( position ).getMessage());


        Typeface customFontBold= Typeface.createFromAsset( context.getAssets(), "DroidKufi-Bold.ttf" );
        holder.supervisorName.setTypeface( customFontBold );
        holder.driverName.setTypeface( customFontBold );
        holder.guideName.setTypeface( customFontBold );
        holder.headerTxt.setTypeface( customFontBold );
        holder.msgTxt.setTypeface( customFontBold );

      /*  holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                detailsFollowFlightsView.showDetailsFollowFlights(followFlightsDataList.get(position));
            }
        });*/

    }

    @Override
    public int getItemCount() {
        return notificationsDataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView supervisorName;
        private TextView driverName;
        private TextView guideName;
         private TextView headerTxt;
        private TextView msgTxt;
        // RelativeLayout relativeItem;

        public ViewHolder(View itemView) {
            super( itemView );

            supervisorName=itemView.findViewById(R.id.row_notification_text_supervisor_name);
            driverName=itemView.findViewById(R.id.row_notification_text_driver_name);
            guideName=itemView.findViewById(R.id.row_notification_text_guide_name);
            headerTxt=itemView.findViewById(R.id.row_notification_text_header);
            msgTxt=itemView.findViewById(R.id.row_notification_text_msg);
            //   relativeItem=itemView.findViewById(R.id.row_follow_flights_relative_item);

        }
    }
}

