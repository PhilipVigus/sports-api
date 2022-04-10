package com.philvigus.sportsapi.imports.services;

import com.philvigus.sportsapi.data.domain.Team;
import com.philvigus.sportsapi.data.services.TeamService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeamImporterServiceImpl implements TeamImporterService {
  private final TeamService teamService;

  public TeamImporterServiceImpl(TeamService teamService) {
    this.teamService = teamService;
  }

  @Override
  public void importTeams(List<String> data) {
    List<String>teamData = new ArrayList<>();

    for (String line : data) {
      if (line.equals("")) {
        importTeam(teamData);
        teamData.clear();
        continue;
      }

      teamData.add(line);
    }
  }

  private void importTeam(List<String> teamData) {
    if (!teamData.get(0).contains("(")) {
      return;
    }

    String teamName = teamData.get(0).split(" \\(")[0];

    Team team = new Team();
    team.setName(teamName);
    teamService.save(team);
  }
}
