package edu.soccer.app.dao.EntityCentral;

public class Match {
    private int id;
    private int seasonId;
    private int clubHomeId;
    private int clubAwayId;
    private int homeGoals;
    private int awayGoals;
    private String matchDate;

    public Match() {}

    public Match(int id, int seasonId, int clubHomeId, int clubAwayId, int homeGoals, int awayGoals, String matchDate) {
        this.id = id;
        this.seasonId = seasonId;
        this.clubHomeId = clubHomeId;
        this.clubAwayId = clubAwayId;
        this.homeGoals = homeGoals;
        this.awayGoals = awayGoals;
        this.matchDate = matchDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSeasonId() {
        return seasonId;
    }

    public void setSeasonId(int seasonId) {
        this.seasonId = seasonId;
    }

    public int getClubHomeId() {
        return clubHomeId;
    }

    public void setClubHomeId(int clubHomeId) {
        this.clubHomeId = clubHomeId;
    }

    public int getClubAwayId() {
        return clubAwayId;
    }

    public void setClubAwayId(int clubAwayId) {
        this.clubAwayId = clubAwayId;
    }

    public int getHomeGoals() {
        return homeGoals;
    }

    public void setHomeGoals(int homeGoals) {
        this.homeGoals = homeGoals;
    }

    public int getAwayGoals() {
        return awayGoals;
    }

    public void setAwayGoals(int awayGoals) {
        this.awayGoals = awayGoals;
    }

    public String getMatchDate() {
        return matchDate;
    }

    public void setMatchDate(String matchDate) {
        this.matchDate = matchDate;
    }
}

