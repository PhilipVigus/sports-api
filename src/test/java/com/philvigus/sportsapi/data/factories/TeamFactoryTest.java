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

import java.util.List;
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
    final String teamName = "test name";

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
  void createSavesAndReturnsMultipleTeamsWithTheSameSpecifiedName() throws FactoryException {
    final String teamName = "test name";

    teamFactory.withAttributes(Map.of("name", teamName)).create(2);

    verify(teamRepository, times(2)).save(teamCaptor.capture());

    final List<Team> createdTeams = teamCaptor.getAllValues();

    assertEquals(teamName, createdTeams.get(0).getName());
    assertEquals(teamName, createdTeams.get(1).getName());
  }

  @Test
  void createSavesAndReturnsMultipleTeamsWithRandomNames() throws FactoryException {
    teamFactory.create(2);

    verify(teamRepository, times(2)).save(teamCaptor.capture());

    final List<Team> createdTeams = teamCaptor.getAllValues();

    assertNotEquals("", createdTeams.get(0).getName());
    assertNotEquals("", createdTeams.get(1).getName());
  }

  @Test
  void makeReturnsTheTeamWithTheSpecifiedName() throws FactoryException {
    final String teamName = "test name";

    final Team team = teamFactory.withAttributes(Map.of("name", teamName)).make();

    assertEquals(teamName, team.getName());
  }

  @Test
  void makeReturnsTheTeamWithARandomNameIfNoneIsSpecified() throws FactoryException {
    final Team team = teamFactory.make();

    assertNotEquals("", team.getName());
  }

  @Test
  void makeReturnsMultipleTeamsWithTheSameSpecifiedName() throws FactoryException {
    final String teamName = "test name";

    final List<Team> madeTeams = teamFactory.withAttributes(Map.of("name", teamName)).make(2);

    assertEquals(teamName, madeTeams.get(0).getName());
    assertEquals(teamName, madeTeams.get(1).getName());
  }

  @Test
  void makeReturnsMultipleTeamsWithRandomNames() throws FactoryException {
    final List<Team> madeTeams = teamFactory.make(2);

    assertNotEquals("", madeTeams.get(0).getName());
    assertNotEquals("", madeTeams.get(1).getName());
  }
}
