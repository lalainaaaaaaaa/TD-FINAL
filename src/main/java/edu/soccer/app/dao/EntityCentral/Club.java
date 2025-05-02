package edu.soccer.app.dao.EntityCentral;

public class Club {
    private int id;
    private String name;
    private String city;
    private int championshipId;

    public Club() {}

    public Club(int id, String name, String city, int championshipId) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.championshipId = championshipId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getChampionshipId() {
        return championshipId;
    }

    public void setChampionshipId(int championshipId) {
        this.championshipId = championshipId;
    }
}

