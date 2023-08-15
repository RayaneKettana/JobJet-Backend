package com.jobjet.domain.entities;


import java.math.BigDecimal;


public record Offering(Long id, String name, BigDecimal price, Integer duration) { }

