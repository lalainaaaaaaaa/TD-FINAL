package edu.soccer.app.dao.operations;

import edu.soccer.app.dao.entity.matches;
import java.util.List;

public interface matchMakerCrudOperations {
    void addMatch(matches match);

    matches getMatchByTeams(String homeTeamName, String awayTeamName);

    void updateMatchScore(String homeTeamName, String awayTeamName, int homeScore, int awayScore);

    void deleteMatch(String homeTeamName, String awayTeamName);

    matches getBestMatch();

    List<matches> findAll();
}
