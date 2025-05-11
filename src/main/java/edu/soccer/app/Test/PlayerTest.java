package edu.soccer.app.TestCentral;

import edu.soccer.app.dao.EntityCentral.*;

import java.util.Arrays;

public class PlayerTest{
    public static void main(String[] args) {

        Championship championship = new Championship(1, "Ligue 1", "France");
        System.out.println("Championship: " + championship.getName() + ", Country: " + championship.getCountry());


        Club club = new Club(4, "Club 4", "City 4", 1);
        System.out.println("Club: " + club.getName() + ", City: " + club.getCity());


        Coach coach = new Coach(1, "Coach 1", 45, 4);
        System.out.println("Coach: " + coach.getName() + ", Age: " + coach.getAge());


        Match match = new Match(1, 2024, 4, 5, 4, 1, "2024-05-01");
        System.out.println("Match: HomeClubId=" + match.getClubHomeId() + ", AwayClubId=" + match.getClubAwayId() + ", Date=" + match.getMatchDate());


        Player player = new Player(7, "Attaquant 4", 17, "STRIKER", 5, 4);
        System.out.println("Player: " + player.getName() + ", Position: " + player.getPosition() + ", Goals: " + player.getGoals());


        Season season = new Season(2024, "2024", 1);
        System.out.println("Season: " + season.getYear());


        ChampionshipData data = new ChampionshipData();
        data.setChampionships(Arrays.asList(championship));
        data.setClubs(Arrays.asList(club));
        data.setMatches(Arrays.asList(match));
        data.setPlayers(Arrays.asList(player));
        data.setSeasons(Arrays.asList(season));
        System.out.println("ChampionshipData contains " + data.getPlayers().size() + " player(s).");
    }
}
