package edu.soccer.app.dao.entity;

import java.util.ArrayList;
import java.util.List;

public class championships {
    private final String name;
    private final String country;
    private List<clubs> teams;
    private List<edu.soccer.app.dao.entity.matches> matches;
    private season currentSeason;

    public championships(String name, String country) {
        this.name = name;
        this.country = country;
        this.teams = new ArrayList<>();
        this.matches = new ArrayList<>();
    }

    public void addTeam(clubs team) {
        teams.add(team);
    }

    public void generateMatches() {
        if (currentSeason == null) {
            throw new IllegalStateException("The current season is not defined.");
        }
        matches.clear();
        for (int i = 0; i < teams.size(); i++) {
            for (int j = i + 1; j < teams.size(); j++) {
                clubs homeTeam = teams.get(i);
                clubs awayTeam = teams.get(j);
                matches.add(new matches(homeTeam, awayTeam, currentSeason));
                matches.add(new matches(awayTeam, homeTeam, currentSeason));
            }
        }
    }

    public void endSeason() {
        if (currentSeason != null) {
            System.out.println("The " + currentSeason.getYear() + " season has ended.");
        } else {
            throw new IllegalStateException("No ongoing season to end.");
        }
    }

    public String getName() {
        return name;
    }
    public String getCountry() {
        return country;
    }
    public List<clubs> getTeams() {
        return teams;
    }
    public season getCurrentSeason() {
        return currentSeason;
    }
    public void setCurrentSeason(season currentSeason) {
        this.currentSeason = currentSeason;
    }
    public List<edu.soccer.app.dao.entity.matches> getMatches() {
        return matches;
    }

    public Integer getYear() {
        return null;
    }
}