package com.jobjet.domain.usecases;

import com.jobjet.domain.repositories.IOfferingRepository;
import com.jobjet.domain.usecases.exceptions.OfferingNotFoundException;

public class DeleteOfferingUseCase {
  private final IOfferingRepository repository;

  public DeleteOfferingUseCase(IOfferingRepository repository) {
    this.repository = repository;
  }

  public void execute(Long offeringId) {
    if (!repository.existById(offeringId)) {
      throw new OfferingNotFoundException("L'offre avec l'ID " + offeringId + " n'existe pas.");
    }
    repository.delete(offeringId);
  }
}
