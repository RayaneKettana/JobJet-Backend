package com.jobjet.domain.usecases;

import com.jobjet.domain.entities.Offering;
import com.jobjet.domain.repositories.IOfferingRepository;

public class UpdateOfferingUseCase {
  private final IOfferingRepository offeringRepository;


  public UpdateOfferingUseCase(IOfferingRepository offeringRepository) {
    this.offeringRepository = offeringRepository;
  }

  public void execute(Offering offering) {
    offeringRepository.update(offering);
  }
}
