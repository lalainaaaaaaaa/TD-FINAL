package edu.soccer.app.dao.entity;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private final String name;
    private String acronym;
    private final int yearFounded;
    private final String stadium;
    private final List<Player> players;
    private Coach coach;
    private final CollectiveStatistics collectiveStatistics;

    public Team(String name, String acronym, int yearFounded, String stadium) {
        this.name = name;
        this.acronym = acronym;
        this.yearFounded = yearFounded;
        this.stadium = stadium;
        this.players = new ArrayList<>();
        this.collectiveStatistics = new CollectiveStatistics();
    }

    // Méthodes set pour les attributs modifiables
    public void setAcronym(String acronym) {
        this.acronym = acronym;
    }

    public String getAcronym() {
        return acronym;
    }

    // Autres getters...

    public String getName() {
        return name;
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

    public void setCoach(Coach coach) {
        this.coach = coach;
    }

    public CollectiveStatistics getCollectiveStatistics() {
        return collectiveStatistics;
    }
}