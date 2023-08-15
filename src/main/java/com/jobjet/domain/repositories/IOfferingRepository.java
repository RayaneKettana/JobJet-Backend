package com.jobjet.domain.repositories;

import com.jobjet.domain.entities.Offering;

public interface IOfferingRepository {
  Offering save(Offering offering);
  Offering findById(Long id);

}
