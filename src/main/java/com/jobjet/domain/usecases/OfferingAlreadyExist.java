package com.jobjet.domain.usecases;

public class OfferingAlreadyExist extends RuntimeException {

  public OfferingAlreadyExist() {
    super("L'offre spécifiée existe déjà.");
  }

  public OfferingAlreadyExist(String message) {
    super(message);
  }
}
