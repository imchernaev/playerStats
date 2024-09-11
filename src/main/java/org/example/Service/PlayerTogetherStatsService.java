package org.example.Service;


import org.example.Entity.*;
import org.example.Repository.RecordERepository;
import org.example.Util.PlayerPairStats;
import org.example.Repository.*;
import org.example.Util.PlayerStatsCalculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Map;


@Service
public class PlayerTogetherStatsService {


    @Autowired
    private PlayerTogetherStatsRepository statsRepository;

    @Autowired
    private RecordERepository recordRepository;


    private void savePlayerTogetherStats(int overlapMinutes, int playerAId, int playerBId, int matchId) {
        PlayerTogetherStats stats = new PlayerTogetherStats();
        stats.setPlayerAId(playerAId);
        stats.setPlayerBId(playerBId);
        stats.setMinutesPlayedTogether(overlapMinutes);
        stats.setMatchID(matchId);
        statsRepository.save(stats);
    }

    public void calculatePlayerTogetherStats() {
        List<RecordE> records = recordRepository.findAll();
        Map<Integer, List<PlayerPairStats>> maxOverlapPairsMap = PlayerStatsCalculator.calculatePlayerTogetherStats(records);

        for (Map.Entry<Integer, List<PlayerPairStats>> entry : maxOverlapPairsMap.entrySet()) {
            int matchId = entry.getKey();
            for (PlayerPairStats stats : entry.getValue()) {
                savePlayerTogetherStats(stats.getOverlapMinutes(), stats.getPlayerAId(), stats.getPlayerBId(), matchId);
            }
        }
    }

}

