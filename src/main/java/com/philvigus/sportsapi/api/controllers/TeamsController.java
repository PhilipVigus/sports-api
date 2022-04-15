package com.philvigus.sportsapi.api.controllers;

import com.philvigus.sportsapi.data.domain.Team;
import com.philvigus.sportsapi.data.services.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("teams")
public class TeamsController {
  @Autowired
  TeamService teamService;

  @GetMapping
  public List<Team> findAll() {
    return teamService.findAll();
  }
}
