package edu.soccer.app.repository;

import edu.soccer.app.dao.entity.Team;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TeamRepository {
    private final Connection connection;

    public TeamRepository(Connection connection) {
        this.connection = connection;
    }

    public List<Team> findAll() throws SQLException {
        List<Team> teams = new ArrayList<>();
        String sql = "SELECT * FROM teams";
        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Team team = new Team(rs.getString("name"), rs.getString("acronym"),
                        rs.getInt("yearFounded"), rs.getString("stadium"));
                teams.add(team);
            }
        }
        return teams;
    }

    public void save(Team team) throws SQLException {
        String sql = "INSERT INTO teams (name, acronym, yearFounded, stadium) VALUES (?, ?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, team.getName());
            pstmt.setString(2, team.getAcronym());
            pstmt.setInt(3, team.getYearFounded());
            pstmt.setString(4, team.getStadium());
            pstmt.executeUpdate();
        }
    }

    public void update(Team team) throws SQLException {
        String sql = "UPDATE teams SET acronym = ?, yearFounded = ?, stadium = ? WHERE name = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, team.getAcronym());
            pstmt.setInt(2, team.getYearFounded());
            pstmt.setString(3, team.getStadium());
            pstmt.setString(4, team.getName());
            pstmt.executeUpdate();
        }
    }

    public void delete(String name) throws SQLException {
        String sql = "DELETE FROM teams WHERE name = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.executeUpdate();
        }
    }
}