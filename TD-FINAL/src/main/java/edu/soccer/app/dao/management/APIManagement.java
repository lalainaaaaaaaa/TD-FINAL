package edu.soccer.app.dao.management;

import edu.soccer.app.dao.entity.Match;
import edu.soccer.app.dao.entity.Championship;

import java.util.ArrayList;
import java.util.List;

public class APIManagement {
    private final List<Match> matchStatistics;

    public APIManagement() {
        this.matchStatistics = new ArrayList<>();
    }

    public String recordMatchStatistics(Match match) {
        matchStatistics.add(match);
        return "Match statistics recorded: " + match.getHomeTeam().getName() +
                " vs " + match.getAwayTeam().getName();
    }

    public List<Match> retrieveMatchStatistics() {
        return matchStatistics;
    }

    public String retrieveChampionshipStatistics(Championship championship) {
        StringBuilder stats = new StringBuilder("Retrieving statistics for championship: " + championship.getName() + ". ");
        for (var team : championship.getTeams()) {
            var statsData = team.getStatistics();
            stats.append("Team: ").append(team.getName()).append(", Points: ").append(statsData.getPoints()).append(". ");
        }
        return stats.toString();
    }
}