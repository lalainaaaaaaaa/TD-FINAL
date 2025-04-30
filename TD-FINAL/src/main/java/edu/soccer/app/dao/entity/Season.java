package edu.soccer.app.dao.entity;

import java.util.ArrayList;
import java.util.List;

public class Season {
    private final int year;
    private final List<Match> matches;
    private final List<Team> standings;

    public Season(int year) {
        this.year = year;
        this.matches = new ArrayList<>();
        this.standings = new ArrayList<>();
    }

    public void generateMatches() {
        // Logic
    }

    public List<Team> getStandings() {
        return standings;
    }

    public int getYear() {
        return String.valueOf(year);
    }

    public List<Match> getMatches() {
        return matches;
    }
}
