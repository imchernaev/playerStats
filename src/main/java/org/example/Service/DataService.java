package org.example.Service;

import jakarta.annotation.PostConstruct;
import org.example.Entity.*;
import org.example.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.example.Util.DateUtils;
import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.example.Util.DateUtils.parseDate;

@Service
public class DataService {

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private MatchRepository matchRepository;

    @Autowired
    private RecordERepository recordRepository;

    @Autowired
    private PlayerTogetherStatsService playerTogetherStatsService;

    @PostConstruct
    public void importDataOnStartup() {
        importData();// Import when app starts

    }

    @PostConstruct
    private void savePlayerStat() {
        playerTogetherStatsService.calculatePlayerTogetherStats(); // fill db when the app starts
    }

    public void importData() {
        loadTeamsFromCSV("C:\\Users\\Ива-Галина\\IdeaProjects\\playerStats\\src\\main\\csv\\teams.csv");
        loadPlayersFromCSV("C:\\Users\\Ива-Галина\\IdeaProjects\\playerStats\\src\\main\\csv\\players.csv");
        loadMatchesFromCSV("C:\\Users\\Ива-Галина\\IdeaProjects\\playerStats\\src\\main\\csv\\matches.csv");
        loadRecordsFromCSV("C:\\Users\\Ива-Галина\\IdeaProjects\\playerStats\\src\\main\\csv\\records.csv");
    }

    public void loadTeamsFromCSV(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            br.readLine(); // Skip the header line
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                Team team = new Team();
                team.setId(Integer.parseInt(data[0]));
                team.setName(data[1]);
                team.setManagerFullName(data[2]);
                team.setGroupName(data[3]);
                teamRepository.save(team);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadPlayersFromCSV(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            br.readLine(); // Skip the header line
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                Player player = new Player();
                player.setId(Integer.parseInt(data[0]));
                player.setTeamNumber(Integer.parseInt(data[1]));
                player.setPosition(data[2]);
                player.setFullName(data[3]);
                player.setTeamId(Integer.parseInt(data[4]));
                playerRepository.save(player);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadMatchesFromCSV(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            br.readLine(); // Skip the header line
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                Match match = new Match();
                match.setId(Integer.parseInt(data[0]));
                match.setTeamAId(Integer.parseInt(data[1]));
                match.setTeamBId(Integer.parseInt(data[2]));
                match.setDate((parseDate(data[3])));
                match.setScore(data[4]);
                matchRepository.save(match);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadRecordsFromCSV(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            br.readLine(); // Skip the header line
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                RecordE record = new RecordE();
                record.setId(Integer.parseInt(data[0]));
                record.setPlayerId(Integer.parseInt(data[1]));
                record.setMatchId(Integer.parseInt(data[2]));
                record.setFromMinutes(Integer.parseInt(data[3]));
                record.setToMinutes(data[4].equals("NULL") ? null : Integer.parseInt(data[4]));
                recordRepository.save(record);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
