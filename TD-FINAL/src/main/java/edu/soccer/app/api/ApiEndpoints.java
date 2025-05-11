package edu.soccer.app.api;

import edu.soccer.app.dao.entity.CollectiveStatistics;
import edu.soccer.app.dao.entity.players;
import edu.soccer.app.dao.entity.matches;
import edu.soccer.app.dao.entity.season;
import edu.soccer.app.dao.entity.clubs;
import edu.soccer.app.dao.entity.IndividualStatistics;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class ApiEndpoints {

    private List<players> playersList = new ArrayList<>();
    private List<matches> matchesList = new ArrayList<>();
    private List<season> seasonsList = new ArrayList<>();
    private List<clubs> clubsList = new ArrayList<>();

    @GetMapping("/players")
    public List<players> getAllPlayers(@RequestParam(required = false) String club,
                                       @RequestParam(required = false) String name,
                                       @RequestParam(required = false) Integer ageMin,
                                       @RequestParam(required = false) Integer ageMax) {
        return playersList.stream()
                .filter(player -> {
                    if (club == null) return true;
                    if (player.getClub() == null) return false;
                    try {
                        int clubIdParam = Integer.parseInt(club);
                        return player.getClub().getId() == clubIdParam;
                    } catch (NumberFormatException e) {
                        return false;
                    }
                })
                .filter(player -> name == null || (player.getName() != null && player.getName().contains(name)))
                .filter(player -> ageMin == null || player.getAge() >= ageMin)
                .filter(player -> ageMax == null || player.getAge() <= ageMax)
                .collect(Collectors.toList());
    }

    @PostMapping("/players")
    public players addPlayer(@RequestBody players player) {
        playersList.add(player);
        return player;
    }

    @PutMapping("/players/{id}")
    public players updatePlayer(@PathVariable String id, @RequestBody players updatedPlayer) {
        // Retirer le joueur avec le même id (comparaison String avec equals)
        playersList.removeIf(p -> p.getId().equals(id));
        // S’assurer que l’id du joueur mis à jour est cohérent
        updatedPlayer.setId(id);
        playersList.add(updatedPlayer);
        return updatedPlayer;
    }

    @GetMapping("/seasons")
    public List<season> getAllSeasons() {
        return seasonsList;
    }

    @PostMapping("/seasons")
    public season addSeason(@RequestBody season season) {
        seasonsList.add(season);
        return season;
    }

    @PutMapping("/seasons/{seasonYear}/status")
    public String updateSeasonStatus(@PathVariable int seasonYear, @RequestBody String status) {
        return "Season " + seasonYear + " status updated to " + status;
    }

    @GetMapping("/players/{id}/statistics/{seasonYear}")
    public IndividualStatistics getPlayerStatistics(@PathVariable String id, @PathVariable int seasonYear) {
        return new IndividualStatistics();
    }

    @GetMapping("/clubs")
    public List<clubs> getAllClubs() {
        return clubsList;
    }

    @PutMapping("/clubs")
    public clubs updateClub(@RequestBody clubs club) {
        return club;
    }

    @GetMapping("/clubs/{id}/players")
    public List<players> getPlayersByClub(@PathVariable String id) {
        int clubId;
        try {
            clubId = Integer.parseInt(id);
        } catch (NumberFormatException e) {
            return new ArrayList<>(); // Retourne liste vide si id invalide
        }
        return playersList.stream()
                .filter(player -> player.getClub() != null && player.getClub().getId() == clubId)
                .collect(Collectors.toList());
    }

    @PutMapping("/clubs/{id}/players")
    public String updateClubPlayers(@PathVariable String id, @RequestBody List<String> playerIds) {
        return "Club " + id + " players updated.";
    }

    @PostMapping("/clubs/{id}/players")
    public String addPlayerToClub(@PathVariable String id, @RequestBody String playerId) {
        return "Player " + playerId + " added to club " + id;
    }

    @PostMapping("/matchMaker/{seasonYear}")
    public String generateMatches(@PathVariable int seasonYear) {
        return "Matches generated for season " + seasonYear;
    }

    @GetMapping("/matches/{seasonYear}")
    public List<matches> getMatchesBySeason(@PathVariable int seasonYear) {
        return new ArrayList<>();
    }

    @PutMapping("/matches/{id}/status")
    public String updateMatchStatus(@PathVariable String id, @RequestBody String status) {
        return "Match " + id + " status updated to " + status;
    }

    @PostMapping("/matches/{id}/goals")
    public String updateMatchGoals(@PathVariable String id, @RequestBody String goals) {
        return "Goals for match " + id + " updated to " + goals;
    }

    @GetMapping("/clubs/statistics/{seasonYear}")
    public CollectiveStatistics getClubStatistics(@PathVariable int seasonYear) {
        return new CollectiveStatistics();
    }
}
