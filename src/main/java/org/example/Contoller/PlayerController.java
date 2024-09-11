package org.example.Contoller;

import jakarta.validation.Valid;
import org.example.Entity.Player;
import org.example.Repository.PlayerRepository;
import org.example.Service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/players")
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @Autowired
    private PlayerRepository playerRepository;


    @PostMapping
    public Player savePlayer(@Valid @RequestBody Player player) {
        return playerService.savePlayer(player);
    }


    @GetMapping
    public List<Player> getAllPlayers() {
        return playerService.getAllPlayers();
    }


    @GetMapping("/{id}")
    public Player getPlayerById(@PathVariable int id) {
        return playerService.getPlayerById(id);
    }


    @DeleteMapping("/{id}")
    public void deletePlayer(@PathVariable int id) {
        playerService.deletePlayer(id);
    }

    // update as a whole in one instance
    @PutMapping("/{id}")
    public Player updatePlayer(@PathVariable int id, @Valid @RequestBody Player updatedPlayer) {
        return playerRepository.findById(id).map(player -> {
            player.setFullName(updatedPlayer.getFullName());
            player.setTeamNumber(updatedPlayer.getTeamNumber());
            player.setPosition(updatedPlayer.getPosition());
            player.setTeamId(updatedPlayer.getTeamId());
            return playerRepository.save(player);
        }).orElse(null);
    }

    @PutMapping("/{id}/fullName")
    public Player updatePlayerFullName(@PathVariable int id, @Valid @RequestParam String fullName) {
        return playerRepository.findById(id).map(player -> {
            player.setFullName(fullName);
            return playerRepository.save(player);
        }).orElse(null);
    }


    @PutMapping("/{id}/teamNumber")
    public Player updatePlayerTeamNumber(@PathVariable int id, @Valid @RequestParam int teamNumber) {
        return playerRepository.findById(id).map(player -> {
            player.setTeamNumber(teamNumber);
            return playerRepository.save(player);
        }
        ).orElse(null);
    }


    @PutMapping("/{id}/position")
    public Player updatePlayerPosition(@PathVariable int id,@Valid @RequestParam String position) {
        return playerRepository.findById(id).map(player -> {
            player.setPosition(position);
            return playerRepository.save(player);
        }
        ).orElse(null);
    }


    @PutMapping("/{id}/teamId")
    public Player updatePlayerTeamId(@PathVariable int id,@Valid @RequestParam int teamId) {
        return playerRepository.findById(id).map(player -> {
            player.setTeamId(teamId);
            return playerRepository.save(player);
        }
        ).orElse(null);
    }
}
