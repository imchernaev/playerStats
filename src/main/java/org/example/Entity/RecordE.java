package org.example.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;


@Entity

@Table(name = "records")
public class RecordE {

    @Id
    private int id; // id comes from csv file no need to be auto_increment/generated

    @NotNull
    @Column(name = "player_id",nullable = false)
    private int playerId;

    @NotNull
    @Column(name = "match_id",nullable = false)
    private int matchId;

    @NotNull
    @Column(name = "from_minutes",nullable = false)
    private int fromMinutes;

    @Column(name = "to_minutes")
    private Integer toMinutes;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @NotNull
    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(@NotNull int playerId) {
        this.playerId = playerId;
    }

    @NotNull
    public int getMatchId() {
        return matchId;
    }

    public void setMatchId(@NotNull int matchId) {
        this.matchId = matchId;
    }

    @NotNull
    public int getFromMinutes() {
        return fromMinutes;
    }

    public void setFromMinutes(@NotNull int fromMinutes) {
        this.fromMinutes = fromMinutes;
    }

    public Integer getToMinutes() {
        return toMinutes;
    }

    public void setToMinutes(Integer toMinutes) {
        this.toMinutes = toMinutes;
    }


    // Getters and setters
}
