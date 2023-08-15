package com.jobjet.infrastructure.persistence.entities.repositories;// com.jobjet.infrastructure.persistence.repositories.ServiceJpaRepository.java

import com.jobjet.infrastructure.persistence.entities.ServiceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceJpaRepository extends JpaRepository<ServiceEntity, Long> {
}
