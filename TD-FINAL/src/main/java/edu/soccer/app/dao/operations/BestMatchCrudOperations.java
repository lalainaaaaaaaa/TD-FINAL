package edu.soccer.app.dao.operations;

import edu.soccer.app.dao.entity.BestMatch;
import edu.soccer.app.dao.entity.Match;

import java.util.ArrayList;
import java.util.List;

public class BestMatchCrudOperations {

    private static List<Match> matches = new ArrayList<>();

    public static void addMatch(Match match) {
        matches.add(match);
    }

    public static Match getMatchByTeams(String homeTeamName, String awayTeamName) {
        for (Match match : matches) {
            if (match.getHomeTeam().getName().equalsIgnoreCase(homeTeamName) &&
                    match.getAwayTeam().getName().equalsIgnoreCase(awayTeamName)) {
                return match;
            }
        }
        return null;
    }

    public static void updateMatchScore(String homeTeamName, String awayTeamName, int homeScore, int awayScore) {
        Match existingMatch = getMatchByTeams(homeTeamName, awayTeamName);
        if (existingMatch != null) {
            existingMatch.play(homeScore, awayScore);
        }
    }

    public static void deleteMatch(String homeTeamName, String awayTeamName) {
        matches.removeIf(match ->
                match.getHomeTeam().getName().equalsIgnoreCase(homeTeamName) &&
                        match.getAwayTeam().getName().equalsIgnoreCase(awayTeamName)
        );
    }

    public static Match getBestMatch() {
        return BestMatch.bestMatch(matches);
    }

    public static List<Match> findAll() {
        return new ArrayList<>(matches);
    }
}