package com.philvigus.sportsapi.api.controllers;

import com.philvigus.sportsapi.data.domain.Team;
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
  @Autowired
  TeamService teamService;

  @Autowired
  MockMvc mockMvc;

  @Test
  @DisplayName("When the GET /teams is hit it returns all teams")
  void whenGetTeamsThenReturnsAllTeams() throws Exception {
    final Team team1 = new Team();

    team1.setName("test team 1");
    teamService.save(team1);

    final Team team2 = new Team();

    team2.setName("test team 2");
    teamService.save(team2);

    mockMvc.perform(get("/teams"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$", hasSize(2)))
            .andExpect(jsonPath("$[0].name").value("test team 1"))
            .andExpect(jsonPath("$[1].name").value("test team 2"));
  }
}