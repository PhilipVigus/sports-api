package com.philvigus.sportsapi.data.repositories;

import com.philvigus.sportsapi.data.domain.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, Long> {
}
