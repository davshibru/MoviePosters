package com.example.movieposters.model.ModelForRecyclerView;

import java.util.List;

public class zalsNorm {
    private String zal;
    private List<SessionsForZal> sessionsForZals;

    public zalsNorm(String zal, List<SessionsForZal> sessionsForZals) {
        this.zal = zal;
        this.sessionsForZals = sessionsForZals;
    }

    public String getZal() {
        return zal;
    }

    public List<SessionsForZal> getSessionsForZals() {
        return sessionsForZals;
    }
}
