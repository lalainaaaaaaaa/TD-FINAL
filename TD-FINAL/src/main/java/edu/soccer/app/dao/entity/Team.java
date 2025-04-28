package edu.soccer.app.dao.entity;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private String name;
    private String acronym;
    private int yearFounded;
    private String stadium;
    private List<Player> players;
    private Coach coach;
    private CollectiveStatistics collectiveStatistics;

    public Team(String name, String acronym, int yearFounded, String stadium) {
        this.name = name;
        this.acronym = acronym;
        this.yearFounded = yearFounded;
        this.stadium = stadium;
        this.players = new ArrayList<>();
        this.collectiveStatistics = new CollectiveStatistics();
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public void setCoach(Coach coach) {
        this.coach = coach;
    }

    public CollectiveStatistics getCollectiveStatistics() { // Add this method
        return collectiveStatistics;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public String getAcronym() {
        return acronym;
    }

    public int getYearFounded() {
        return yearFounded;
    }

    public String getStadium() {
        return stadium;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public Coach getCoach() {
        return coach;
    }
}