package edu.soccer.app.dao.ControllerCentral;

import edu.soccer.app.dao.EntityCentral.Club;
import edu.soccer.app.dao.ServiceCentral.ClubServiceCentral;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/clubs")
public class ClubControllers {

    private ClubServiceCentral clubService;

    public void ClubController(ClubServiceCentral clubService) {
        this.clubService = clubService;
    }

    public ClubControllers(ClubServiceCentral clubService) {
        this.clubService = clubService;
    }

    @GetMapping
    public ResponseEntity<List<Club>> getAllClubs() {
        try {
            List<Club> clubs = clubService.getAllClubs();
            return ResponseEntity.ok(clubs);
        } catch (SQLException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }

    @PostMapping
    public ResponseEntity<String> addClub(@RequestBody Club club) {
        try {
            clubService.addClub(club);
            return ResponseEntity.ok("Club ajouté avec succès !");
        } catch (SQLException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erreur lors de l'ajout du club : " + e.getMessage());
        }
    }
}
