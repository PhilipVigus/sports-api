package com.philvigus.sportsapi.imports.importers.england.teamnames;

import com.philvigus.sportsapi.SportsApiApplication;
import com.philvigus.sportsapi.imports.services.TeamImporterService;
import com.philvigus.sportsapi.imports.services.TextFileImporterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.util.List;

@SpringBootApplication
@ComponentScan(basePackages = {"com.philvigus.*"})
@Slf4j
public class TeamNameImporter implements CommandLineRunner {
  private final TextFileImporterService textFileImporterService;
  private final TeamImporterService teamImporterService;

  public TeamNameImporter(TextFileImporterService textFileImporterService, TeamImporterService teamImporterService) {
    this.textFileImporterService = textFileImporterService;
    this.teamImporterService = teamImporterService;
  }

  public static void main(final String[] args) {
    SpringApplication.run(SportsApiApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    List<String> data = textFileImporterService.importFile("data/rsss/england/divisional-movements.txt");

    teamImporterService.importTeams(data);
  }

}
