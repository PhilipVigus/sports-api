package com.philvigus.sportsapi.data.services;

import com.philvigus.sportsapi.data.domain.Team;
import com.philvigus.sportsapi.data.repositories.TeamRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

class TeamServiceImplTest {
  TeamServiceImpl teamService;

  @Mock
  TeamRepository teamRepository;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);

    teamService = new TeamServiceImpl(teamRepository);
  }

  @Test
  @DisplayName("save calls save on the services repository")
  void saveCallsRepositorySave() {
    final Team team = new Team();
    team.setName("test name");

    teamService.save(team);

    verify(teamRepository, times(1)).save(team);
  }

  @Test
  @DisplayName("findAll calls findAll on the services repository")
  void findAllCallsRepositoryFindAll() {
    teamService.findAll();

    verify(teamRepository, times(1)).findAll();
  }
}