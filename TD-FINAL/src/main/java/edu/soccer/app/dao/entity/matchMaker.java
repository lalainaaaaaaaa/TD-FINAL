package edu.soccer.app.dao.entity;

import java.util.List;

public class matchMaker {
    public static matches bestMatch(List<matches> matches) {
        if (matches == null || matches.isEmpty()) {
            return null;
        }
        matches best = matches.get(0);
        int maxDifference = Math.abs(best.getHomeScore() - best.getAwayScore());

        for (matches match : matches) {
            int diff = Math.abs(match.getHomeScore() - match.getAwayScore());
            if (diff > maxDifference) {
                maxDifference = diff;
                best = match;
            }
        }
        return best;
    }
}