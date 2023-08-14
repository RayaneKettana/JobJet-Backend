package com.jobjet.infrastructure.persistence.entities.mapper;

import com.jobjet.domain.entities.Service;
import com.jobjet.infrastructure.persistence.entities.ServiceEntity;

public class ServiceMapper {
  public static Service toDomain(ServiceEntity serviceEntity) {
    return new Service(serviceEntity.getId(), serviceEntity.getName(), serviceEntity.getPrice(), serviceEntity.getDuration());
  }

  public static ServiceEntity toEntity(Service service) {
    ServiceEntity serviceEntity = new ServiceEntity();
    serviceEntity.setId(service.getId());
    serviceEntity.setName(service.getName());
    serviceEntity.setPrice(service.getPrice());
    serviceEntity.setDuration(service.getDuration());
    return serviceEntity;
  }
}
