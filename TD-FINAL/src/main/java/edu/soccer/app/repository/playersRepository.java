package edu.soccer.app.repository;

import edu.soccer.app.dao.entity.clubs;
import edu.soccer.app.dao.entity.players;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class playersRepository {

    private final Connection connection;

    public playersRepository(Connection connection) {
        this.connection = connection;
    }

    public List<players> findAll() throws SQLException {
        List<players> playersList = new ArrayList<>();
        String sql = "SELECT p.id, p.name, p.number, p.position, p.nationality, p.age, p.playing_time_seconds, " +
                "c.id AS club_id, c.name AS club_name, c.acronym, c.yearOfCreation, c.stadium, c.coach, c.nationality AS club_nationality " +
                "FROM Player p LEFT JOIN Clubs c ON p.club_id = c.id";

        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                clubs club = null;
                int clubId = rs.getInt("club_id");
                if (!rs.wasNull()) {
                    club = new clubs(
                            clubId,
                            rs.getString("club_name"),
                            rs.getString("acronym"),
                            rs.getInt("yearOfCreation"),
                            rs.getString("stadium"),
                            rs.getString("coach"),
                            rs.getString("club_nationality")
                    );
                }


                players player = new players(
                        rs.getString("id"),
                        rs.getString("name"),
                        rs.getInt("number"),
                        rs.getInt("age"),
                        rs.getString("position"),
                        rs.getString("nationality"),
                        rs.getInt("playing_time_seconds"), club
                );

                playersList.add(player);
            }
        }
        return playersList;
    }


    public void save(players player) throws SQLException {
        if (player.getName() == null || player.getName().isEmpty()) {
            throw new IllegalArgumentException("Player name cannot be null or empty.");
        }
        String sql = "INSERT INTO Player (name, number, position, nationality, age, playing_time_seconds, club_id) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, player.getName());
            pstmt.setInt(2, player.getNumber());
            pstmt.setString(3, player.getPosition());
            pstmt.setString(4, player.getNationality());
            pstmt.setInt(5, player.getAge());
            pstmt.setInt(6, player.getPlayingTimeSeconds());
            if (player.getClub() != null) {
                pstmt.setInt(7, player.getClub().getId());
            } else {
                pstmt.setNull(7, Types.INTEGER);
            }
            pstmt.executeUpdate();
        }
    }

    public void update(players player) throws SQLException {
        String sql = "UPDATE Player SET position = ?, nationality = ?, age = ?, playing_time_seconds = ?, club_id = ? WHERE number = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, player.getPosition());
            pstmt.setString(2, player.getNationality());
            pstmt.setInt(3, player.getAge());
            pstmt.setInt(4, player.getPlayingTimeSeconds());
            if (player.getClub() != null) {
                pstmt.setInt(5, player.getClub().getId());
            } else {
                pstmt.setNull(5, Types.INTEGER);
            }
            pstmt.setInt(6, player.getNumber());
            pstmt.executeUpdate();
        }
    }

    public void delete(int number) throws SQLException {
        String sql = "DELETE FROM Player WHERE number = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, number);
            pstmt.executeUpdate();
        }
    }
}
