package edu.soccer.app.dao.entity;

public class IndividualStatistics {
    private int goals;
    private int playingTime;

    public IndividualStatistics() {
        this.goals = 0;
        this.playingTime = 0;
    }

    public int getGoals() {
        return goals;
    }

    public void setGoals(int goals) {
        this.goals = goals;
    }

    public void updateGoals(int goals) {
        this.goals += goals;
    }

    public int getPlayingTime() {
        return playingTime;
    }

    public void setPlayingTime(int playingTime) {
        this.playingTime = playingTime;
    }

    public void updatePlayingTime(int minutes) {
        this.playingTime += minutes;
    }
}
