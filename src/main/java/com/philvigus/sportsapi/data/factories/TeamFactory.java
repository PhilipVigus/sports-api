package com.philvigus.sportsapi.data.factories;

import com.philvigus.sportsapi.data.domain.Team;
import com.philvigus.sportsapi.data.services.EntitySaver;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class TeamFactory extends AbstractBaseFactory<Team> {
  public TeamFactory(final EntitySaver<Team> entitySaver) {
    super(Team.class, entitySaver);
  }

  @Override
  protected Map<String, Object> defaultAttributes() {
    final Map<String, Object> attributes = new ConcurrentHashMap<>();

    attributes.put("name", faker.lorem().sentence(1, 3));

    return attributes;
  }
}
