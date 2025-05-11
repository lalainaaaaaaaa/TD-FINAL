package edu.soccer.app.dao.entity;

public class IndividualStatistics {
    private int goals;
    private int assists;
    private int yellowCards;
    private int playingTimeSeconds;

    public IndividualStatistics() {
        this.goals = 0;
        this.assists = 0;
        this.yellowCards = 0;
        this.playingTimeSeconds = 0;
    }

    public void updateGoals(int goals) {
        this.goals += goals;
    }

    public void updateAssists(int assists) {
        this.assists += assists;
    }

    public void updateYellowCards(int yellowCards) {
        this.yellowCards += yellowCards;
    }

    public void updatePlayingTime(int seconds) {
        this.playingTimeSeconds += seconds;
    }


    public int getGoals() {
        return goals;
    }

    public int getAssists() {
        return assists;
    }

    public int getYellowCards() {
        return yellowCards;
    }

    public int getPlayingTimeSeconds() {
        return playingTimeSeconds;
    }

    public void setGoals(int goals) {
        this.goals = goals;
    }

    public void setAssists(int assists) {
        this.assists = assists;
    }

    public void setYellowCards(int yellowCards) {
        this.yellowCards = yellowCards;
    }
}