package com.example.footballTeam.leagues.controller;

import com.example.footballTeam.leagues.model.League;
import com.example.footballTeam.leagues.service.LeaguesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/sportsdb")
public class LeaguesController {

    @Autowired
    LeaguesService leaguesService;

    @GetMapping("/leagues")
    public List<League> getAllLeagues(){
        return this.leaguesService.getAllLeagues();
    }

    @GetMapping("/league/{name}")
    public Optional<League> getLeagueByName(@PathVariable String name){
        return this.leaguesService.getLeaguesByName(name);
    }

    @GetMapping("/league/{id}")
    public Optional<League> getLeagueById(@PathVariable String id){
        return this.leaguesService.getLeaguesById(id);
    }

    @GetMapping("/league/{sport}")
    public Optional<League> getLeagueBySport(@PathVariable String sport){
        return this.leaguesService.getLeaguesBySport(sport);
    }
}
