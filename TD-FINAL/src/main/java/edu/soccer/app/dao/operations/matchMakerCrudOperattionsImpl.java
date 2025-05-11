package edu.soccer.app.dao.operations;

import edu.soccer.app.dao.entity.matches;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class matchMakerCrudOperattionsImpl implements matchMakerCrudOperations {

    private final List<matches> matchesList = new ArrayList<>();

    @Override
    public void addMatch(matches match) {
        if (match != null) {
            matchesList.add(match);
        }
    }

    @Override
    public matches getMatchByTeams(String homeTeamName, String awayTeamName) {
        if (homeTeamName == null || awayTeamName == null) return null;

        Optional<matches> match = matchesList.stream()
                .filter(m -> m.getHomeTeam().getName().equalsIgnoreCase(homeTeamName)
                        && m.getAwayTeam().getName().equalsIgnoreCase(awayTeamName))
                .findFirst();

        return match.orElse(null);
    }

    @Override
    public void updateMatchScore(String homeTeamName, String awayTeamName, int homeScore, int awayScore) {
        matches match = getMatchByTeams(homeTeamName, awayTeamName);
        if (match != null) {
            match.setHomeScore(homeScore);
            match.setAwayScore(awayScore);
            match.setStatus("FINISHED");
        }
    }

    @Override
    public void deleteMatch(String homeTeamName, String awayTeamName) {
        matchesList.removeIf(m -> m.getHomeTeam().getName().equalsIgnoreCase(homeTeamName)
                && m.getAwayTeam().getName().equalsIgnoreCase(awayTeamName));
    }

    @Override
    public matches getBestMatch() {
        if (matchesList.isEmpty()) return null;

        matches bestMatch = matchesList.get(0);
        int maxDifference = Math.abs(bestMatch.getHomeScore() - bestMatch.getAwayScore());

        for (matches m : matchesList) {
            int diff = Math.abs(m.getHomeScore() - m.getAwayScore());
            if (diff > maxDifference) {
                maxDifference = diff;
                bestMatch = m;
            }
        }
        return bestMatch;
    }

    @Override
    public List<matches> findAll() {
        return new ArrayList<>(matchesList);
    }
}
