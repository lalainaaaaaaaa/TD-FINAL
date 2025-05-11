package edu.soccer.app.dao.entity;

import java.util.ArrayList;
import java.util.List;

public class clubs {
    private int id;
    private String name;
    private String acronym;
    private int yearOfCreation;
    private String stadium;
    private String coach;
    private String nationality;

    private CollectiveStatistics statistics;
    private List<players> players;

    public clubs(int id, String name, String acronym, int yearOfCreation, String stadium, String coach, String nationality) {
        this.id = id;
        this.name = name;
        this.acronym = acronym;
        this.yearOfCreation = yearOfCreation;
        this.stadium = stadium;
        this.coach = coach;
        this.nationality = nationality;
        this.statistics = new CollectiveStatistics();
        this.players = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAcronym() {
        return acronym;
    }

    public int getYearOfCreation() {
        return yearOfCreation;
    }

    public String getStadium() {
        return stadium;
    }

    public String getCoach() {
        return coach;
    }

    public String getNationality() {
        return nationality;
    }

    public CollectiveStatistics getStatistics() {
        return statistics;
    }

    public List<players> getPlayers() {
        return players;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAcronym(String acronym) {
        this.acronym = acronym;
    }

    public void setYearOfCreation(int yearOfCreation) {
        this.yearOfCreation = yearOfCreation;
    }

    public void setStadium(String stadium) {
        this.stadium = stadium;
    }

    public void setCoach(String coach) {
        this.coach = coach;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public void setStatistics(CollectiveStatistics statistics) {
        this.statistics = statistics;
    }

    public void setPlayers(List<players> players) {
        this.players = players;
    }

    public void addPlayer(players player) {
        if (player != null) {
            players.add(player);
        }
    }

    @Override
    public String toString() {
        return "clubs{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", acronym='" + acronym + '\'' +
                ", yearOfCreation=" + yearOfCreation +
                ", stadium='" + stadium + '\'' +
                ", coach='" + coach + '\'' +
                ", nationality='" + nationality + '\'' +
                ", playersCount=" + (players != null ? players.size() : 0) +
                '}';
    }
}
