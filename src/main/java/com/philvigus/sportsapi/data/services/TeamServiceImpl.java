package com.philvigus.sportsapi.data.services;

import com.philvigus.sportsapi.data.domain.Team;
import com.philvigus.sportsapi.data.repositories.TeamRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamServiceImpl implements TeamService {
  private final TeamRepository teamRepository;

  public TeamServiceImpl(final TeamRepository teamRepository) {
    this.teamRepository = teamRepository;
  }

  @Override
  public Team save(Team team) {
    return teamRepository.save(team);
  }

  @Override
  public List<Team> findAll() {
    return teamRepository.findAll();
  }
}
