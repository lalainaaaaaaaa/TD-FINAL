package edu.soccer.app.dao.EntityCentral;

public class Player {
    private int id;
    private String name;
    private int age;
    private String position;
    private int goals;
    private int clubId;

    public Player() {}

    public Player(int id, String name, int age, String position, int goals, int clubId) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.position = position;
        this.goals = goals;
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

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getGoals() {
        return goals;
    }

    public void setGoals(int goals) {
        this.goals = goals;
    }

    public int getClubId() {
        return clubId;
    }

    public void setClubId(int clubId) {
        this.clubId = clubId;
    }
}

