package com.philvigus.sportsapi.data.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.springframework.test.util.AssertionErrors.assertEquals;


@DisplayName("Team Domain Test")
class TeamTest {
  Team team;

  @BeforeEach
  void setUp() {
    team = new Team();
  }

  @Test
  @DisplayName("setName should set the name field")
  void setNameShouldSetTheNameField() {
    final String name = "test name";

    team.setName(name);

    assertEquals("The name field was not set", name, team.getName());
  }
}