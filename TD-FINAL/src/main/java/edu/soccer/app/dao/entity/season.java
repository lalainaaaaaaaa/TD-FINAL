package edu.soccer.app.dao.entity;

import java.util.ArrayList;
import java.util.List;

public class season {
    private int year;
    private List<clubs> clubs;
    private List<matches> matches;

    public season(int year) {
        this.year = year;
        this.clubs = new ArrayList<>();
        this.matches = new ArrayList<>();
    }

    public int getYear() { return year; }
    public List<clubs> getClubs() { return clubs; }
    public List<matches> getMatches() { return matches; }

    public void addClub(clubs club) {
        clubs.add(club);
    }

    public void generateMatches() {
        matches.clear();
        for (int i = 0; i < clubs.size(); i++) {
            for (int j = i + 1; j < clubs.size(); j++) {
                clubs home = clubs.get(i);
                clubs away = clubs.get(j);
                matches.add(new matches(home, away, this));
                matches.add(new matches(away, home, this));
            }
        }
    }
}
