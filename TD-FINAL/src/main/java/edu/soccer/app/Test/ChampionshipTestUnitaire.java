package edu.soccer.app.Test;

import edu.soccer.app.dao.entity.Championship;
import edu.soccer.app.dao.entity.Match;
import edu.soccer.app.dao.entity.Season;
import edu.soccer.app.dao.entity.Team;

import java.util.List;

public class ChampionshipTestUnitaire {

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


        System.out.println("Matches of the championship " + championship.getName() + " :");
        for (Match match : championship.getMatches()) {
            System.out.println(match);
        }

        System.out.println("Current season: " + championship.getCurrentSeason().getYear() + " - " + championship.getCurrentSeason().getYearEnd());

        List<Match> matches = championship.getMatches();
        if (matches.size() == 6) {
            System.out.println(" Match generation test: OK");
        } else {
            System.out.println(" Match generation test: FAILED");
        }
    }
}