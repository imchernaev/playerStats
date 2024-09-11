package org.example.Util;


public class PlayerPairStats {
    private int overlapMinutes;
    private int playerAId;
    private int playerBId;

    public PlayerPairStats(int overlapMinutes, int playerAId, int playerBId) {
        this.overlapMinutes = overlapMinutes;
        this.playerAId = playerAId;
        this.playerBId = playerBId;
    }

    public PlayerPairStats() {
    }

    ;

    public int getOverlapMinutes() {
        return overlapMinutes;
    }

    public void setOverlapMinutes(int overlapMinutes) {
        this.overlapMinutes = overlapMinutes;
    }

    public int getPlayerAId() {
        return playerAId;
    }

    public void setPlayerAId(int playerAId) {
        this.playerAId = playerAId;
    }

    public int getPlayerBId() {
        return playerBId;
    }

    public void setPlayerBId(int playerBId) {
        this.playerBId = playerBId;
    }
}
