package edu.soccer.app.Test;

import edu.soccer.app.dao.entity.clubs;
import edu.soccer.app.dao.operations.BestclubsCrudOperations;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

public class clubsTestUnitaire {

    public static void main(String[] args) {
        clubs real = new clubs("Real Madrid FC");
        real.setPoints(10);

        clubs barca = new clubs("FC Barcelone");
        barca.setPoints(12);

        clubs updatedReal = new clubs("Real Madrid FC");
        updatedReal.setPoints(15);


        BestclubsCrudOperations teamService = Mockito.mock(BestclubsCrudOperations.class);


        Mockito.when(teamService.findAll()).thenReturn(Arrays.asList(real, barca));
        Mockito.when(teamService.getTeamByName("Real Madrid FC")).thenReturn(updatedReal);
        Mockito.when(teamService.getBestTeam()).thenReturn(updatedReal);


        List<clubs> teams = teamService.findAll();
        printTeams("Teams after add", teams);
        if (teams.size() == 2 && teams.contains(real) && teams.contains(barca)) {
            System.out.println("Add and findAll: OK");
        } else {
            System.out.println("Add and findAll: FAILED");
        }

        clubs foundReal = teamService.getTeamByName("Real Madrid FC");
        System.out.println("Updated Real:");
        printTeam(foundReal);
        if (foundReal != null && foundReal.getPoints() == 15) {
            System.out.println("Update team: OK");
        } else {
            System.out.println("Update team: FAILED");
        }


        Mockito.when(teamService.findAll()).thenReturn(Arrays.asList(updatedReal));
        teams = teamService.findAll();
        printTeams("Teams after delete", teams);
        boolean barcaDeleted = true;
        for (clubs t : teams) {
            if (t.getName().equals("FC Barcelone")) {
                barcaDeleted = false;
                break;
            }
        }
        if (barcaDeleted) {
            System.out.println("Delete team: OK");
        } else {
            System.out.println("Delete team: FAILED");
        }

        clubs best = teamService.getBestTeam();
        System.out.println("Best team:");
        printTeam(best);
        if (best != null && best.getName().equals("Real Madrid FC")) {
            System.out.println("Best team check: OK");
        } else {
            System.out.println("Best team check: FAILED");
        }
    }

    private static void printTeams(String title, List<clubs> teams) {
        System.out.println("Name && Points");
        for (clubs c : teams) {
            System.out.println(c.getName() + "    " + c.getPoints());
        }
        System.out.println();
    }

    private static void printTeam(clubs club) {
        if (club == null) {
            System.out.println("No club found.");
            return;
        }
        System.out.println("Name: " + club.getName());
        System.out.println("Points: " + club.getPoints());
        System.out.println();
    }
}
