package com.jobjet.infrastructure.persistence.entities.repositories;// com.jobjet.infrastructure.persistence.repositories.ServiceJpaRepository.java

import com.jobjet.infrastructure.persistence.entities.OfferingJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OfferingJpaRepository extends JpaRepository<OfferingJpaEntity, Long> {
}
