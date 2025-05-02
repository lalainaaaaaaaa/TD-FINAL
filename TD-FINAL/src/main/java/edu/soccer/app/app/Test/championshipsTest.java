package edu.soccer.app.Test;

import edu.soccer.app.dao.entity.championships;
import edu.soccer.app.dao.entity.matches;
import edu.soccer.app.dao.entity.season;
import edu.soccer.app.dao.entity.clubs;

import java.util.List;

public class championshipsTest {
    public static void main(String[] args) {
        championships championship = new championships("Premier League", "England");

        clubs team1 = new clubs("Team 1");
        clubs team2 = new clubs("Team 2");
        clubs team3 = new clubs("Team 3");

        championship.addTeam(team1);
        championship.addTeam(team2);
        championship.addTeam(team3);

        season season = new season(2024);
        championship.setCurrentSeason(season);

        championship.generateMatches();

        System.out.println("Matches of the championship " + championship.getName() + ":");

        List<matches> matches = championship.getMatches();

        for (edu.soccer.app.dao.entity.matches match : matches) {
            String homeTeamName = match.getHomeTeam() != null ? match.getHomeTeam().getName() : "Unknown";
            String awayTeamName = match.getAwayTeam() != null ? match.getAwayTeam().getName() : "Unknown";
            int homeScore = match.getHomeScore();
            int awayScore = match.getAwayScore();
            int seasonYear = match.getSeason() != null ? match.getSeason().getYear() : 0;

            System.out.println(homeTeamName + " vs " + awayTeamName + " | Score: " +
                    homeScore + " - " + awayScore + " | Season: " +
                    (seasonYear != 0 ? seasonYear : ""));
        }

        edu.soccer.app.dao.entity.season currentSeason = championship.getCurrentSeason();
        if (currentSeason != null) {
            String yearEnd = currentSeason.getYearEnd();
            System.out.println("Current season: " + currentSeason.getYear() + " - " +
                    (yearEnd != null ? yearEnd : "Not available"));
        } else {
            System.out.println("Current season: Not available");
        }
    }
}
