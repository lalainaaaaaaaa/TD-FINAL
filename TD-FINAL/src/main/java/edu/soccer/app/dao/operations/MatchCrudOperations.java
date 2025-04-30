package edu.soccer.app.dao.operations;

import edu.soccer.app.dao.entity.Match;
import edu.soccer.app.dao.entity.Team;

import java.util.ArrayList;
import java.util.List;

public class MatchCrudOperations {
    private static List<Match> matches = new ArrayList<>();

    public static void addMatch(Match match) {
        matches.add(match);
    }

    public static List<Match> findAll() {
        return new ArrayList<>(matches);
    }

    public static Match findMatch(Team homeTeam, Team awayTeam) {
        for (Match match : matches) {
            if (match.getHomeTeam().equals(homeTeam) && match.getAwayTeam().equals(awayTeam)) {
                return match;
            }
        }
        return null;
    }

    public static void updateMatch(Match updatedMatch) {
        Match existingMatch = findMatch(updatedMatch.getHomeTeam(), updatedMatch.getAwayTeam());
        if (existingMatch != null) {
            existingMatch.play(updatedMatch.getHomeScore(), updatedMatch.getAwayScore());
        }
    }

    public static void deleteMatch(Team homeTeam, Team awayTeam) {
        matches.removeIf(match -> match.getHomeTeam().equals(homeTeam) && match.getAwayTeam().equals(awayTeam));
    }
}