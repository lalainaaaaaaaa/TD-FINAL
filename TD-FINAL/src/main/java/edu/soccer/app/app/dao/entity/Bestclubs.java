package edu.soccer.app.dao.entity;

import java.util.List;

public class Bestclubs {
    public static clubs bestTeam(List<clubs> teams) {
        if (teams == null || teams.isEmpty()) {
            return null;
        }

        clubs best = teams.get(0);
        int maxPoints = best.getStatistics().getPoints();

        for (clubs team : teams) {
            int points = team.getStatistics().getPoints();
            if (points > maxPoints) {
                maxPoints = points;
                best = team;
            }
        }
        return best;
    }
}