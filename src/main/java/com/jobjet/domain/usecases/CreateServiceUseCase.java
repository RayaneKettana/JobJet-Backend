package com.jobjet.domain.usecases;

import com.jobjet.domain.entities.Service;
import com.jobjet.domain.repositories.IServiceRepository;

import java.math.BigDecimal;

public class CreateServiceUseCase {

  private final IServiceRepository repository;

  public CreateServiceUseCase(IServiceRepository repository) {
    this.repository = repository;
  }

  public Service execute(CreateServiceInput input) {
    Service newService = new Service(
            null,
            input.getName(),
            input.getPrice(),
            input.getDuration()
    );

    return repository.save(newService);
  }

  public static class CreateServiceInput {
    private final String name;
    private final BigDecimal price;
    private final Integer duration;

    public CreateServiceInput(String name, BigDecimal price, Integer duration) {
      this.name = name;
      this.price = price;
      this.duration = duration;
    }

    public String getName() {
      return name;
    }

    public BigDecimal getPrice() {
      return price;
    }

    public Integer getDuration() {
      return duration;
    }
  }
}
