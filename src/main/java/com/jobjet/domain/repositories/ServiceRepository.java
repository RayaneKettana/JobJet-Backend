package com.jobjet.domain.repositories;

import com.jobjet.domain.entities.Service;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepository extends JpaRepository<Service, Long> {
}
