package edu.soccer.app.dao.DAOcentral;

import edu.soccer.app.dao.EntityCentral.Coach;

import java.sql.*;



public class CoachDAO {
    private final Connection connection;

    public CoachDAO(Connection connection) {
        this.connection = connection;
    }

    public void insert(Coach coach) throws SQLException {
        String sql = "INSERT INTO coach (name, nationality, club_id) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, coach.getName());
            stmt.setInt(2, coach.getClubId());
            stmt.executeUpdate();
        }
    }


}
