package com.jobjet.domain.repositories;

import com.jobjet.domain.entities.Service;

public interface IServiceRepository {
  Service save(Service service);
  Service findById(Long id);

}
