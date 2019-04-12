package com.example.movieposters.mvp;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.movieposters.R;
import com.example.movieposters.cinema.CinemaActivty;
import com.example.movieposters.model.ModelForRecyclerView.PoserAndTitle;
import com.example.movieposters.model.ModelForRecyclerView.SessionsForZal;
import com.example.movieposters.model.ModelForRecyclerView.Zal;

import java.util.List;

public class RecyclerViewAdapterMovie extends RecyclerView.Adapter<RecyclerViewAdapterMovie.ViewHolder> {

    private Context mContext;
    private List<PoserAndTitle> mData;

    public RecyclerViewAdapterMovie(Context mContext, List<PoserAndTitle> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View v;
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        v = layoutInflater.inflate(R.layout.movie_cardview, viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        final String Title = mData.get(i).getTitle();
        final String Poster = "http://kinoafisha.ua" + mData.get(i).getPoster();
        final String Vote = mData.get(i).getVote();
        final String Countries = mData.get(i).getCountries();
        final String Actors = mData.get(i).getActors();

        final String data = readingTeaterAndSession(mData.get(i).getZals());

        viewHolder.title.setText(Title);
        Glide.with(mContext)
        .asBitmap()
        .load(Poster)
        .into(viewHolder.poster);

        viewHolder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(mContext, CinemaActivty.class);
                intent.putExtra("Title", Title);
                intent.putExtra("Poster", Poster);
                intent.putExtra("Data", data);
                intent.putExtra("Vote", Vote);
                intent.putExtra("Countries", Countries);
                intent.putExtra("Actors", Actors);
                mContext.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        TextView title;
        ImageView poster;
        CardView cardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            title = (TextView) itemView.findViewById(R.id.name_of_film);
            poster = (ImageView) itemView.findViewById(R.id.img_of_movie);
            cardView = (CardView) itemView.findViewById(R.id.cardview);
        }
    }

    public String readingTeaterAndSession(List<Zal> zals){
        String str = "";
        String check = "";
        for (Zal zal : zals){
            String cinema = zal.getTeather();
            if (check.equals(cinema)){

                str += "razdelitzal" + zal.getZal();
                String session = "";
                for (SessionsForZal sessionsForZal : zal.getSessions()){
                    session += "razdelitvremi" + sessionsForZal.getTime();
                }
                str += session;
            }
            else {
                str += "razdelitkinoteather";
                check = zal.getTeather();
                str += "razdelitzal" + check + "razdelitzal" + zal.getZal();
                String session = "";
                for (SessionsForZal sessionsForZal : zal.getSessions()){
                    session += "razdelitvremi" + sessionsForZal.getTime();
                }
                str += session;
            }
        }
        return str;
    }

}
