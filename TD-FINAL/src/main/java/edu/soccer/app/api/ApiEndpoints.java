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

    // Récupérer tous les joueurs avec filtrage
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
                        // Si le paramètre club n'est pas un nombre valide, on exclut le joueur
                        return false;
                    }
                })
                .filter(player -> name == null || (player.getName() != null && player.getName().contains(name)))
                .filter(player -> ageMin == null || player.getAge() >= ageMin)
                .filter(player -> ageMax == null || player.getAge() <= ageMax)
                .collect(Collectors.toList());
    }

    // Ajouter un nouveau joueur
    @PostMapping("/players")
    public players addPlayer(@RequestBody players player) {
        playersList.add(player);
        return player;
    }

    // Mettre à jour un joueur
    @PutMapping("/players/{id}")
    public players updatePlayer(@PathVariable String id, @RequestBody players updatedPlayer) {
        int playerId;
        try {
            playerId = Integer.parseInt(id);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid player id: " + id);
        }
        playersList.removeIf(p -> p.getId() == playerId);
        playersList.add(updatedPlayer);
        return updatedPlayer;
    }

    // Récupérer toutes les saisons
    @GetMapping("/seasons")
    public List<season> getAllSeasons() {
        return seasonsList;
    }

    // Ajouter une nouvelle saison
    @PostMapping("/seasons")
    public season addSeason(@RequestBody season season) {
        seasonsList.add(season);
        return season;
    }

    // Mettre à jour le statut d'une saison
    @PutMapping("/seasons/{seasonYear}/status")
    public String updateSeasonStatus(@PathVariable int seasonYear, @RequestBody String status) {
        return "Season " + seasonYear + " status updated to " + status;
    }

    // Récupérer les statistiques d'un joueur pour une saison donnée
    @GetMapping("/players/{id}/statistics/{seasonYear}")
    public IndividualStatistics getPlayerStatistics(@PathVariable String id, @PathVariable int seasonYear) {
        return new IndividualStatistics();
    }

    // Récupérer tous les clubs
    @GetMapping("/clubs")
    public List<clubs> getAllClubs() {
        return clubsList;
    }

    // Mettre à jour un club
    @PutMapping("/clubs")
    public clubs updateClub(@RequestBody clubs club) {
        return club;
    }

    // Récupérer tous les joueurs d'un club
    @GetMapping("/clubs/{id}/players")
    public List<players> getPlayersByClub(@PathVariable String id) {
        int clubId;
        try {
            clubId = Integer.parseInt(id);
        } catch (NumberFormatException e) {
            return new ArrayList<>(); // id invalide, retourne liste vide
        }
        return playersList.stream()
                .filter(player -> player.getClub() != null && player.getClub().getId() == clubId)
                .collect(Collectors.toList());
    }

    // Mettre à jour les joueurs d'un club
    @PutMapping("/clubs/{id}/players")
    public String updateClubPlayers(@PathVariable String id, @RequestBody List<String> playerIds) {
        return "Club " + id + " players updated.";
    }

    // Ajouter un joueur à un club
    @PostMapping("/clubs/{id}/players")
    public String addPlayerToClub(@PathVariable String id, @RequestBody String playerId) {
        return "Player " + playerId + " added to club " + id;
    }

    // Générer des matches pour une saison donnée
    @PostMapping("/matchMaker/{seasonYear}")
    public String generateMatches(@PathVariable int seasonYear) {
        return "Matches generated for season " + seasonYear;
    }

    // Récupérer tous les matches d'une saison
    @GetMapping("/matches/{seasonYear}")
    public List<matches> getMatchesBySeason(@PathVariable int seasonYear) {
        return new ArrayList<>();
    }

    // Mettre à jour le statut d'un match
    @PutMapping("/matches/{id}/status")
    public String updateMatchStatus(@PathVariable String id, @RequestBody String status) {
        return "Match " + id + " status updated to " + status;
    }

    // Mettre à jour les buts d'un match
    @PostMapping("/matches/{id}/goals")
    public String updateMatchGoals(@PathVariable String id, @RequestBody String goals) {
        return "Goals for match " + id + " updated to " + goals;
    }

    // Récupérer les statistiques d'un club pour une saison donnée
    @GetMapping("/clubs/statistics/{seasonYear}")
    public CollectiveStatistics getClubStatistics(@PathVariable int seasonYear) {
        return new CollectiveStatistics();
    }
}
