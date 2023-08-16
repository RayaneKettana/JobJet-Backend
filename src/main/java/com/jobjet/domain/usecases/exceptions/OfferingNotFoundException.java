package com.jobjet.domain.usecases.exceptions;

public class OfferingNotFoundException extends RuntimeException{

  public OfferingNotFoundException() {
    super("L'offre spécifiée n'existe pas.");
  }

  public OfferingNotFoundException(String message) {
    super(message);
  }
}
