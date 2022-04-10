package com.philvigus.sportsapi.imports.services;

import com.philvigus.sportsapi.data.domain.Team;
import com.philvigus.sportsapi.data.services.TeamService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeamImporterServiceImpl implements TeamImporterService {
  private final TeamService teamService;

  public TeamImporterServiceImpl(final TeamService teamService) {
    this.teamService = teamService;
  }

  @Override
  public void importTeams(final List<String> data) {
    final List<String>teamData = new ArrayList<>();

    for (final String line : data) {
      if ("".equals(line)) {
        importTeam(teamData);
        teamData.clear();

        continue;
      }

      teamData.add(line);
    }
  }

  private void importTeam(final List<String> teamData) {
    if (!teamData.get(0).contains("(")) {
      return;
    }

    final String teamName = teamData.get(0).split(" \\(")[0];

    final Team team = new Team();
    team.setName(teamName);
    teamService.save(team);
  }
}
