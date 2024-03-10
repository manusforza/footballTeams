package com.example.footballTeam.service;

import com.example.footballTeam.model.League;
import com.example.footballTeam.model.Leagues;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

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
}
