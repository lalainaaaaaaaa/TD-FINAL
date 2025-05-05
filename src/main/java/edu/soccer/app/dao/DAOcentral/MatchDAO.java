package edu.soccer.app.dao.DAOcentral;

import edu.soccer.app.dao.EntityCentral.Match;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MatchDAO {
    private final Connection connection;

    public MatchDAO(Connection connection) {
        this.connection = connection;
    }

    public void insert(Match match) throws SQLException {
        String sql = "INSERT INTO match (home_club_id, away_club_id, home_score, away_score, match_date) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, match.getHomeClubId());
            stmt.setInt(2, match.getAwayClubId());
            stmt.setInt(3, match.getHomeScore());
            stmt.setInt(4, match.getAwayScore());
            stmt.setDate(5, Date.valueOf(match.getMatchDate()));
            stmt.executeUpdate();
        }
    }

    public List<Match> getAll() throws SQLException {
        List<Match> list = new ArrayList<>();
        String sql = "SELECT id, date, club_home_id, club_away_id, score_home, score_away, season_id FROM match";

        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Match match = new Match();
                match.setId(rs.getInt("id"));
                match.setClubHomeId(rs.getInt("club_home_id"));
                match.setClubAwayId(rs.getInt("club_away_id"));
                match.setSeasonId(rs.getInt("season_id"));
                list.add(match);
            }
        }

        return list;
    }
}

