package edu.soccer.app.repository;

import edu.soccer.app.dao.entity.IndividualStatistics;
import edu.soccer.app.dao.entity.clubs;
import edu.soccer.app.dao.entity.players;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class BestplayersRepository {

    private final DataSource dataSource;

    public BestplayersRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<players> findAll() throws SQLException {
        List<players> players = new ArrayList<>();

        String sql = "SELECT p.id, p.name, p.number, p.position, p.nationality, p.age, p.playing_time_seconds, " +
                "c.id AS club_id, c.name AS club_name, c.acronym, c.year_of_creation, c.stadium, c.coach, c.nationality AS club_nationality, " +
                "p.goals, p.assists, p.yellow_cards " +
                "FROM Player p " +
                "LEFT JOIN Club c ON p.club_id = c.id";

        try (Connection connection = dataSource.getConnection();
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                String id = rs.getString("id");
                String name = rs.getString("name");
                int number = rs.getInt("number");
                String position = rs.getString("position");
                String nationality = rs.getString("nationality");
                int age = rs.getInt("age");
                int playingTimeSeconds = rs.getInt("playing_time_seconds");

                // Lecture des données club
                clubs club = null;
                String clubName = rs.getString("club_name");
                if (clubName != null) {
                    int clubId = rs.getInt("club_id");
                    club = new clubs(
                            clubId,
                            clubName,
                            rs.getString("acronym"),
                            rs.getInt("year_of_creation"),
                            rs.getString("stadium"),
                            rs.getString("coach"),
                            rs.getString("club_nationality")
                    );
                }

                IndividualStatistics stats = new IndividualStatistics();
                stats.updateGoals(rs.getInt("goals"));
                stats.updateAssists(rs.getInt("assists"));
                stats.updateYellowCards(rs.getInt("yellow_cards"));
                stats.updatePlayingTime(playingTimeSeconds);

                players player = new players(id, name, number, age, position, nationality, playingTimeSeconds, club);
                player.setIndividualStatistics(stats);

                players.add(player);
            }
        }

        return players;
    }

    public players getBestPlayer() throws SQLException {
        List<players> players = findAll();
        players bestPlayer = null;
        int maxGoals = -1;
        for (players p : players) {
            int goals = p.getIndividualStatistics() != null ? p.getIndividualStatistics().getGoals() : 0;
            if (goals > maxGoals) {
                maxGoals = goals;
                bestPlayer = p;
            }
        }
        return bestPlayer;
    }
}
