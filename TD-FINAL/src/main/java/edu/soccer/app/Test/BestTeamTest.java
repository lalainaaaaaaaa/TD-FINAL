package edu.soccer.app.Test;

import edu.soccer.app.dao.entity.Team;
import edu.soccer.app.dao.operations.BestTeamCrudOperations;

import java.util.List;

public class BestTeamTest {
    public static void main(String[] args) {

        Team real = new Team("Real Madrid FC", "RMA", 1902, "Santiago Bernabeu");
        real.setPoints(10);

        Team barca = new Team("FC Barcelona", "FCB", 1899, "Lluís Companys");
        barca.setPoints(12);

        BestTeamCrudOperations.addTeam(real);
        BestTeamCrudOperations.addTeam(barca);


        System.out.println("Teams:");
        List<Team> teams = BestTeamCrudOperations.findAll();
        for (Team t : teams) {
            System.out.println(t);
        }


        real.setPoints(15);
        BestTeamCrudOperations.updateTeam(real);


        System.out.println("After updating Real Madrid points:");
        System.out.println(BestTeamCrudOperations.getTeamByName("Real Madrid FC"));


        BestTeamCrudOperations.deleteTeam("FC Barcelona");


        System.out.println("Teams after deleting Barcelona:");
        teams = BestTeamCrudOperations.findAll();
        for (Team t : teams) {
            System.out.println(t);
        }


        Team best = BestTeamCrudOperations.getBestTeam();
        System.out.println("Best team: " + best);
    }
}
