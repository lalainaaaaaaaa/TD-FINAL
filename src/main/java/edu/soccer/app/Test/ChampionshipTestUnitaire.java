package edu.soccer.app.TestCentral;

import edu.soccer.app.dao.EntityCentral.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

class ChampionshipTestUnitaire
{

    @Test
    void testChampionshipDataSettersAndGetters() {
        Championship championship1 = new Championship(1, "Ligue 1", "France");
        Championship championship2 = new Championship(2, "Serie A", "Italy");

        Club club1 = new Club(1, "Club 1", "Paris", 1);
        Club club2 = new Club(2, "Club 2", "Lyon", 1);
        Club club3 = new Club(3, "Club 3", "Milan", 2);

        Player player1 = new Player(1, "Gardien 1", 30, "GOAL_KEEPER", 0, 1);
        Player player2 = new Player(2, "Attaquant 1", 17, "STRIKER", 5, 1);
        Player player3 = new Player(3, "Milieu 1", 24, "MIDFIELDER", 2, 2);

        Match match1 = new Match(1, 2024, 1, 2, 4, 1, "2024-05-01");
        Match match2 = new Match(2, 2024, 2, 3, 0, 1, "2024-05-02");

        Season season2024 = new Season(2024, "2024", 1);

        ChampionshipData championshipData = new ChampionshipData();

        championshipData.setChampionships(List.of(championship1, championship2));
        championshipData.setClubs(List.of(club1, club2, club3));
        championshipData.setPlayers(List.of(player1, player2, player3));
        championshipData.setMatches(List.of(match1, match2));
        championshipData.setSeasons(List.of(season2024));

        // Vérifications

        // Championships
        List<Championship> championships = championshipData.getChampionships();
        assertNotNull(championships);
        assertEquals(2, championships.size());
        assertEquals("Ligue 1", championships.get(0).getName());
        assertEquals("Italy", championships.get(1).getCountry());

        // Clubs
        List<Club> clubs = championshipData.getClubs();
        assertNotNull(clubs);
        assertEquals(3, clubs.size());
        assertEquals("Paris", clubs.get(0).getCity());
        assertEquals(1, clubs.get(0).getChampionshipId());
        assertEquals("Milan", clubs.get(2).getCity());

        // Players
        List<Player> players = championshipData.getPlayers();
        assertNotNull(players);
        assertEquals(3, players.size());
        assertEquals("Gardien 1", players.get(0).getName());
        assertEquals("STRIKER", players.get(1).getPosition());
        assertEquals(2, players.get(2).getClubId());

        // Matches
        List<Match> matches = championshipData.getMatches();
        assertNotNull(matches);
        assertEquals(2, matches.size());
        assertEquals(4, matches.get(0).getHomeGoals());
        assertEquals("2024-05-02", matches.get(1).getMatchDate());

        // Seasons
        List<Season> seasons = championshipData.getSeasons();
        assertNotNull(seasons);
        assertEquals(1, seasons.size());
        assertEquals("2024", seasons.get(0).getYear());
    }
}
