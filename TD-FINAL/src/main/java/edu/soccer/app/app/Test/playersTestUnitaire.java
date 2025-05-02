package edu.soccer.app.Test;

import edu.soccer.app.dao.entity.players;
import edu.soccer.app.dao.entity.IndividualStatistics;
import edu.soccer.app.dao.operations.BestplayersCrudOperations;
import edu.soccer.app.dao.operations.BestplayersCrudOperationsImpl;

import java.util.List;

public class playersTestUnitaire {
    public static void main(String[] args) {

        IndividualStatistics viniciusStats = new IndividualStatistics();
        viniciusStats.updateGoals(15);

        IndividualStatistics mbappeStats = new IndividualStatistics();
        mbappeStats.updateGoals(22);

        IndividualStatistics lamineStats = new IndividualStatistics();
        lamineStats.updateGoals(10);

        players vinicius = new players("Vinicius Jr", "Forward", "Brazil");
        players mbappe = new players("Kylian Mbappé", "Forward", "France");
        players lamine = new players("Lamine Yamal", "Forward", "Spain");


        BestplayersCrudOperations playerService = new BestplayersCrudOperationsImpl();


        playerService.addPlayer(vinicius);
        playerService.addPlayer(mbappe);
        playerService.addPlayer(lamine);

        List<players> players = playerService.findAll();
        System.out.println("List of players:");
        for (edu.soccer.app.dao.entity.players player : players) {
            System.out.println(player.getName() + " - Goals: " + player.getIndividualStatistics().getGoals());
        }

        edu.soccer.app.dao.entity.players best = playerService.getBestPlayer();
        System.out.println("Best player: " + best.getName());
        if (best != null && best.getName().equals("Kylian Mbappé")) {
            System.out.println("Best player check: OK");
        } else {
            System.out.println("Best player check: FAILED");
        }

        vinicius.getIndividualStatistics().setGoals(25);
        playerService.updatePlayer(vinicius);

        edu.soccer.app.dao.entity.players bestAfterUpdate = playerService.getBestPlayer();
        System.out.println("Best player after update: " + bestAfterUpdate.getName());
        if (bestAfterUpdate != null && bestAfterUpdate.getName().equals("Vinicius Jr")) {
            System.out.println("Update & best player: OK");
        } else {
            System.out.println("Update & best player: FAILED");
        }

        playerService.deletePlayer("Kylian Mbappé");
        edu.soccer.app.dao.entity.players found = playerService.getPlayerByName("Kylian Mbappé");
        if (found == null) {
            System.out.println("Delete player: OK");
        } else {
            System.out.println("Delete player: FAILED");
        }
    }
}
