package org.example.Contoller;

import jakarta.validation.Valid;
import org.example.Entity.Match;
import org.example.Repository.MatchRepository;
import org.example.Service.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/matches")
public class MatchController {

    @Autowired
    private MatchRepository matchRepository;

    @Autowired
    private MatchService matchService;


    @PostMapping
    public Match saveMatch(@Valid @RequestBody Match match) {
        return matchService.saveMatch(match);
    }


    @GetMapping
    public List<Match> getAllMatches() {
        return matchService.getAllMatches();
    }


    @GetMapping("/{id}")
    public Match getMatchById(@Valid @PathVariable int id) {
        return matchService.getMatchById(id);
    }


    @DeleteMapping("/{id}")
    public void deleteMatch(@Valid @PathVariable int id) {
        matchService.deleteMatch(id);
    }

    // update match as whole at one instance
    @PutMapping("/{id}")
    public Match updateMatch(@PathVariable int id, @Valid @RequestBody Match updatedMatch) {
        return matchRepository.findById(id).map(match -> {
            match.setTeamAId(updatedMatch.getTeamAId());
            match.setTeamBId(updatedMatch.getTeamBId());
            match.setDate(updatedMatch.getDate());
            match.setScore(updatedMatch.getScore());
            return matchRepository.save(match);
        }).orElse(null);
    }

    @PutMapping("/{id}/teamAId")
    public Match updateMatchTeamAId(@PathVariable int id, @Valid @RequestParam int teamAId) {
        return matchRepository.findById(id).map(match -> {
            match.setTeamAId(teamAId);
            return matchRepository.save(match);
        }).orElse(null);
    }


    @PutMapping("/{id}/teamBId")
    public Match updateMatchTeamBId(@PathVariable int id,@Valid @RequestParam int teamBId) {
        return matchRepository.findById(id).map(match -> {
            match.setTeamBId(teamBId);
            return matchRepository.save(match);
        }).orElse(null);
    }


    @PutMapping("/{id}/date")
    public Match updateMatchDate(@PathVariable int id,@Valid @RequestParam LocalDate date) {
        return matchRepository.findById(id).map(match -> {
            match.setDate(date);
            return matchRepository.save(match);
        }).orElse(null);
    }


    @PutMapping("/{id}/score")
    public Match updateMatchScore(@PathVariable int id, @Valid @RequestParam String score) {
        return matchRepository.findById(id).map(match -> {
            match.setScore(score);
            return matchRepository.save(match);
        }).orElse(null);
    }
}
