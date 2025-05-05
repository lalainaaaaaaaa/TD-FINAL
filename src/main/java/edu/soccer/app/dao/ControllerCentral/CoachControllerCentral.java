package edu.soccer.app.dao.ControllerCentral;

import edu.soccer.app.dao.EntityCentral.Coach;
import edu.soccer.app.dao.ServiceCentral.CoachServiceCentral;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RestController
@RequestMapping("/coaches")
public class CoachControllerCentral {

    private CoachServiceCentral coachService;

    public void CoachController(CoachServiceCentral coachService) {
        this.coachService = coachService;
    }

    public CoachControllerCentral(CoachServiceCentral coachService) {
        this.coachService = coachService;
    }

    @PostMapping
    public ResponseEntity<String> addCoach(@RequestBody Coach coach) {
        try {
            coachService.addCoach(coach);
            return ResponseEntity.ok("Coach ajouté avec succès !");
        } catch (SQLException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erreur lors de l'ajout du coach : " + e.getMessage());
        }
    }
}
