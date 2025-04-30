package edu.soccer.app.Test;

import edu.soccer.app.dao.entity.Team;
import edu.soccer.app.dao.operations.BestTeamCrudOperations;

import java.util.List;

public class BestTeamTestUnitaire {

    public static void main(String[] args) {
        Team real = new Team("Real Madrid FC", "RMA", 1902, "Santiago Bernabeu");
        real.setPoints(10);

        Team barca = new Team("FC Barcelone", "FCB", 1899, "Lluís Companys");
        barca.setPoints(12);

        BestTeamCrudOperations.addTeam(real);
        BestTeamCrudOperations.addTeam(barca);

        List<Team> teams = BestTeamCrudOperations.findAll();
        System.out.println("Teams after add:");
        teams.forEach(System.out::println);
        if (teams.size() == 2 && teams.contains(real) && teams.contains(barca)) {
            System.out.println("Add and findAll: OK");
        } else {
            System.out.println("Add and findAll: FAILED");
        }

        Team updatedReal = new Team("Real Madrid FC", "RMA", 1902, "Santiago Bernabeu");
        updatedReal.setPoints(15);
        BestTeamCrudOperations.updateTeam(updatedReal);

        Team foundReal = BestTeamCrudOperations.getTeamByName("Real Madrid FC");
        System.out.println("Updated Real: " + foundReal);
        if (foundReal != null && foundReal.getPoints() == 15) {
            System.out.println("Update team: OK");
        } else {
            System.out.println(" Update team: FAILED");
        }

        BestTeamCrudOperations.deleteTeam("FC Barcelone");
        teams = BestTeamCrudOperations.findAll();
        boolean barcaDeleted = true;
        for (Team t : teams) {
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

        Team best = BestTeamCrudOperations.getBestTeam();
        System.out.println("Best team: " + best);
        if (best != null && best.getName().equals("Real Madrid FC")) {
            System.out.println("Best team check: OK");
        } else {
            System.out.println("Best team check: FAILED");
        }
    }
}
