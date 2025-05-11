package edu.soccer.app.TestCentral;

import edu.soccer.app.dao.EntityCentral.Coach;

public class CoachTest {

    public static void main(String[] args) {
        Coach coach = new Coach();


        coach.setId(1);
        coach.setName("Coach 1");
        coach.setAge(45);
        coach.setClubId(4);


        System.out.println("Coach ID: " + coach.getId());
        System.out.println("Coach Name: " + coach.getName());
        System.out.println("Coach Age: " + coach.getAge());
        System.out.println("Coach Club ID: " + coach.getClubId());

        if (coach.getId() == 1 &&
                "Coach 1".equals(coach.getName()) &&
                coach.getAge() == 45 &&
                coach.getClubId() == 4) {
            System.out.println("Test passed!");
        } else {
            System.out.println("Test failed!");
        }
    }
}
