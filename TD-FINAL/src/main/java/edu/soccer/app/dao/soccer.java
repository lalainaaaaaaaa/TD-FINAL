package edu.soccer.app.dao.entity;

public class soccer {
    private Long id;
    private String name;
    private String country;
    private int yearEstablished;


    public soccer(Long id, String name, String country, int yearEstablished) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.yearEstablished = yearEstablished;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getYearEstablished() {
        return yearEstablished;
    }

    public void setYearEstablished(int yearEstablished) {
        this.yearEstablished = yearEstablished;
    }
}
