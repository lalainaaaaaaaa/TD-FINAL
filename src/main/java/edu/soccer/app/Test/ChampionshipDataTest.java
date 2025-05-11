package edu.soccer.app.TestCentral;

import edu.soccer.app.dao.EntityCentral.*;
import java.util.List;


public class ChampionshipDataTest {
    public static void main(String[] args) {

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


        System.out.println("Championships:");
        championshipData.getChampionships().forEach(c -> System.out.println("- " + c.getName() + " (" + c.getCountry() + ")"));

        System.out.println("Clubs:");
        championshipData.getClubs().forEach(c -> System.out.println("- " + c.getName() + " in " + c.getCity()));

        System.out.println("Players:");
        championshipData.getPlayers().forEach(p -> System.out.println("- " + p.getName() + ", position: " + p.getPosition() + ", clubId: " + p.getClubId()));

        System.out.println("Matches:");
        championshipData.getMatches().forEach(m -> System.out.println("- Match " + m.getId() + ": " + m.getClubHomeId() + " vs " + m.getClubAwayId() + " on " + m.getMatchDate()));

        System.out.println("Seasons:");
        championshipData.getSeasons().forEach(s -> System.out.println("- Season " + s.getYear()));
    }
}
