package com.philvigus.sportsapi.data.services;

import com.philvigus.sportsapi.data.domain.Team;

import java.util.List;

public interface TeamService {
  Team save(Team team);

  List<Team> findAll();
}
