package edu.soccer.app.dao.entity;

import java.util.List;

public class Bestplayers {
    public static players bestPlayer(List<players> players) {
        if (players == null || players.isEmpty()) return null;
        edu.soccer.app.dao.entity.players best = players.get(0);
        for (edu.soccer.app.dao.entity.players p : players) {
            if (p.getIndividualStatistics().getGoals() > best.getIndividualStatistics().getGoals()) {
                best = p;
            }
        }
        return best;
    }
}
