package edu.soccer.app.Test;

import edu.soccer.app.dao.entity.clubs;
import edu.soccer.app.dao.operations.BestclubsCrudOperations;
import edu.soccer.app.dao.operations.BestclubsCrudOperationsImpl;

public class playersTest {
    public static void main(String[] args) {
        clubs real = new clubs("Real Madrid FC");
        real.setPoints(10);

        clubs barca = new clubs("FC Barcelone");
        barca.setPoints(12);


        BestclubsCrudOperations teamService = new BestclubsCrudOperationsImpl();


        teamService.addTeam(real);
        teamService.addTeam(barca);

        clubs updatedReal = new clubs("Real Madrid FC");
        updatedReal.setPoints(15);
        teamService.updateTeam(updatedReal);

        for (clubs team : teamService.findAll()) {
            System.out.println(team.getName() + " - Points: " + team.getPoints());
        }
    }
}
