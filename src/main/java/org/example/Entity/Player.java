package org.example.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


@Entity

@Table(name = "players")
public class Player {
    @Id
    private int id; // id comes from csv file no need to be auto_increment/generated

    @NotBlank
    @Column(name = "full_name", nullable = false)
    private String fullName;

    @NotBlank
    @Column(name = "position", nullable = false)
    private String position;

    @NotNull
    @Column(name = "team_number", nullable = false)
    private int teamNumber;

    @NotNull
    @Column(name = "team_id", nullable = false)
    private int teamId;

    public Player(int id, String fullName, String position, int teamNumber, int teamId) {
        this.id = id;
        this.fullName = fullName;
        this.position = position;
        this.teamNumber = teamNumber;
        this.teamId = teamId;
    }

    public Player() {
    }

    ;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public @NotBlank String getFullName() {
        return fullName;
    }

    public void setFullName(@NotBlank String fullName) {
        this.fullName = fullName;
    }

    public @NotBlank String getPosition() {
        return position;
    }

    public void setPosition(@NotBlank String position) {
        this.position = position;
    }

    @NotNull
    public int getTeamNumber() {
        return teamNumber;
    }

    public void setTeamNumber(@NotNull int teamNumber) {
        this.teamNumber = teamNumber;
    }

    @NotNull
    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(@NotNull int teamId) {
        this.teamId = teamId;
    }


}
