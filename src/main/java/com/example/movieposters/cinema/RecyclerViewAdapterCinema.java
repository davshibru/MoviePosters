package com.example.movieposters.cinema;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.movieposters.R;
import com.example.movieposters.ViewHolder.KinoTeatherViewHolder;
import com.example.movieposters.ViewHolder.SessionViewHolder;
import com.example.movieposters.model.ExpModel.KinoTeather;
import com.example.movieposters.model.ExpModel.Session_Zals_Time;
import com.example.movieposters.model.ModelForRecyclerView.Teathers;
import com.thoughtbot.expandablerecyclerview.ExpandableRecyclerViewAdapter;
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import java.util.List;

public class RecyclerViewAdapterCinema extends ExpandableRecyclerViewAdapter<KinoTeatherViewHolder, SessionViewHolder> {

    public RecyclerViewAdapterCinema(List<? extends ExpandableGroup> groups) {
        super(groups);
    }

    @Override
    public KinoTeatherViewHolder onCreateGroupViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cinema,parent,false);
        return new KinoTeatherViewHolder(v);
    }

    @Override
    public SessionViewHolder onCreateChildViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.session_item,parent,false);
        return new SessionViewHolder(v);
    }

    @Override
    public void onBindChildViewHolder(SessionViewHolder holder, int flatPosition, ExpandableGroup group, int childIndex) {
        final Session_Zals_Time session_zals_time = (Session_Zals_Time) group.getItems().get(childIndex);
        holder.bind(session_zals_time);
    }

    @Override
    public void onBindGroupViewHolder(KinoTeatherViewHolder holder, int flatPosition, ExpandableGroup group) {
        final KinoTeather kinoTeather = (KinoTeather) group;
        holder.bind(kinoTeather);
    }


//    Context mContext;
//    List<Teathers> mData;
//
//    public RecyclerViewAdapterCinema(Context mContext, List<Teathers> mData) {
//        this.mContext = mContext;
//        this.mData = mData;
//    }
//
//    @NonNull
//    @Override
//    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
//
//        View v;
//        v = LayoutInflater.from(mContext).inflate(R.layout.item_cinema, viewGroup,false);
//        MyViewHolder viewHolder = new MyViewHolder(v);
//        return viewHolder;
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
//
//        Log.e("Recycrer",  mData.get(i).getTeathers());
//        myViewHolder.tv_cinema.setText(mData.get(i).getTeathers());
//
//    }
//
//    @Override
//    public int getItemCount() {
//        return mData.size();
//    }
//
//    public static class MyViewHolder extends RecyclerView.ViewHolder {
//
//        private TextView tv_cinema;
//        private ExpandableListView listView;
//
//        public MyViewHolder(@NonNull View itemView) {
//            super(itemView);
//            tv_cinema = (TextView) itemView.findViewById(R.id.cinema_name);
//            listView = (ExpandableListView) itemView.findViewById(R.id.list_session);
//        }
//    }
}
