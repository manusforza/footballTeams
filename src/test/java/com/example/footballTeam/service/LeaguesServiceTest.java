package com.example.footballTeam.service;

import com.example.footballTeam.model.League;
import com.example.footballTeam.model.Leagues;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.client.RestTemplate;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class LeaguesServiceTest {

    @InjectMocks
    private LeaguesService leaguesService;

    @Mock
    private RestTemplate restTemplate;

    @Test
    void givenListLeagues_whengetAllLeagues_thenNotNull(){
        Leagues leagues = new Leagues();
        League league = new League();
        league.setIdLeague("4000");
        league.setStrLeague("Premier League");
        league.setStrSport("Soccer");
        leagues.setLeagues(Arrays.asList(league));

        when(restTemplate.getForObject(leaguesService.getApiUrl(), Leagues.class))
                .thenReturn(leagues);

        List<League> result = leaguesService.getAllLeagues();

        assertThat(result).hasSize(1);
        assertThat(result.get(0).getIdLeague()).isEqualTo("4000");
        assertThat(result.get(0).getStrLeague()).isEqualTo("Premier League");
        assertThat(result.get(0).getStrSport()).isEqualTo("Soccer");
    }
}
