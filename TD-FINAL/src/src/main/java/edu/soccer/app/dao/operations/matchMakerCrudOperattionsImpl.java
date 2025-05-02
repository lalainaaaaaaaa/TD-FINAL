package edu.soccer.app.dao.operations;

import edu.soccer.app.dao.entity.matchMaker;

import java.util.ArrayList;
import java.util.List;

public class matchMakerCrudOperattionsImpl implements matchMakerCrudOperations {
    private static List<edu.soccer.app.dao.entity.matches> matches = new ArrayList<>();

    @Override
    public void addMatch(edu.soccer.app.dao.entity.matches match) {
        matches.add(match);
    }

    @Override
    public edu.soccer.app.dao.entity.matches getMatchByTeams(String homeTeamName, String awayTeamName) {
        for (edu.soccer.app.dao.entity.matches match : matches) {
            if (match.getHomeTeam().getName().equalsIgnoreCase(homeTeamName)
                    && match.getAwayTeam().getName().equalsIgnoreCase(awayTeamName)) {
                return match;
            }
        }
        return null;
    }

    @Override
    public void updateMatchScore(String homeTeamName, String awayTeamName, int homeScore, int awayScore) {
        edu.soccer.app.dao.entity.matches existingMatch = getMatchByTeams(homeTeamName, awayTeamName);
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
    public edu.soccer.app.dao.entity.matches getBestMatch() {
        return matchMaker.bestMatch(matches);
    }

    @Override
    public List<edu.soccer.app.dao.entity.matches> findAll() {
        return new ArrayList<>(matches);
    }
}
