package com.philvigus.sportsapi.imports.importers.england.teamnames;

import com.philvigus.sportsapi.SportsApiApplication;
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
  private TextFileImporterService textFileImporterService;

  public TeamNameImporter(TextFileImporterService textFileImporterService) {
    this.textFileImporterService = textFileImporterService;
  }

  public static void main(final String[] args) {
    SpringApplication.run(SportsApiApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    List<String> data = textFileImporterService.importFile("data/rsss/england/divisional-movements.txt");
    importTeams(data);
  }

  private void importTeams(List<String> data) {
    System.out.println("test");
  }
}
