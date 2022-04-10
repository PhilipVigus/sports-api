package com.philvigus.sportsapi.imports.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.springframework.test.util.AssertionErrors.assertEquals;

@DisplayName("TextFileImporterServiceImpl Test")
class TextFileImporterServiceImplTest {
  TextFileImporterServiceImpl textFileImporterService;

  @BeforeEach
  void setUp() {
    textFileImporterService = new TextFileImporterServiceImpl();
  }

  @Test
  @DisplayName("It imports a text file as a list of lines of text")
  void itImportsATextFileAsAListOfLinesOfText() throws IOException {
    List<String> data = textFileImporterService.importFile("data/rsss/england/divisional-movements.txt");

    assertEquals("The first line of the imported text file is incorrect", "Aberdare Athletic (1921-27)", data.get(0));
    assertEquals("The second line of the imported text file is incorrect", "6   III  6   [6]   1921-27s", data.get(1));
  }

  @Test
  @DisplayName("It throws an IOException of the file specified does not exist")
  void itThrowsAnExceptionIfTheFileDoesntExist() {
    assertThrows(IOException.class, () -> textFileImporterService.importFile("doesnt exist"));
  }
}