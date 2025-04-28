package edu.soccer.app.dao.entity;

public class Coach {
    private String name;
    private String nationality;

    public Coach(String name, String nationality) {
        this.name = name;
        this.nationality = nationality;
    }

    public String getName() {
        return name;
    }

    public String getNationality() {
        return nationality;
    }
}
