package edu.soccer.app.TestCentral;

import edu.soccer.app.dao.EntityCentral.Club;

public class ClubTest {

    public static void main(String[] args) {
        Club club = new Club();

        club.setId(4);
        club.setName("Club 4");
        club.setCity("City 4");
        club.setChampionshipId(1);


        System.out.println("Club ID: " + club.getId());
        System.out.println("Club Name: " + club.getName());
        System.out.println("Club City: " + club.getCity());
        System.out.println("Championship ID: " + club.getChampionshipId());


        if (club.getId() == 4 &&
                "Club 4".equals(club.getName()) &&
                "City 4".equals(club.getCity()) &&
                club.getChampionshipId() == 1) {
            System.out.println("Test passed!");
        } else {
            System.out.println("Test failed!");
        }
    }
}
