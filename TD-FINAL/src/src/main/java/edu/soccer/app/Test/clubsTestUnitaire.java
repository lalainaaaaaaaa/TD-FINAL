package edu.soccer.app.Test;

import edu.soccer.app.dao.entity.clubs;
import edu.soccer.app.dao.operations.BestclubsCrudOperations;
import edu.soccer.app.dao.operations.BestclubsCrudOperationsImpl;

import java.util.List;

public class clubsTestUnitaire {

    public static void main(String[] args) {
        clubs real = new clubs("Real Madrid FC");
        real.setPoints(10);

        clubs barca = new clubs("FC Barcelone");
        barca.setPoints(12);


        BestclubsCrudOperations teamService = new BestclubsCrudOperationsImpl();

        teamService.addTeam(real);
        teamService.addTeam(barca);

        List<clubs> teams = teamService.findAll();
        System.out.println("Teams after add:");
        teams.forEach(System.out::println);
        if (teams.size() == 2 && teams.contains(real) && teams.contains(barca)) {
            System.out.println("Add and findAll: OK");
        } else {
            System.out.println("Add and findAll: FAILED");
        }

        clubs updatedReal = new clubs("Real Madrid FC");
        updatedReal.setPoints(15);
        teamService.updateTeam(updatedReal);

        clubs foundReal = teamService.getTeamByName("Real Madrid FC");
        System.out.println("Updated Real: " + foundReal);
        if (foundReal != null && foundReal.getPoints() == 15) {
            System.out.println("Update team: OK");
        } else {
            System.out.println("Update team: FAILED");
        }

        teamService.deleteTeam("FC Barcelone");
        teams = teamService.findAll();
        boolean barcaDeleted = true;
        for (clubs t : teams) {
            if (t.getName().equals("FC Barcelone")) {
                barcaDeleted = false;
                break;
            }
        }
        System.out.println("Teams after delete:");
        teams.forEach(System.out::println);
        if (barcaDeleted) {
            System.out.println("Delete team: OK");
        } else {
            System.out.println("Delete team: FAILED");
        }

        clubs best = teamService.getBestTeam();
        System.out.println("Best team: " + best);
        if (best != null && best.getName().equals("Real Madrid FC")) {
            System.out.println("Best team check: OK");
        } else {
            System.out.println("Best team check: FAILED");
        }
    }
}
