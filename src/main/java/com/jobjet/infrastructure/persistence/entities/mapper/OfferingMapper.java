package com.jobjet.infrastructure.persistence.entities.mapper;

import com.jobjet.domain.entities.Offering;
import com.jobjet.infrastructure.persistence.entities.OfferingJpaEntity;

public class OfferingMapper {
  public static Offering toDomain(OfferingJpaEntity offeringJpaEntity) {
    return new Offering(offeringJpaEntity.getId(), offeringJpaEntity.getName(), offeringJpaEntity.getPrice(), offeringJpaEntity.getDuration());
  }

  public static OfferingJpaEntity toEntity(Offering offering) {
    OfferingJpaEntity offeringJpaEntity = new OfferingJpaEntity();
    offeringJpaEntity.setId(offering.getId());
    offeringJpaEntity.setName(offering.getName());
    offeringJpaEntity.setPrice(offering.getPrice());
    offeringJpaEntity.setDuration(offering.getDuration());
    return offeringJpaEntity;
  }
}
