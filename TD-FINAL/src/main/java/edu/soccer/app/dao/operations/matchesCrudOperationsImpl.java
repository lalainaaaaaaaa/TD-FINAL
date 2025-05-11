package edu.soccer.app.dao.operations;

import edu.soccer.app.dao.entity.matches;
import edu.soccer.app.dao.entity.clubs;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class matchesCrudOperationsImpl implements matchesCrudOperations {

    private final List<matches> matchesList = new ArrayList<>();

    @Override
    public void addMatch(matches match) {
        if (match != null) {
            matchesList.add(match);
        }
    }

    @Override
    public List<matches> findAll() {
        return new ArrayList<>(matchesList);
    }

    @Override
    public matches findMatch(clubs homeTeam, clubs awayTeam) {
        if (homeTeam == null || awayTeam == null) {
            return null;
        }
        Optional<matches> match = matchesList.stream()
                .filter(m -> m.getHomeTeam().equals(homeTeam) && m.getAwayTeam().equals(awayTeam))
                .findFirst();
        return match.orElse(null);
    }

    @Override
    public void updateMatch(matches updatedMatch) {
        if (updatedMatch == null) return;
        for (int i = 0; i < matchesList.size(); i++) {
            matches current = matchesList.get(i);
            if (current.getHomeTeam().equals(updatedMatch.getHomeTeam()) &&
                    current.getAwayTeam().equals(updatedMatch.getAwayTeam())) {
                matchesList.set(i, updatedMatch);
                return;
            }
        }
    }

    @Override
    public void deleteMatch(clubs homeTeam, clubs awayTeam) {
        if (homeTeam == null || awayTeam == null) return;
        matchesList.removeIf(m -> m.getHomeTeam().equals(homeTeam) && m.getAwayTeam().equals(awayTeam));
    }
}
