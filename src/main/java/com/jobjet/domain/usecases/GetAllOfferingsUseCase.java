package com.jobjet.domain.usecases;

import com.jobjet.domain.entities.Offering;
import com.jobjet.domain.repositories.IOfferingRepository;
import java.util.List;

public class GetAllOfferingsUseCase {

  private final IOfferingRepository repository;

  public GetAllOfferingsUseCase(IOfferingRepository repository) {
    this.repository = repository;
  }

  public List<Offering> execute() {
    return repository.findAll();
  }
}
