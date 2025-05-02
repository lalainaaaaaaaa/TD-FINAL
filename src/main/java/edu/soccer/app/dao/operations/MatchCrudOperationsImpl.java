package edu.soccer.app.dao.operations;

import edu.soccer.app.dao.entity.Match;
import edu.soccer.app.dao.entity.Team;

import java.util.ArrayList;
import java.util.List;

public class MatchCrudOperationsImpl implements MatchCrudOperations {
    private List<Match> matches = new ArrayList<>();

    @Override
    public void addMatch(Match match) {
        matches.add(match);
    }

    @Override
    public List<Match> findAll() {
        return new ArrayList<>(matches);
    }

    @Override
    public Match findMatch(Team homeTeam, Team awayTeam) {
        for (Match match : matches) {
            if (match.getHomeTeam().equals(homeTeam) && match.getAwayTeam().equals(awayTeam)) {
                return match;
            }
        }
        return null;
    }

    @Override
    public void updateMatch(Match updatedMatch) {
        Match existingMatch = findMatch(updatedMatch.getHomeTeam(), updatedMatch.getAwayTeam());
        if (existingMatch != null) {
            existingMatch.play(updatedMatch.getHomeScore(), updatedMatch.getAwayScore());
        } else {
            throw new IllegalArgumentException("Match not found for the given teams.");
        }
    }

    @Override
    public void deleteMatch(Team homeTeam, Team awayTeam) {
        if (!matches.removeIf(match -> match.getHomeTeam().equals(homeTeam) && match.getAwayTeam().equals(awayTeam))) {
            throw new IllegalArgumentException("Match not found for the given teams.");
        }
    }
}