package edu.soccer.app.dao.service;

import edu.soccer.app.dao.entity.*;

import java.util.List;
import java.util.stream.Collectors;

public class championshipsService {

    private List<players> players;
    private List<season> seasons;

    public championshipsService(List<players> players, List<season> seasons) {
        this.players = players;
        this.seasons = seasons;
    }

    public List<players> getPlayers(String clubAcronym, String nameFilter) {
        return players.stream()
                .filter(p -> clubAcronym == null || (p.getClub() != null && clubAcronym.equalsIgnoreCase(p.getClub().getAcronym())))
                .filter(p -> nameFilter == null || p.getName().toLowerCase().contains(nameFilter.toLowerCase()))
                .collect(Collectors.toList());
    }

    public IndividualStatistics getPlayerStatisticsBySeason(String playerId, int seasonYear) {
        season season = seasons.stream()
                .filter(s -> s.getYear() == seasonYear)
                .findFirst()
                .orElse(null);

        if (season == null) throw new IllegalArgumentException("Saison non trouvée");

        IndividualStatistics totalStats = new IndividualStatistics();

        for (matches match : season.getMatches()) {
            IndividualStatistics matchStats = match.getPlayerStatistics(playerId);
            if (matchStats != null) {
                totalStats.updateGoals(matchStats.getGoals());
                totalStats.updatePlayingTime(matchStats.getPlayingTimeSeconds());
            }
        }
        return totalStats;
    }

    public void generateMatchesForSeason(int year) {
        season season = seasons.stream()
                .filter(s -> s.getYear() == year)
                .findFirst()
                .orElse(null);
        if (season == null) throw new IllegalArgumentException("Season not found");
        season.generateMatches();
    }
}
