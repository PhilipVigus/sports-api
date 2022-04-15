package com.philvigus.sportsapi.api.controllers;

import com.philvigus.sportsapi.data.domain.Team;
import com.philvigus.sportsapi.data.factories.TeamFactory;
import com.philvigus.sportsapi.data.services.TeamService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureMockMvc
class TeamsControllerIntegrationTest {
  TeamFactory teamFactory;

  @Autowired TeamService teamService;

  @Autowired MockMvc mockMvc;

  @Test
  @DisplayName("When the GET /teams is hit it returns all teams")
  void whenGetTeamsThenReturnsAllTeams() throws Exception {
    teamFactory = new TeamFactory(teamService);

    final Team team1 = teamFactory.create();
    final Team team2 = teamFactory.create();

    mockMvc
        .perform(get("/teams"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$", hasSize(2)))
        .andExpect(jsonPath("$[0].name").value(team1.getName()))
        .andExpect(jsonPath("$[1].name").value(team2.getName()));
  }
}
