  package com.jobjet.domain.usecases.inputs;

  import java.math.BigDecimal;

  public record CreateOfferingInput(String name, BigDecimal price, Integer duration) {
  }
