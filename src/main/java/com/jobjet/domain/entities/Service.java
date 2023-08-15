package com.jobjet.domain.entities;


import java.math.BigDecimal;



public class Service {
  private Long id;
  private String name;
  private BigDecimal price;
  private Integer duration;

  public Service(Long id, String name, BigDecimal price, Integer duration) {
    this.id = id;
    this.name = name;
    this.price = price;
    this.duration = duration;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public BigDecimal getPrice() {
    return price;
  }

  public void setPrice(BigDecimal price) {
    this.price = price;
  }

  public Integer getDuration() {
    return duration;
  }

  public void setDuration(Integer duration) {
    this.duration = duration;
  }
}
