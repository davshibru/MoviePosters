package com.example.movieposters.model.ModelForRecyclerView;

import java.util.List;

public class PoserAndTitle {

    private String title;
    private String poster;
    private List<Zal> zals;
    private String vote;
    private String countries;
    private String actors;

    public PoserAndTitle(String title, String poster, List<Zal> zals, String vote, String countries, String actors) {
        this.title = title;
        this.poster = poster;
        this.zals = zals;
        this.vote = vote;
        this.countries = countries;
        this.actors = actors;
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

    public String getVote() {
        return vote;
    }

    public String getCountries() {
        return countries;
    }

    public String getActors() {
        return actors;
    }
}
