package edu.soccer.app.TestCentral;

import edu.soccer.app.dao.EntityCentral.Season;

public class SeasonTest {

    public static void main(String[] args) {
        Season season = new Season();

        season.setId(2024);
        season.setYear("2024");
        season.setChampionshipId(1);


        System.out.println("Season ID: " + season.getId());
        System.out.println("Season Year: " + season.getYear());
        System.out.println("Championship ID: " + season.getChampionshipId());


        if (season.getId() == 2024 &&
                "2024".equals(season.getYear()) &&
                season.getChampionshipId() == 1) {
            System.out.println("Test passed!");
        } else {
            System.out.println("Test failed!");
        }
    }
}
