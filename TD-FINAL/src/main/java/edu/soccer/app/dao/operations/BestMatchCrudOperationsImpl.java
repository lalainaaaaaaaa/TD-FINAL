package edu.soccer.app.dao.operations;

import edu.soccer.app.dao.entity.BestMatch;
import edu.soccer.app.dao.entity.Match;
import java.util.ArrayList;
import java.util.List;

public class BestMatchCrudOperationsImpl implements BestMatchCrudOperations {
    private static List<Match> matches = new ArrayList<>();

    @Override
    public void addMatch(Match match) {
        matches.add(match);
    }

    @Override
    public Match getMatchByTeams(String homeTeamName, String awayTeamName) {
        for (Match match : matches) {
            if (match.getHomeTeam().getName().equalsIgnoreCase(homeTeamName)
                    && match.getAwayTeam().getName().equalsIgnoreCase(awayTeamName)) {
                return match;
            }
        }
        return null;
    }

    @Override
    public void updateMatchScore(String homeTeamName, String awayTeamName, int homeScore, int awayScore) {
        Match existingMatch = getMatchByTeams(homeTeamName, awayTeamName);
        if (existingMatch != null) {
            existingMatch.play(homeScore, awayScore);
        }
    }

    @Override
    public void deleteMatch(String homeTeamName, String awayTeamName) {
        matches.removeIf(match ->
                match.getHomeTeam().getName().equalsIgnoreCase(homeTeamName)
                        && match.getAwayTeam().getName().equalsIgnoreCase(awayTeamName)
        );
    }

    @Override
    public Match getBestMatch() {
        return BestMatch.bestMatch(matches);
    }

    @Override
    public List<Match> findAll() {
        return new ArrayList<>(matches);
    }
}
