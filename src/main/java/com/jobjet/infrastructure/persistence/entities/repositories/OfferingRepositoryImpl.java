package com.jobjet.infrastructure.persistence.entities.repositories;

import com.jobjet.domain.entities.Offering;
import com.jobjet.domain.repositories.IOfferingRepository;
import com.jobjet.infrastructure.persistence.entities.OfferingJpaEntity;
import com.jobjet.infrastructure.persistence.entities.mapper.OfferingMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

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
    public Optional<Offering> findById(Long id) {
        return jpaRepository.findById(id)
                .map(OfferingMapper::toDomain);
    }

    @Override
    public void delete(Long id) {
        jpaRepository.deleteById(id);
    }

    @Override
    public boolean exists(String name) {
        return jpaRepository.existsOfferingJpaEntitiesByName(name);
    }

    @Override
    public boolean existById(Long id) {
        return jpaRepository.existsById(id);
    }
}
