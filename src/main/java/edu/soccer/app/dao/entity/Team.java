package edu.soccer.app.dao.entity;

public class Team {
    private String name;                  // Nom du club
    private String stadium;               // Nom du stade
    private String acronym;               // Acronyme (ex: "RMA", "FCB")
    private int yearFounded;              // Année de création
    private int points;                   // Points du club pour la saison en cours
    private CollectiveStatistics statistics; // Statistiques collectives du club

    // Constructeur principal
    public Team(String name) {
        this.name = name;
        this.stadium = stadium;
        this.acronym = acronym;
        this.yearFounded = yearFounded;
        this.points = 0; // Initialisation à 0 en début de saison
        this.statistics = new CollectiveStatistics(); // Statistiques vides au départ
    }

    // Getter pour le nom du club
    public String getName() {
        return name;
    }

    // Getter pour le stade
    public String getStadium() {
        return stadium;
    }

    // Getter pour l'acronyme
    public String getAcronym() {
        return acronym;
    }

    // Getter pour l'année de création
    public int getYearFounded() {
        return yearFounded;
    }

    // Getter pour les points
    public int getPoints() {
        return points;
    }

    // Getter pour les statistiques collectives
    public CollectiveStatistics getStatistics() {
        return statistics;
    }

    // Setter pour le nom du club
    public void setName(String name) {
        this.name = name;
    }

    // Setter pour le stade
    public void setStadium(String stadium) {
        this.stadium = stadium;
    }

    // Setter pour l'acronyme
    public void setAcronym(String acronym) {
        this.acronym = acronym;
    }

    // Setter pour l'année de création
    public void setYearFounded(int yearFounded) {
        this.yearFounded = yearFounded;
    }

    // Setter pour les points
    public void setPoints(int points) {
        this.points = points;
    }

    // Setter pour les statistiques collectives
    public void setStatistics(CollectiveStatistics statistics) {
        this.statistics = statistics;
    }

    // Alias pour getAcronym, utile pour l'affichage dans vos tests
    public String getShortName() {
        return acronym;
    }

    @Override
    public String toString() {
        return "Team{" +
                "name='" + name + '\'' +
                ", stadium='" + stadium + '\'' +
                ", acronym='" + acronym + '\'' +
                ", yearFounded=" + yearFounded +
                ", points=" + points +
                ", statistics=" + statistics +
                '}';
    }
}
