package edu.soccer.app.Test;

import edu.soccer.app.dao.entity.matchMaker;
import edu.soccer.app.dao.entity.matches;
import edu.soccer.app.dao.entity.clubs;
import edu.soccer.app.dao.entity.season;

import java.util.Arrays;
import java.util.List;

public class matchMakerTest{

    public static void main(String[] args) {
        clubs club1 = new clubs(1, "Club 1", "C1", 1902, "Stade 1", "Coach 1", "France");
        clubs club2 = new clubs(2, "Club 2", "C2", 1905, "Stade 2", "Coach 2", "Italie");
        clubs club3 = new clubs(3, "Club 3", "C3", 1910, "Stade 3", "Coach 3", "Allemagne");


        season season2024 = new season(2024);


        matches m1 = new matches(club1, club2, season2024);
        m1.setHomeScore(3);
        m1.setAwayScore(1);

        matches m2 = new matches(club2, club3, season2024);
        m2.setHomeScore(2);
        m2.setAwayScore(2);

        matches m3 = new matches(club3, club1, season2024);
        m3.setHomeScore(0);
        m3.setAwayScore(4);


        List<matches> matchs = Arrays.asList(m1, m2, m3);

        matches best = matchMaker.bestMatch(matchs);

        System.out.println("Best match : " +
                best.getHomeTeam().getName() + " vs " +
                best.getAwayTeam().getName() + "  Score : " +
                best.getHomeScore() + " - " + best.getAwayScore());
    }
}
