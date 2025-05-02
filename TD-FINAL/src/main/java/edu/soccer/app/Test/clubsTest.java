package edu.soccer.app.Test;

import edu.soccer.app.dao.entity.clubs;
import edu.soccer.app.dao.operations.BestclubsCrudOperations;
import edu.soccer.app.dao.operations.BestclubsCrudOperationsImpl;

import java.util.List;

public class clubsTest {
    public static void main(String[] args) {
        clubs real = new clubs("Real Madrid FC");
        real.setPoints(10);

        clubs barca = new clubs("FC Barcelona");
        barca.setPoints(12);

        BestclubsCrudOperations teamService = new BestclubsCrudOperationsImpl();

        teamService.addTeam(real);
        teamService.addTeam(barca);

        System.out.println("Teams:");
        List<clubs> teams = teamService.findAll();
        for (clubs t : teams) {
            System.out.println("Name: " + t.getName() + ", Points: " + t.getPoints());
        }

        real.setPoints(15);
        teamService.updateTeam(real);

        System.out.println("After updating Real Madrid points:");
        clubs updatedReal = teamService.getTeamByName("Real Madrid FC");
        if (updatedReal != null) {
            System.out.println("Name: " + updatedReal.getName() + ", Points: " + updatedReal.getPoints());
        } else {
            System.out.println("Real Madrid FC not found.");
        }

        teamService.deleteTeam("FC Barcelona");

        System.out.println("Teams after deleting Barcelona:");
        teams = teamService.findAll();
        for (clubs t : teams) {
            System.out.println("Name: " + t.getName() + ", Points: " + t.getPoints());
        }

        clubs best = teamService.getBestTeam();
        System.out.println("Best team:");
        if (best != null) {
            System.out.println("Name: " + best.getName() + ", Points: " + best.getPoints());
        } else {
            System.out.println("No teams available.");
        }
    }
}
