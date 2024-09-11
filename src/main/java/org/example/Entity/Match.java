package org.example.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;


@Entity
@Table(name = "matches")
public class Match {
    @NotNull
    @Id
    private int id; // id comes from csv file no need to be auto_increment/generated

    @NotNull
    @Column(name = "team_a_id", nullable = false)
    private int teamAId;

    @NotNull
    @Column(name = "team_b_id", nullable = false)
    private int teamBId;

    @NotNull
    @Column(name = "match_date", nullable = false)
    private LocalDate date; // data formatter/parser will handle the correct date-time-format

    @NotBlank
    @Column(name = "score", nullable = false)
    private String score;

    public Match(int id, int teamAId, int teamBId, LocalDate date, String score) {
        this.id = id;
        this.teamAId = teamAId;
        this.teamBId = teamBId;
        this.date = date;
        this.score = score;
    }

    public Match() {
    }

    @NotNull
    public int getId() {
        return id;
    }

    public void setId(@NotNull int id) {
        this.id = id;
    }

    @NotNull
    public int getTeamAId() {
        return teamAId;
    }

    public void setTeamAId(@NotNull int teamAId) {
        this.teamAId = teamAId;
    }

    @NotNull
    public int getTeamBId() {
        return teamBId;
    }

    public void setTeamBId(@NotNull int teamBId) {
        this.teamBId = teamBId;
    }

    public @NotNull LocalDate getDate() {
        return date;
    }

    public void setDate(@NotNull LocalDate date) {
        this.date = date;
    }

    public @NotBlank String getScore() {
        return score;
    }

    public void setScore(@NotBlank String score) {
        this.score = score;
    }


    // Getters and setters
}
