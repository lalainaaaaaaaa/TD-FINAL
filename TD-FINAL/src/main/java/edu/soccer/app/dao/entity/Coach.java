package edu.soccer.app.dao.entity;

public class Coach {
    private final String name;
    private final String nationality;

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
