package com.philvigus.sportsapi.data.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;

@Setter
@Getter
@Entity
@Table(name = "names")
public class Name {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "name", nullable = false)
  private String name;

  @Column(name = "used_from")
  private Date usedFrom;

  @Column(name = "used_to")
  private Date usedTo;

  @Column(name = "notes")
  private String notes;
}
