package org.example.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;




@Entity
@Table(name = "player_together_stats")
public class PlayerTogetherStats {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @Column(name = "player_a_id",nullable = false)
    private int playerAId;

    @NotNull
    @Column(name = "player_b_id",nullable = false)
    private int playerBId;

    @NotNull
    @Column(name = "minutes_played_together",nullable = false)
    private int minutesPlayedTogether;

    @NotNull
    @Column(name = "match_id",nullable = false)
    private int matchID;

    public PlayerTogetherStats(int id, int playerAId, int playerBId, int minutesPlayedTogether, int matchID) {
        this.id = id;
        this.playerAId = playerAId;
        this.playerBId = playerBId;
        this.minutesPlayedTogether = minutesPlayedTogether;
        this.matchID = matchID;
    }
    public PlayerTogetherStats(){};

    public int getId() {
        return id;
    }



    @NotNull
    public int getPlayerAId() {
        return playerAId;
    }

    public void setPlayerAId(@NotNull int playerAId) {
        this.playerAId = playerAId;
    }

    @NotNull
    public int getPlayerBId() {
        return playerBId;
    }

    public void setPlayerBId(@NotNull int playerBId) {
        this.playerBId = playerBId;
    }

    @NotNull
    public int getMinutesPlayedTogether() {
        return minutesPlayedTogether;
    }

    public void setMinutesPlayedTogether(@NotNull int minutesPlayedTogether) {
        this.minutesPlayedTogether = minutesPlayedTogether;
    }

    @NotNull
    public int getMatchID() {
        return matchID;
    }

    public void setMatchID(@NotNull int matchID) {
        this.matchID = matchID;
    }


}
