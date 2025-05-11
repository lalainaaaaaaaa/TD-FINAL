package edu.soccer.app.dao.entity;

import java.util.HashMap;
import java.util.Map;

public class matches {
    private clubs homeTeam;
    private clubs awayTeam;
    private season season;
    private String status;
    private int homeScore;
    private int awayScore;
    private String stadium;

    private Map<String, IndividualStatistics> playerStats = new HashMap<>();

    public matches(clubs homeTeam, clubs awayTeam, season season) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.season = season;
        this.status = "NOT_STARTED";
        this.homeScore = 0;
        this.awayScore = 0;
        this.stadium = homeTeam.getStadium();
    }


    public clubs getHomeTeam() {
        return homeTeam;
    }
    public clubs getAwayTeam() {
        return awayTeam;
    }
    public season getSeason() {
        return season;
    }
    public String getStatus() {
        return status;
    }
    public int getHomeScore() {
        return homeScore;
    }
    public int getAwayScore() {
        return awayScore;
    }
    public String getStadium() {
        return stadium;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public void setHomeScore(int homeScore) {
        this.homeScore = homeScore;
    }
    public void setAwayScore(int awayScore) {
        this.awayScore = awayScore;
    }

    public void addPlayerStatistics(String playerId, IndividualStatistics stats) {
        playerStats.put(playerId, stats);
    }

    public IndividualStatistics getPlayerStatistics(String playerId) {
        return playerStats.get(playerId);
    }
}
