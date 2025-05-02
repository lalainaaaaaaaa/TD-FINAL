package edu.soccer.app.dao.operations;

import edu.soccer.app.dao.entity.matches;
import edu.soccer.app.dao.entity.clubs;

import java.util.List;

public interface matchesCrudOperations {
    void addMatch(matches match);

    List<matches> findAll();

    matches findMatch(clubs homeTeam, clubs awayTeam);

    void updateMatch(matches updatedMatch);

    void deleteMatch(clubs homeTeam, clubs awayTeam);
}