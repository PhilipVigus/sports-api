package com.philvigus.sportsapi.imports.services;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

@Service
public class TextFileImporterServiceImpl implements TextFileImporterService {
  @Override
  public List<String> importFile(String resourceLocation) throws IOException {
    File data = new ClassPathResource(resourceLocation).getFile();

    return Files.readAllLines(data.toPath());
  }
}
