package com.jobjet.infrastructure.persistence.entities.repositories;

import com.jobjet.domain.entities.Offering;
import com.jobjet.domain.repositories.IOfferingRepository;
import com.jobjet.infrastructure.persistence.entities.OfferingJpaEntity;
import com.jobjet.infrastructure.persistence.entities.mapper.OfferingMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class OfferingRepositoryImpl implements IOfferingRepository {

  private final OfferingJpaRepository jpaRepository;

  @Autowired
  public OfferingRepositoryImpl(OfferingJpaRepository jpaRepository) {
    this.jpaRepository = jpaRepository;
  }

  @Override
  public Offering save(Offering offering) {
    OfferingJpaEntity offeringJpaEntity = OfferingMapper.toEntity(offering);
    OfferingJpaEntity savedEntity = jpaRepository.save(offeringJpaEntity);
    return OfferingMapper.toDomain(savedEntity);
  }

  @Override
  public Offering findById(Long id) {
    return jpaRepository.findById(id)
            .map(OfferingMapper::toDomain)
            .orElse(null);
  }
}
