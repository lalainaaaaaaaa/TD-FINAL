package edu.soccer.app.dao.entity;

import java.util.List;

public class BestPlayer {
    public static Player bestPlayer(List<Player> players) {
        if (players == null || players.isEmpty()) return null;
        Player best = players.get(0);
        for (Player p : players) {
            if (p.getIndividualStatistics().getGoals() > best.getIndividualStatistics().getGoals()) {
                best = p;
            }
        }
        return best;
    }
}
