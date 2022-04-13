package com.philvigus.sportsapi.data.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.Date;

import static org.springframework.test.util.AssertionErrors.assertEquals;

@DisplayName("Name Domain Test")
class NameTest {
  Name name;

  @BeforeEach
  void setUp() {
    name = new Name();
  }

  @Test
  @DisplayName("setName should set the name field")
  void setNameShouldSetTheNameField() {
    final String name = "test name";

    this.name.setName(name);

    assertEquals("The name field was not set", name, this.name.getName());
  }

  @Test
  @DisplayName("setUsedFrom should set the usedFrom field")
  void setUsedFromShouldSetTheUsedFromField() {
    final Date date = new Date(System.currentTimeMillis());

    name.setUsedFrom(date);

    assertEquals("The used from field was not set", date, name.getUsedFrom());
  }

  @Test
  @DisplayName("setUsedTo should set the usedTo field")
  void setUsedToShouldSetTheUsedToField() {
    final Date date = new Date(System.currentTimeMillis());

    name.setUsedTo(date);

    assertEquals("The used until field was not set", date, name.getUsedTo());
  }

  @Test
  @DisplayName("setNotes should set the notes field")
  void setNotesShouldSetTheNotesField() {
    final String notes = "test notes";

    name.setNotes(notes);

    assertEquals("The notes field was not set", notes, name.getNotes());
  }
}