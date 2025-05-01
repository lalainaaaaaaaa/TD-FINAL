package edu.soccer.app.Test;

import edu.soccer.app.dao.entity.Team;
import edu.soccer.app.dao.operations.BestTeamCrudOperations;
import edu.soccer.app.dao.operations.BestTeamCrudOperationsImpl;

import java.util.List;

public class BestTeamTest {
    public static void main(String[] args) {
        Team real = new Team("Real Madrid FC");
        real.setPoints(10);

        Team barca = new Team("FC Barcelona");
        barca.setPoints(12);

        BestTeamCrudOperations teamService = new BestTeamCrudOperationsImpl();

        teamService.addTeam(real);
        teamService.addTeam(barca);

        System.out.println("Teams:");
        List<Team> teams = teamService.findAll();
        for (Team t : teams) {
            System.out.println("Name: " + t.getName() + ", Points: " + t.getPoints());
        }

        real.setPoints(15);
        teamService.updateTeam(real);

        System.out.println("After updating Real Madrid points:");
        Team updatedReal = teamService.getTeamByName("Real Madrid FC");
        if (updatedReal != null) {
            System.out.println("Name: " + updatedReal.getName() + ", Points: " + updatedReal.getPoints());
        } else {
            System.out.println("Real Madrid FC not found.");
        }

        teamService.deleteTeam("FC Barcelona");

        System.out.println("Teams after deleting Barcelona:");
        teams = teamService.findAll();
        for (Team t : teams) {
            System.out.println("Name: " + t.getName() + ", Points: " + t.getPoints());
        }

        Team best = teamService.getBestTeam();
        System.out.println("Best team:");
        if (best != null) {
            System.out.println("Name: " + best.getName() + ", Points: " + best.getPoints());
        } else {
            System.out.println("No teams available.");
        }
    }
}
