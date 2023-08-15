package com.jobjet.infrastructure.persistence.entities.repositories;

import com.jobjet.domain.entities.Service;
import com.jobjet.domain.repositories.IServiceRepository;
import com.jobjet.infrastructure.persistence.entities.ServiceEntity;
import com.jobjet.infrastructure.persistence.entities.mapper.ServiceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ServiceRepositoryImpl implements IServiceRepository {

  private final ServiceJpaRepository jpaRepository;

  @Autowired
  public ServiceRepositoryImpl(ServiceJpaRepository jpaRepository) {
    this.jpaRepository = jpaRepository;
  }

  @Override
  public Service save(Service service) {
    ServiceEntity serviceEntity = ServiceMapper.toEntity(service);
    ServiceEntity savedEntity = jpaRepository.save(serviceEntity);
    return ServiceMapper.toDomain(savedEntity);
  }

  @Override
  public Service findById(Long id) {
    return jpaRepository.findById(id)
            .map(ServiceMapper::toDomain)
            .orElse(null);
  }
}
