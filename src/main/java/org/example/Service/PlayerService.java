package org.example.Service;

import org.example.Entity.Player;
import org.example.Repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepository playerRepository;


    public Player savePlayer(Player player) {
        return playerRepository.save(player);
    }


    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }


    public Player getPlayerById(int playerId) {
        return playerRepository.findById(playerId).orElse(null);
    }


    public void deletePlayer(int playerId) {
        playerRepository.deleteById(playerId);
    }
}
