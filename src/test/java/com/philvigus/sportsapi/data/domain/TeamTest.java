package com.philvigus.sportsapi.data.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.springframework.test.util.AssertionErrors.assertEquals;


@DisplayName("Team Test")
class TeamTest {
  Team team;

  @BeforeEach
  void setUp() {
    team = new Team();
  }

  @Test
  @DisplayName("You can set the name")
  void youCanSetTheName() {
    team.setName("test name");

    assertEquals("The team name was not set", "test name", team.getName());
  }
}