package edu.soccer.app.dao.operations;

import edu.soccer.app.dao.entity.BestMatch;
import edu.soccer.app.dao.entity.Match;
import java.util.List;

public interface BestMatchCrudOperations {
    void addMatch(Match match);

    Match getMatchByTeams(String homeTeamName, String awayTeamName);

    void updateMatchScore(String homeTeamName, String awayTeamName, int homeScore, int awayScore);

    void deleteMatch(String homeTeamName, String awayTeamName);

    Match getBestMatch();

    List<Match> findAll();
}
