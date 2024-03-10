package com.example.footballTeam.model;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Component
public class Leagues {

    private List<League> leagues;
}
