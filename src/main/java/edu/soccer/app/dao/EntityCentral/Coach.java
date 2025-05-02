package edu.soccer.app.dao.EntityCentral;

public class Coach {
    private int id;
    private String name;
    private int age;
    private int clubId;

    public Coach() {}

    public Coach(int id, String name, int age, int clubId) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.clubId = clubId;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getClubId() {
        return clubId;
    }

    public void setClubId(int clubId) {
        this.clubId = clubId;
    }
}

