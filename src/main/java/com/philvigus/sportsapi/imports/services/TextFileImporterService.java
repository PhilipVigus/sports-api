package com.philvigus.sportsapi.imports.services;

import java.io.IOException;
import java.util.List;

public interface TextFileImporterService {
  List<String> importFile(String resourceLocation) throws IOException;
}
