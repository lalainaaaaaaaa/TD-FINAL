package edu.soccer.app.dao.entity;


public class ChampionshipData {
    private String championshipName;
    private int year;


    public ChampionshipData() {}

    public String getChampionshipName() {
        return championshipName;
    }

    public void setChampionshipName(String championshipName) {
        this.championshipName = championshipName;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
