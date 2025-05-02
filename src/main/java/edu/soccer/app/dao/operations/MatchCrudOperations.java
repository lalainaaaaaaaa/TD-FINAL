package edu.soccer.app.dao.operations;

import edu.soccer.app.dao.entity.Match;
import edu.soccer.app.dao.entity.Team;

import java.util.List;

public interface MatchCrudOperations {
    void addMatch(Match match);

    List<Match> findAll();

    Match findMatch(Team homeTeam, Team awayTeam);

    void updateMatch(Match updatedMatch);

    void deleteMatch(Team homeTeam, Team awayTeam);
}