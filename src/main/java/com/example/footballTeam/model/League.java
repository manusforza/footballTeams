package com.example.footballTeam.model;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class League {
    private String idLeague;
    private String strLeague;
    private String strSport;
}
