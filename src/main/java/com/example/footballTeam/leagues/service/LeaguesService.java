package com.example.footballTeam.leagues.service;

import com.example.footballTeam.leagues.model.League;
import com.example.footballTeam.leagues.model.Leagues;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
@Data
public class LeaguesService {

    @Value("${api.thesportsdb.url}")
    private String apiUrl;

    private final RestTemplate restTemplate;

    public LeaguesService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<League> getAllLeagues(){
        Leagues leagues = restTemplate.getForObject(apiUrl, Leagues.class);
        if(leagues.getLeagues() != null){
            return leagues.getLeagues();
        }else {
            return null;
        }
    }

    public Optional<League> getLeaguesByName(String name){
        List<League> leagues = this.getAllLeagues();
        return leagues.stream()
                .filter(league -> league.getStrLeague().equalsIgnoreCase(name))
                .findFirst();
    }

    public Optional<League> getLeaguesById(String id){
        List<League> leagues = this.getAllLeagues();
        return leagues.stream()
                .filter(league -> league.getIdLeague().equalsIgnoreCase(id))
                .findFirst();
    }

    public Optional<League> getLeaguesBySport(String sport){
        List<League> leagues = this.getAllLeagues();
        return leagues.stream()
                .filter(league -> league.getStrSport().equalsIgnoreCase(sport))
                .findFirst();
    }
}
