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
import com.example.alshimaa.smartguide.model.OldRequestsGuideData;
import com.example.alshimaa.smartguide.model.OldRequestsSupervisorData;
import com.example.alshimaa.smartguide.view.DetailsOldRequestsSupervisorView;

import java.util.List;

public class OldRequestsSupervisorAdapter extends RecyclerView.Adapter<OldRequestsSupervisorAdapter.ViewHolder> {
    Context context;
    List<OldRequestsSupervisorData> oldRequestsSupervisorDataList;

    public OldRequestsSupervisorAdapter(Context context, List<OldRequestsSupervisorData> oldRequestsSupervisorDataList) {
        this.context = context;
        this.oldRequestsSupervisorDataList = oldRequestsSupervisorDataList;
    }
    DetailsOldRequestsSupervisorView detailsOldRequestsSupervisorView;



   public  void onClick(DetailsOldRequestsSupervisorView detailsOldRequestsSupervisorView)
    {
        this.detailsOldRequestsSupervisorView=detailsOldRequestsSupervisorView;
    }
    @Override
    public OldRequestsSupervisorAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from( context ).inflate(R.layout.row_old_requsets_supervisor,parent,false);
        return new OldRequestsSupervisorAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OldRequestsSupervisorAdapter.ViewHolder holder, final int position) {

        holder.fromTo.setText(" المسار: "+oldRequestsSupervisorDataList.get( position ).getFrom()+" الى "+oldRequestsSupervisorDataList.get( position ).getTo());
        Typeface customFontBold= Typeface.createFromAsset( context.getAssets(), "DroidKufi-Bold.ttf" );
        holder.fromTo.setTypeface( customFontBold );
        holder.requestPause.setTypeface( customFontBold );



        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                detailsOldRequestsSupervisorView.showDetailsOldRequestsSupervisor(oldRequestsSupervisorDataList.get(position));
            }
        });

    }

    @Override
    public int getItemCount() {
        return oldRequestsSupervisorDataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView fromTo;
        private TextView requestPause;


        // RelativeLayout relativeItem;

        public ViewHolder(View itemView) {
            super( itemView );

            fromTo=itemView.findViewById(R.id.row_old_requests_supervisor_text_fromTo);
            requestPause=itemView.findViewById(R.id.row_old_requests_supervisor_txt_pause);

            //   relativeItem=itemView.findViewById(R.id.row_follow_flights_relative_item);

        }
    }
}


