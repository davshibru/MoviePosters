package com.example.movieposters.ViewHolder;

import android.view.View;
import android.widget.TextView;

import com.example.movieposters.R;
import com.example.movieposters.model.ExpModel.Session_Zals_Time;
import com.thoughtbot.expandablerecyclerview.viewholders.ChildViewHolder;

public class SessionViewHolder extends ChildViewHolder {

    private TextView mTextView;

    public SessionViewHolder(View itemView) {
        super(itemView);
        mTextView = (TextView) itemView.findViewById(R.id.list_item_session_name);
    }

    public void bind(Session_Zals_Time session_zals_time){
        mTextView.setText(session_zals_time.name);
    }
}
