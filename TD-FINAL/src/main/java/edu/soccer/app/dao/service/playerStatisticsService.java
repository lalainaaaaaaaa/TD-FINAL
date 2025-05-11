package edu.soccer.app.dao.service;

import edu.soccer.app.dao.entity.IndividualStatistics;
import edu.soccer.app.dao.entity.matches;
import edu.soccer.app.dao.entity.players;
import edu.soccer.app.dao.entity.season;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class playerStatisticsService {

    public IndividualStatistics calculateTotalStatistics(players player, season season) {
        List<matches> matchesOfSeason = season.getMatches();
        IndividualStatistics totalStats = new IndividualStatistics();

        for (matches match : matchesOfSeason) {
            IndividualStatistics matchStats = match.getPlayerStatistics(player.getId());
            if (matchStats != null) {
                totalStats.updateGoals(matchStats.getGoals());
                totalStats.updatePlayingTime(matchStats.getPlayingTimeSeconds());
            }
        }

        return totalStats;
    }
}
