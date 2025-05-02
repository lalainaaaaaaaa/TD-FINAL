package edu.soccer.app.dao.operations;

import edu.soccer.app.dao.entity.clubs;

import java.util.ArrayList;
import java.util.List;

public class matchesCrudOperationsImpl implements matchesCrudOperations {
    private List<edu.soccer.app.dao.entity.matches> matches = new ArrayList<>();

    @Override
    public void addMatch(edu.soccer.app.dao.entity.matches match) {
        matches.add(match);
    }

    @Override
    public List<edu.soccer.app.dao.entity.matches> findAll() {
        return new ArrayList<>(matches);
    }

    @Override
    public edu.soccer.app.dao.entity.matches findMatch(clubs homeTeam, clubs awayTeam) {
        for (edu.soccer.app.dao.entity.matches match : matches) {
            if (match.getHomeTeam().equals(homeTeam) && match.getAwayTeam().equals(awayTeam)) {
                return match;
            }
        }
        return null;
    }

    @Override
    public void updateMatch(edu.soccer.app.dao.entity.matches updatedMatch) {
        edu.soccer.app.dao.entity.matches existingMatch = findMatch(updatedMatch.getHomeTeam(), updatedMatch.getAwayTeam());
        if (existingMatch != null) {
            existingMatch.play(updatedMatch.getHomeScore(), updatedMatch.getAwayScore());
        } else {
            throw new IllegalArgumentException("Match not found for the given teams.");
        }
    }

    @Override
    public void deleteMatch(clubs homeTeam, clubs awayTeam) {
        if (!matches.removeIf(match -> match.getHomeTeam().equals(homeTeam) && match.getAwayTeam().equals(awayTeam))) {
            throw new IllegalArgumentException("Match not found for the given teams.");
        }
    }
}