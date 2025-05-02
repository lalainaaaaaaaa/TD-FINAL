package edu.soccer.app.Test;

import edu.soccer.app.dao.entity.Player;
import edu.soccer.app.dao.entity.IndividualStatistics;
import edu.soccer.app.dao.operations.BestPlayerCrudOperations;
import edu.soccer.app.dao.operations.BestPlayerCrudOperationsImpl;

import java.util.List;

public class BestPlayerTestUnitaire {
    public static void main(String[] args) {

        IndividualStatistics viniciusStats = new IndividualStatistics();
        viniciusStats.updateGoals(15);

        IndividualStatistics mbappeStats = new IndividualStatistics();
        mbappeStats.updateGoals(22);

        IndividualStatistics lamineStats = new IndividualStatistics();
        lamineStats.updateGoals(10);

        Player vinicius = new Player("Vinicius Jr", "Forward", "Brazil");
        Player mbappe = new Player("Kylian Mbappé", "Forward", "France");
        Player lamine = new Player("Lamine Yamal", "Forward", "Spain");


        BestPlayerCrudOperations playerService = new BestPlayerCrudOperationsImpl();


        playerService.addPlayer(vinicius);
        playerService.addPlayer(mbappe);
        playerService.addPlayer(lamine);

        List<Player> players = playerService.findAll();
        System.out.println("List of players:");
        for (Player player : players) {
            System.out.println(player.getName() + " - Goals: " + player.getIndividualStatistics().getGoals());
        }

        Player best = playerService.getBestPlayer();
        System.out.println("Best player: " + best.getName());
        if (best != null && best.getName().equals("Kylian Mbappé")) {
            System.out.println("Best player check: OK");
        } else {
            System.out.println("Best player check: FAILED");
        }

        vinicius.getIndividualStatistics().setGoals(25);
        playerService.updatePlayer(vinicius);

        Player bestAfterUpdate = playerService.getBestPlayer();
        System.out.println("Best player after update: " + bestAfterUpdate.getName());
        if (bestAfterUpdate != null && bestAfterUpdate.getName().equals("Vinicius Jr")) {
            System.out.println("Update & best player: OK");
        } else {
            System.out.println("Update & best player: FAILED");
        }

        playerService.deletePlayer("Kylian Mbappé");
        Player found = playerService.getPlayerByName("Kylian Mbappé");
        if (found == null) {
            System.out.println("Delete player: OK");
        } else {
            System.out.println("Delete player: FAILED");
        }
    }
}
