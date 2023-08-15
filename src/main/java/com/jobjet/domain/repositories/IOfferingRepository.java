package com.jobjet.domain.repositories;

import com.jobjet.domain.entities.Offering;

import java.util.Optional;

public interface IOfferingRepository {
  Offering save(Offering offering);
  Optional<Offering> findById(Long id);

    boolean exists(String name);
}
