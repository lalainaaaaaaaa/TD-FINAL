package edu.soccer.app.dao.operations;

import edu.soccer.app.dao.entity.Season;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SeasonCrudOperations {
    private static List<Season> seasons = new ArrayList<>();

    public static void loadSeasonsFromDatabase(Connection connection) throws SQLException {
        String sql = "SELECT * FROM Season";

        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                int year = rs.getInt("year");
                String name = rs.getString("name");
                seasons.add(new Season(year));
            }
        }
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
