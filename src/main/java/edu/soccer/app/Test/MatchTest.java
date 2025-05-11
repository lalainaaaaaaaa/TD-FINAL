package edu.soccer.app.TestCentral;

import edu.soccer.app.dao.EntityCentral.Match;

public class MatchTest {

    public static void main(String[] args) {
        Match match = new Match();


        match.setId(1);
        match.setSeasonId(2024);
        match.setClubHomeId(4);
        match.setClubAwayId(5);
        match.setHomeGoals(4);
        match.setAwayGoals(1);
        match.setMatchDate("2024-05-01");


        System.out.println("Match ID: " + match.getId());
        System.out.println("Season ID: " + match.getSeasonId());
        System.out.println("Home Club ID: " + match.getClubHomeId());
        System.out.println("Away Club ID: " + match.getClubAwayId());
        System.out.println("Home Goals: " + match.getHomeGoals());
        System.out.println("Away Goals: " + match.getAwayGoals());
        System.out.println("Match Date: " + match.getMatchDate());


        if (match.getId() == 1
                && match.getSeasonId() == 2024
                && match.getClubHomeId() == 4
                && match.getClubAwayId() == 5
                && match.getHomeGoals() == 4
                && match.getAwayGoals() == 1
                && "2024-05-01".equals(match.getMatchDate())) {
            System.out.println("Test passed");
        } else {
            System.out.println("Test failed");
        }
    }
}
