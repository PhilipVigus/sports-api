package com.philvigus.sportsapi.data.services;

import com.philvigus.sportsapi.data.domain.Team;

import java.util.List;

public interface TeamService extends EntitySaver<Team> {
  List<Team> findAll();
}
