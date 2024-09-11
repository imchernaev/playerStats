package org.example.Util;


import org.example.Entity.RecordE;

import java.util.*;

public class PlayerStatsCalculator {

    public static Map<Integer, List<PlayerPairStats>> calculatePlayerTogetherStats(List<RecordE> records) {
        Map<Integer, Integer> maxOverlapMap = new HashMap<>();
        Map<Integer, List<PlayerPairStats>> maxOverlapPairsMap = new HashMap<>();

        for (RecordE recordA : records) {
            for (RecordE recordB : records) {
                if (recordA.getMatchId() == recordB.getMatchId() && recordA.getPlayerId() != recordB.getPlayerId()) {
                    int overlapMinutes = PlayerOverlapCalculator.calculateOverlap(recordA, recordB);
                    if (overlapMinutes > 0) {
                        int matchId = recordA.getMatchId();
                        if (!maxOverlapMap.containsKey(matchId) || overlapMinutes > maxOverlapMap.get(matchId)) {
                            maxOverlapMap.put(matchId, overlapMinutes);
                            maxOverlapPairsMap.put(matchId, new ArrayList<>());
                        }
                        if (overlapMinutes == maxOverlapMap.get(matchId)) {
                            maxOverlapPairsMap.get(matchId).add(new PlayerPairStats(overlapMinutes, recordA.getPlayerId(), recordB.getPlayerId()));
                        }
                    }
                }
            }
        }

        return maxOverlapPairsMap;
    }
}
