package com.example.movieposters.model.ModelForRecyclerView;

import java.util.List;

public class PoserAndTitle {

    private String title;
    private String poster;
    private List<Zal> zals;

    public PoserAndTitle(String title, String poster, List<Zal> zals) {
        this.title = title;
        this.poster = poster;
        this.zals = zals;
    }

    public String getTitle() {
        return title;
    }

    public String getPoster() {
        return poster;
    }

    public List<Zal> getZals() {
        return zals;
    }
}
