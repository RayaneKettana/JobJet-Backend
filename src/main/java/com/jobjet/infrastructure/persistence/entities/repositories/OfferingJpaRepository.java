package com.jobjet.infrastructure.persistence.entities.repositories;// com.jobjet.infrastructure.persistence.repositories.ServiceJpaRepository.java

import com.jobjet.infrastructure.persistence.entities.OfferingJpaEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource(exported = false)
public interface OfferingJpaRepository extends CrudRepository<OfferingJpaEntity, Long> {
    boolean existsOfferingJpaEntitiesByName(String name);
}
