package com.jobjet.domain.usecases;

import com.jobjet.domain.entities.Offering;
import com.jobjet.domain.repositories.IOfferingRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
@Service
public class CreateOfferingUseCase {

  private final IOfferingRepository repository;

  public CreateOfferingUseCase(IOfferingRepository repository) {
    this.repository = repository;
  }

  public Offering execute(CreateOfferingInput input) {
    Offering newOffering = new Offering(
            null,
            input.getName(),
            input.getPrice(),
            input.getDuration()
    );

    return repository.save(newOffering);
  }

  public static class CreateOfferingInput {
    private final String name;
    private final BigDecimal price;
    private final Integer duration;

    public CreateOfferingInput(String name, BigDecimal price, Integer duration) {
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
