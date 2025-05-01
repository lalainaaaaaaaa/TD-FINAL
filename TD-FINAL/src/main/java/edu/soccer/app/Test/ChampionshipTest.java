package edu.soccer.app.Test;

import edu.soccer.app.dao.entity.Championship;
import edu.soccer.app.dao.entity.Match;
import edu.soccer.app.dao.entity.Season;
import edu.soccer.app.dao.entity.Team;

import java.util.List;

public class ChampionshipTest {
    public static void main(String[] args) {
        Championship championship = new Championship("Premier League", "England");

        Team team1 = new Team("Team 1");
        Team team2 = new Team("Team 2");
        Team team3 = new Team("Team 3");

        championship.addTeam(team1);
        championship.addTeam(team2);
        championship.addTeam(team3);

        Season season = new Season(2024);
        championship.setCurrentSeason(season);

        championship.generateMatches();

        System.out.println("Matches of the championship " + championship.getName() + ":");

        List<Match> matches = championship.getMatches();

        for (Match match : matches) {
            String homeTeamName = match.getHomeTeam() != null ? match.getHomeTeam().getName() : "Unknown";
            String awayTeamName = match.getAwayTeam() != null ? match.getAwayTeam().getName() : "Unknown";
            int homeScore = match.getHomeScore();
            int awayScore = match.getAwayScore();
            int seasonYear = match.getSeason() != null ? match.getSeason().getYear() : 0;

            System.out.println(homeTeamName + " vs " + awayTeamName + " | Score: " +
                    homeScore + " - " + awayScore + " | Season: " +
                    (seasonYear != 0 ? seasonYear : ""));
        }

        Season currentSeason = championship.getCurrentSeason();
        if (currentSeason != null) {
            String yearEnd = currentSeason.getYearEnd();
            System.out.println("Current season: " + currentSeason.getYear() + " - " +
                    (yearEnd != null ? yearEnd : "Not available"));
        } else {
            System.out.println("Current season: Not available");
        }
    }
}
