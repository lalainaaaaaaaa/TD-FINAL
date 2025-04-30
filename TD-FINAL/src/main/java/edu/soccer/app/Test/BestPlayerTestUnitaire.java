package edu.soccer.app.Test;

import edu.soccer.app.dao.entity.Player;
import edu.soccer.app.dao.entity.IndividualStatistics;
import edu.soccer.app.dao.operations.BestPlayerCrudOperations;

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

        BestPlayerCrudOperations.addPlayer(vinicius);
        BestPlayerCrudOperations.addPlayer(mbappe);
        BestPlayerCrudOperations.addPlayer(lamine);

        List<Player> players = BestPlayerCrudOperations.findAll();
        System.out.println("List of players:");
        for (Player player : players) {
            System.out.println(player.getName() + " - Goals: " + player.getIndividualStatistics().getGoals());
        }

        Player best = BestPlayerCrudOperations.getBestPlayer();
        System.out.println("Best player: " + best.getName());
        if (best != null && best.getName().equals("Kylian Mbappé")) {
            System.out.println("✅ Best player check: OK");
        } else {
            System.out.println("❌ Best player check: FAILED");
        }

        vinicius.getIndividualStatistics().setGoals(25);
        BestPlayerCrudOperations.updatePlayer(vinicius);

        Player bestAfterUpdate = BestPlayerCrudOperations.getBestPlayer();
        System.out.println("Best player after update: " + bestAfterUpdate.getName());
        if (bestAfterUpdate != null && bestAfterUpdate.getName().equals("Vinicius Jr")) {
            System.out.println("✅ Update & best player: OK");
        } else {
            System.out.println("❌ Update & best player: FAILED");
        }

        BestPlayerCrudOperations.deletePlayer("Kylian Mbappé");
        Player found = BestPlayerCrudOperations.getPlayerByName("Kylian Mbappé");
        if (found == null) {
            System.out.println("✅ Delete player: OK");
        } else {
            System.out.println("❌ Delete player: FAILED");
        }
    }
}
