package org.example.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;


@Entity

@Table(name = "teams")
public class Team {
    @Id
    private int id; // No @GeneratedValue

    @NotBlank
    @Column(name = "name", nullable = false)
    private String name;

    @NotBlank
    @Column(name = "manager_full_name", nullable = false)
    private String managerFullName;

    @NotBlank
    @Column(name = "group_name", nullable = false)
    private String groupName;

    public Team(int id, String name, String managerFullName, String groupName) {
        this.id = id;
        this.name = name;
        this.managerFullName = managerFullName;
        this.groupName = groupName;
    }

    public Team() {
    }

    ;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public @NotBlank String getName() {
        return name;
    }

    public void setName(@NotBlank String name) {
        this.name = name;
    }

    public @NotBlank String getManagerFullName() {
        return managerFullName;
    }

    public void setManagerFullName(@NotBlank String managerFullName) {
        this.managerFullName = managerFullName;
    }

    public @NotBlank String getGroupName() {
        return groupName;
    }

    public void setGroupName(@NotBlank String groupName) {
        this.groupName = groupName;
    }


    // Getters and setters
}
