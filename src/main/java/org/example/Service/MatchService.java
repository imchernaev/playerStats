package org.example.Service;

import org.example.Entity.Match;
import org.example.Repository.MatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatchService {

    @Autowired
    private MatchRepository matchRepository;


    public Match saveMatch(Match match) {
        return matchRepository.save(match);
    }


    public List<Match> getAllMatches() {
        return matchRepository.findAll();
    }


    public Match getMatchById(int matchId) {
        return matchRepository.findById(matchId).orElse(null);
    }


    public void deleteMatch(int matchId) {
        matchRepository.deleteById(matchId);
    }
}
