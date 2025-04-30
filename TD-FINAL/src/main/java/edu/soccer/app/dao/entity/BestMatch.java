package edu.soccer.app.dao.entity;

import java.util.List;

public class BestMatch {
    public static Match bestMatch(List<Match> matches) {
        if (matches == null || matches.isEmpty()) {
            return null;
        }
        Match best = matches.get(0);
        int maxDifference = Math.abs(best.getHomeScore() - best.getAwayScore());

        for (Match match : matches) {
            int diff = Math.abs(match.getHomeScore() - match.getAwayScore());
            if (diff > maxDifference) {
                maxDifference = diff;
                best = match;
            }
        }
        return best;
    }
}

