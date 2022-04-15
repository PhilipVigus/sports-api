package com.philvigus.sportsapi.data.services;

public interface EntitySaver<T> {
  T save(T entity);
}
