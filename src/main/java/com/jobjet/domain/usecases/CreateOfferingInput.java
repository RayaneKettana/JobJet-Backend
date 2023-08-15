package com.jobjet.domain.usecases;

import java.math.BigDecimal;

public record CreateOfferingInput(String name, BigDecimal price, Integer duration) {
}
