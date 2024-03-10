package com.example.footballTeam.service;

import com.example.footballTeam.leagues.model.League;
import com.example.footballTeam.leagues.model.Leagues;
import com.example.footballTeam.leagues.service.LeaguesService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.client.RestTemplate;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class LeaguesServiceTest {

    @InjectMocks
    private LeaguesService leaguesService;

    @Mock
    private RestTemplate restTemplate;

    // getAllLeagues - START
    @Test
    void givenListLeagues_whengetAllLeagues_thenReturnSuccess(){
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

    // getAllLeagues - END

    // getLeagueByName - START
    @Test
    void givenListLeagues_whengetLeagueByName_thenReturnSuccess(){
        Leagues leagues = new Leagues();
        League league = new League();
        league.setIdLeague("4000");
        league.setStrLeague("Premier League");
        league.setStrSport("Soccer");
        leagues.setLeagues(Arrays.asList(league));

        when(restTemplate.getForObject(leaguesService.getApiUrl(), Leagues.class))
                .thenReturn(leagues);

        Optional<League> result = leaguesService.getLeaguesByName("Premier League");

        assertThat(result).isPresent();
        assertThat(result.get().getIdLeague()).isEqualTo("4000");
        assertThat(result.get().getStrLeague()).isEqualTo("Premier League");
        assertThat(result.get().getStrSport()).isEqualTo("Soccer");
    }

    @Test
    void givenListLeagues_whengetLeagueByName_thenIsEmpty(){
        Leagues leagues = new Leagues();
        League league = new League();
        league.setIdLeague("4000");
        league.setStrLeague("Premier League");
        league.setStrSport("Soccer");
        leagues.setLeagues(Arrays.asList(league));

        when(restTemplate.getForObject(leaguesService.getApiUrl(), Leagues.class))
                .thenReturn(leagues);

        Optional<League> result = leaguesService.getLeaguesByName("La liga");

        assertThat(result).isEmpty();
    }

    // getLeagueByName - END

    // getLeaguesById - START

    @Test
    void givenListLeagues_whengetLeaguesById_thenReturnSuccess(){
        Leagues leagues = new Leagues();
        League league = new League();
        league.setIdLeague("4000");
        league.setStrLeague("Premier League");
        league.setStrSport("Soccer");
        leagues.setLeagues(Arrays.asList(league));

        when(restTemplate.getForObject(leaguesService.getApiUrl(), Leagues.class))
                .thenReturn(leagues);

        Optional<League> result = leaguesService.getLeaguesById("4000");

        assertThat(result).isPresent();
        assertThat(result.get().getIdLeague()).isEqualTo("4000");
        assertThat(result.get().getStrLeague()).isEqualTo("Premier League");
        assertThat(result.get().getStrSport()).isEqualTo("Soccer");
    }

    @Test
    void givenListLeagues_whengetLeaguesById_thenIsEmpty(){
        Leagues leagues = new Leagues();
        League league = new League();
        league.setIdLeague("4000");
        league.setStrLeague("Premier League");
        league.setStrSport("Soccer");
        leagues.setLeagues(Arrays.asList(league));

        when(restTemplate.getForObject(leaguesService.getApiUrl(), Leagues.class))
                .thenReturn(leagues);

        Optional<League> result = leaguesService.getLeaguesById("1000");

        assertThat(result).isEmpty();
    }

    // getLeaguesById - END

    // getLeaguesBySport - START

    @Test
    void givenListLeagues_whengetLeaguesBySport_thenReturnSuccess(){
        Leagues leagues = new Leagues();
        League league = new League();
        league.setIdLeague("4000");
        league.setStrLeague("Premier League");
        league.setStrSport("Soccer");
        leagues.setLeagues(Arrays.asList(league));

        when(restTemplate.getForObject(leaguesService.getApiUrl(), Leagues.class))
                .thenReturn(leagues);

        Optional<League> result = leaguesService.getLeaguesBySport("Soccer");

        assertThat(result).isPresent();
        assertThat(result.get().getIdLeague()).isEqualTo("4000");
        assertThat(result.get().getStrLeague()).isEqualTo("Premier League");
        assertThat(result.get().getStrSport()).isEqualTo("Soccer");
    }

    @Test
    void givenListLeagues_whengetLeaguesBySport_thenIsEmpty(){
        Leagues leagues = new Leagues();
        League league = new League();
        league.setIdLeague("4000");
        league.setStrLeague("Premier League");
        league.setStrSport("Soccer");
        leagues.setLeagues(Arrays.asList(league));

        when(restTemplate.getForObject(leaguesService.getApiUrl(), Leagues.class))
                .thenReturn(leagues);

        Optional<League> result = leaguesService.getLeaguesBySport("Basket");

        assertThat(result).isEmpty();
    }

    // getLeaguesBySport - END
}
