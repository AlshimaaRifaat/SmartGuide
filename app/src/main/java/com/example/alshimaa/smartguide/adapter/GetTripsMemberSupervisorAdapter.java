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
import com.example.alshimaa.smartguide.model.GetTripsMemberSupervisorData;
import com.example.alshimaa.smartguide.view.DetailsFollowFlightsView;
import com.example.alshimaa.smartguide.view.DetailsMemberTripsView;

import java.util.List;

public class GetTripsMemberSupervisorAdapter extends RecyclerView.Adapter<GetTripsMemberSupervisorAdapter.ViewHolder> {
    Context context;
    List<GetTripsMemberSupervisorData> getTripsMemberSupervisorDataList;


    DetailsMemberTripsView detailsMemberTripsView;


    public GetTripsMemberSupervisorAdapter(Context context, List<GetTripsMemberSupervisorData> getTripsMemberSupervisorDataList) {
        this.context = context;
        this.getTripsMemberSupervisorDataList = getTripsMemberSupervisorDataList;
    }

   public  void onClick(DetailsMemberTripsView detailsMemberTripsView)
    {
        this.detailsMemberTripsView=detailsMemberTripsView;
    }
    @Override
    public GetTripsMemberSupervisorAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from( context ).inflate(R.layout.row_get_trips_member,parent,false);
        return new GetTripsMemberSupervisorAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GetTripsMemberSupervisorAdapter.ViewHolder holder, final int position) {
       /* Glide.with( context ).load( "http://omelqoura.com"
                +followFlightsDataList.get( position ).getImg() ).into(holder.imageView);*/
        holder.path.setText("( "+getTripsMemberSupervisorDataList.get( position ).getFrom()+" – "+getTripsMemberSupervisorDataList.get( position ).getTo()+" )");
        holder.status.setText(getTripsMemberSupervisorDataList.get( position ).getStatus());
        // Typeface customFontBold = Typeface.createFromAsset( context.getAssets(), "DroidKufi-Bold.ttf" );
        /* holder.address.setText(currentExhibtionDataList.get( position ).getAddress());*/

        Typeface customFontBold= Typeface.createFromAsset( context.getAssets(), "DroidKufi-Bold.ttf" );
        holder.path.setTypeface( customFontBold );
        holder.status.setTypeface( customFontBold );

        /* holder.address.setTypeface( customFontRegular );*/




     holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                detailsMemberTripsView.showDetailsMemberTrips(getTripsMemberSupervisorDataList.get(position));
            }
        });

    }

    @Override
    public int getItemCount() {
        return getTripsMemberSupervisorDataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView path;
        private TextView status;
        // RelativeLayout relativeItem;

        public ViewHolder(View itemView) {
            super( itemView );

            path=itemView.findViewById(R.id.row_get_trips_member_path);
            status=itemView.findViewById(R.id.row_get_trips_member_status);
            //   relativeItem=itemView.findViewById(R.id.row_follow_flights_relative_item);

        }
    }
}
