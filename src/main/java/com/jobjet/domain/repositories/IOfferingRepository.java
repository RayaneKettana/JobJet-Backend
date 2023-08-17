package com.jobjet.domain.repositories;

import com.jobjet.domain.entities.Offering;

import java.util.Optional;

public interface IOfferingRepository {
  Offering save(Offering offering);
  Optional<Offering> findById(Long id);
  Offering update(Offering offering);
  void delete(Long id);
  boolean exists(String name);
  boolean existById(Long id);
}
