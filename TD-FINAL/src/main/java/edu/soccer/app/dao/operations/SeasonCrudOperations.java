package edu.soccer.app.dao.operations;

import edu.soccer.app.dao.entity.Season;

import java.util.ArrayList;
import java.util.List;

public class SeasonCrudOperations {
    private static List<Season> seasons = new ArrayList<>();

    static {
        seasons.add(new Season(2021));
        seasons.add(new Season(2022));
        seasons.add(new Season(2023));
    }

    public static Season getSeasonByYear(int year) {
        for (Season season : seasons) {
            if (season.getYear() == year) {
                return season;
            }
        }
        return null;
    }

    public static List<Season> findAll() {
        return new ArrayList<>(seasons);
    }

    public static void addSeason(Season season) {
        seasons.add(season);
    }

    public static void updateSeason(Season updatedSeason) {
        Season existingSeason = getSeasonByYear(updatedSeason.getYear());
        if (existingSeason != null) {
            existingSeason.getMatches().clear();
            existingSeason.getMatches().addAll(updatedSeason.getMatches());
        }
    }

    public static void deleteSeason(int year) {
        seasons.removeIf(season -> season.getYear() == year);
    }
}