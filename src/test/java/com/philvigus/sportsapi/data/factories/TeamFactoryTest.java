package com.philvigus.sportsapi.data.factories;

import com.philvigus.sportsapi.data.domain.Team;
import com.philvigus.sportsapi.data.repositories.TeamRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@DisplayName("TeamFactory Test")
class TeamFactoryTest {
  TeamFactory teamFactory;

  @Mock TeamRepository teamRepository;

  @Captor ArgumentCaptor<Team> teamCaptor;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);

    teamFactory = new TeamFactory(teamRepository);
  }

  @Test
  void createSavesAndReturnsTheTeamWithTheSpecifiedName() throws FactoryException {
    String teamName = "test name";

    teamFactory.withAttributes(Map.of("name", teamName)).create();

    verify(teamRepository, times(1)).save(teamCaptor.capture());

    assertEquals(teamName, teamCaptor.getValue().getName());
  }

  @Test
  void createSavesAndReturnsTheTeamWithARandomNameIfNoneIsSpecified() throws FactoryException {
    teamFactory.create();

    verify(teamRepository, times(1)).save(teamCaptor.capture());

    assertNotEquals("", teamCaptor.getValue().getName());
  }

  @Test
  void makeReturnsTheTeamWithTheSpecifiedName() throws FactoryException {
    String teamName = "test name";

    Team team = teamFactory.withAttributes(Map.of("name", teamName)).make();

    assertEquals(teamName, team.getName());
  }

  @Test
  void makeReturnsTheTeamWithARandomNameIfNoneIsSpecified() throws FactoryException {
    final Team team = teamFactory.make();

    assertNotEquals("", team.getName());
  }
}
