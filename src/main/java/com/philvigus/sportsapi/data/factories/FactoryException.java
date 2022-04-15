package com.philvigus.sportsapi.data.factories;

public class FactoryException extends RuntimeException {
  public FactoryException(final String message, final Throwable err) {
    super(message, err);
  }
}
