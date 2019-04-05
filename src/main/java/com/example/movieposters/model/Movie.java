package com.example.movieposters.model;

import java.util.List;

public class Movie {
    int id;
    String name;
    String image;
    String vote;
    List<Kinoteater> sessions;

    public Movie(int id, String name, String image, String vote, List<Kinoteater> sessions) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.vote = vote;
        this.sessions = sessions;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
    }

    public String getVote() {
        return vote;
    }

    public List<Kinoteater> getSessions() {
        return sessions;
    }
}
