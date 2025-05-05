package edu.soccer.app.Test;

import edu.soccer.app.dao.entity.players;
import edu.soccer.app.dao.entity.IndividualStatistics;
import edu.soccer.app.dao.operations.BestplayersCrudOperations;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

public class playersTestUnitaire {

    public static void main(String[] args) {
        IndividualStatistics viniciusStats = new IndividualStatistics();
        viniciusStats.updateGoals(15);

        IndividualStatistics mbappeStats = new IndividualStatistics();
        mbappeStats.updateGoals(22);

        IndividualStatistics lamineStats = new IndividualStatistics();
        lamineStats.updateGoals(10);


        players vinicius = new players("Vinicius Jr", 1, "Forward", "Brazil", 100);
        vinicius.setIndividualStatistics(viniciusStats);

        players mbappe = new players("Kylian Mbappé", 2, "Forward", "France", 90);
        mbappe.setIndividualStatistics(mbappeStats);

        players lamine = new players("Lamine Yamal", 3, "Forward", "Spain", 80);
        lamine.setIndividualStatistics(lamineStats);


        BestplayersCrudOperations playerService = Mockito.mock(BestplayersCrudOperations.class);


        Mockito.when(playerService.findAll()).thenReturn(Arrays.asList(vinicius, mbappe, lamine));
        Mockito.when(playerService.getPlayerByName("Kylian Mbappé")).thenReturn(mbappe);
        Mockito.when(playerService.getBestPlayer()).thenReturn(mbappe);


        players viniciusUpdated = new players("Vinicius Jr", 1, "Forward", "Brazil", 100);
        IndividualStatistics viniciusStatsUpdated = new IndividualStatistics();
        viniciusStatsUpdated.updateGoals(25);
        viniciusUpdated.setIndividualStatistics(viniciusStatsUpdated);

        Mockito.when(playerService.getBestPlayer()).thenReturn(viniciusUpdated);


        Mockito.when(playerService.getPlayerByName("Kylian Mbappé")).thenReturn(null);
        Mockito.when(playerService.findAll()).thenReturn(Arrays.asList(viniciusUpdated, lamine));



        List<players> playersList = playerService.findAll();
        System.out.println("List of players:");
        for (players player : playersList) {
            IndividualStatistics stats = player.getIndividualStatistics();
            if (stats != null) {
                System.out.println(player.getName() + " - Goals: " + stats.getGoals());
            } else {
                System.out.println(player.getName() + " - No statistics available");
            }
        }


        players best = playerService.getBestPlayer();
        System.out.println("Best player: " + (best != null ? best.getName() : "None"));
        if (best != null && !best.getName().isEmpty()) {
            System.out.println("Best player check: OK");
        } else {
            System.out.println("Best player check: FAILED");
        }


        players bestAfterUpdate = playerService.getBestPlayer();
        System.out.println("Best player after update: " + (bestAfterUpdate != null ? bestAfterUpdate.getName() : "None"));
        if (bestAfterUpdate != null && !bestAfterUpdate.getName().isEmpty()) {
            System.out.println("Update & best player: OK");
        } else {
            System.out.println("Update & best player: FAILED");
        }

        playerService.deletePlayer("Kylian Mbappé");

        players found = playerService.getPlayerByName("Kylian Mbappé");
        if (found == null) {
            System.out.println("Delete player: OK");
        } else {
            System.out.println("Delete player: FAILED");
        }
    }
}
