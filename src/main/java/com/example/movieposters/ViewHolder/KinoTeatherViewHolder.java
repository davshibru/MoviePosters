package com.example.movieposters.ViewHolder;

import android.view.View;
import android.widget.TextView;

import com.example.movieposters.R;
import com.example.movieposters.model.ExpModel.KinoTeather;
import com.thoughtbot.expandablerecyclerview.viewholders.GroupViewHolder;

public class KinoTeatherViewHolder extends GroupViewHolder {

    private TextView mTextView;

    public KinoTeatherViewHolder(View itemView) {
        super(itemView);
        mTextView = itemView.findViewById(R.id.list_item_cinema_name);
    }

    public void bind(KinoTeather kinoTeather){
        mTextView.setText(kinoTeather.getTitle());
    }
}
