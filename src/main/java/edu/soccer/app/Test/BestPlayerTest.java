package edu.soccer.app.Test;

import edu.soccer.app.dao.entity.Team;
import edu.soccer.app.dao.operations.BestTeamCrudOperations;
import edu.soccer.app.dao.operations.BestTeamCrudOperationsImpl;

public class BestPlayerTest {
    public static void main(String[] args) {
        Team real = new Team("Real Madrid FC");
        real.setPoints(10);

        Team barca = new Team("FC Barcelone");
        barca.setPoints(12);


        BestTeamCrudOperations teamService = new BestTeamCrudOperationsImpl();


        teamService.addTeam(real);
        teamService.addTeam(barca);

        Team updatedReal = new Team("Real Madrid FC");
        updatedReal.setPoints(15);
        teamService.updateTeam(updatedReal);

        for (Team team : teamService.findAll()) {
            System.out.println(team.getName() + " - Points: " + team.getPoints());
        }
    }
}
