package org.example.Service;

import org.example.Entity.Team;
import org.example.Repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamService {

    @Autowired
    private TeamRepository teamRepository;


    public Team saveTeam(Team team) {
        return teamRepository.save(team);
    }


    public List<Team> getAllTeams() {
        return teamRepository.findAll();
    }


    public Team getTeamById(int teamId) {
        return teamRepository.findById(teamId).orElse(null);
    }


    public void deleteTeam(int teamId) {
        teamRepository.deleteById(teamId);

    }
}
