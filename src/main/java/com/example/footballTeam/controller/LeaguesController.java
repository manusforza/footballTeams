package com.example.footballTeam.controller;

import com.example.footballTeam.model.League;
import com.example.footballTeam.service.LeaguesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/sportsdb")
public class LeaguesController {

    @Autowired
    LeaguesService leaguesService;

    @GetMapping("/leagues")
    public List<League> getAllLeagues(){
        return this.leaguesService.getAllLeagues();
    }
}
