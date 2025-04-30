package edu.soccer.app.Test;

import edu.soccer.app.dao.entity.Team;
import edu.soccer.app.dao.operations.BestTeamCrudOperations;

public class BestPlayerTest{
    public static void main(String[] args) {
        Team real = new Team("Real Madrid FC", "RMA", 1902, "Santiago Bernabeu");
        real.setPoints(10);

        Team barca = new Team("FC Barcelone", "FCB", 1899, "Lluís Companys");
        barca.setPoints(12);

        BestTeamCrudOperations.addTeam(real);
        BestTeamCrudOperations.addTeam(barca);

        Team updatedReal = new Team("Real Madrid FC", "RMA", 1902, "Santiago Bernabeu");
        updatedReal.setPoints(15);
        BestTeamCrudOperations.updateTeam(updatedReal);


        for (Team team : BestTeamCrudOperations.findAll()) {
            System.out.println(team.getName() + " - Points: " + team.getPoints());
        }
    }
}
