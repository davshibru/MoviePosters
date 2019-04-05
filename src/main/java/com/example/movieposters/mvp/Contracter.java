package com.example.movieposters.mvp;

import android.content.Context;
import android.view.View;

import com.example.movieposters.model.ModelForRecyclerView.PoserAndTitle;

import java.util.List;

public interface Contracter {
    interface model {
        void getDataFromSite(String BaseUrl);
    }

    interface view {
        void setRecyclerViev(List<PoserAndTitle> movie);
    }
}
