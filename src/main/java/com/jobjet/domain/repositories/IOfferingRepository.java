package com.jobjet.domain.repositories;

import com.jobjet.domain.entities.Offering;

import java.util.List;
import java.util.Optional;

public interface IOfferingRepository {
  Offering save(Offering offering);
  Optional<Offering> findById(Long id);
  void update(Offering offering);
  void delete(Long id);
  boolean exists(String name);
  boolean existById(Long id);
  List<Offering> findAll();
}
