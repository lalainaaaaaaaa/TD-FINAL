package edu.soccer.app.dao.entity;

import java.util.List;

public class BestTeam {
    public static Team bestTeam(List<Team> teams) {
        if (teams == null || teams.isEmpty()) {
            return null;
        }

        Team best = teams.get(0);
        int maxPoints = best.getStatistics().getPoints();

        for (Team team : teams) {
            int points = team.getStatistics().getPoints();
            if (points > maxPoints) {
                maxPoints = points;
                best = team;
            }
        }
        return best;
    }
}