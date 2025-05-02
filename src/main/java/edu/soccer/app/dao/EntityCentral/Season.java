package edu.soccer.app.dao.EntityCentral;

public class Season {
    private int id;
    private String year;
    private int championshipId;

    public Season() {}

    public Season(int id, String year, int championshipId) {
        this.id = id;
        this.year = year;
        this.championshipId = championshipId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public int getChampionshipId() {
        return championshipId;
    }

    public void setChampionshipId(int championshipId) {
        this.championshipId = championshipId;
    }
}

