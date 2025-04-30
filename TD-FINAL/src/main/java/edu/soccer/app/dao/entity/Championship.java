package edu.soccer.app.dao.entity;

import java.util.ArrayList;
import java.util.List;

public class Championship {
    private final String name;
    private final String country;
    private List<Team> teams;
    private List<Match> matches;
    private Season currentSeason;

    public Championship(String name, String country) {
        this.name = name;
        this.country = country;
        this.teams = new ArrayList<>();
        this.matches = new ArrayList<>();
    }

    public void addTeam(Team team) {
        teams.add(team);
    }

    public void generateMatches() {
        if (currentSeason == null) {
            throw new IllegalStateException("The current season is not defined.");
        }
        matches.clear(); // vide la liste précédente si nécessaire
        for (int i = 0; i < teams.size(); i++) {
            for (int j = i + 1; j < teams.size(); j++) {
                Team homeTeam = teams.get(i);
                Team awayTeam = teams.get(j);
                matches.add(new Match(homeTeam, awayTeam, currentSeason));
                matches.add(new Match(awayTeam, homeTeam, currentSeason));
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

    public List<Team> getTeams() {
        return teams;
    }

    public Season getCurrentSeason() {
        return currentSeason;
    }

    public void setCurrentSeason(Season currentSeason) {
        this.currentSeason = currentSeason;
    }

    public List<Match> getMatches() {
        return matches;
    }
}