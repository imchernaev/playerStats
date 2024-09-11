package org.example.Contoller;

import jakarta.validation.Valid;
import org.example.Entity.Team;
import org.example.Repository.TeamRepository;
import org.example.Service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/teams")
public class TeamController {

    @Autowired
    private TeamService teamService;

    @Autowired
    private TeamRepository teamRepository;


    @PostMapping
    public Team saveTeam(@Valid @RequestBody Team team) {
        return teamService.saveTeam(team);
    }


    @GetMapping
    public List<Team> getAllTeams() {
        return teamService.getAllTeams();
    }


    @GetMapping("/{id}")
    public Team getTeamById(@Valid @PathVariable int id) {
        return teamService.getTeamById(id);
    }


    @DeleteMapping("/{id}")
    public void deleteTeam(@Valid @PathVariable int id) {
        teamService.deleteTeam(id);
    }

    //update team as a whole in one method instance
    @PutMapping("/{id}")
    public Team updateTeam(@PathVariable int id,@Valid @RequestBody Team updatedTeam) {
        return teamRepository.findById(id).map(team -> {
            team.setName(updatedTeam.getName());
            team.setManagerFullName(updatedTeam.getManagerFullName());
            team.setGroupName(updatedTeam.getGroupName());
            return teamRepository.save(team);
        }).orElse(null);
    }

    @PutMapping("/{id}/name")
    public Team updateTeamName(@PathVariable int id,@Valid @RequestParam String name) {
        return teamRepository.findById(id).map(team -> {
            team.setName(name);
            return teamRepository.save(team);
        }
        ).orElse(null);
    }


    @PutMapping("/{id}/managerFullName")
    public Team updateTeamManagerFullName(@PathVariable int id,@Valid @RequestParam String managerFullName) {
        return teamRepository.findById(id).map(team -> {
            team.setManagerFullName(managerFullName);
            return teamRepository.save(team);
        }
        ).orElse(null);
    }


    @PutMapping("/{id}/group")
    public Team updateTeamGroupName(@PathVariable int id,@Valid @RequestParam String group) {
        return teamRepository.findById(id).map(team -> {
            team.setGroupName(group);
            return teamRepository.save(team);
        }
        ).orElse(null);
    }
}
