package edu.soccer.app.dao.entity;

import java.util.List;

public class Bestclubs {

    public static clubs bestTeam(List<clubs> teams) {
        if (teams == null || teams.isEmpty()) {
            return null;
        }

        clubs bestTeam = teams.get(0);
        int maxPoints = bestTeam.getStatistics().getPoints();

        for (clubs team : teams) {
            int points = team.getStatistics().getPoints();
            if (points > maxPoints) {
                maxPoints = points;
                bestTeam = team;
            }
        }

        return bestTeam;
    }
}
