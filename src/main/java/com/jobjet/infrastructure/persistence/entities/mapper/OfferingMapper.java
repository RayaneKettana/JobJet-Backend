package com.jobjet.infrastructure.persistence.entities.mapper;

import com.jobjet.domain.entities.Offering;
import com.jobjet.infrastructure.persistence.entities.OfferingJpaEntity;

public class OfferingMapper {
  public static Offering toDomain(OfferingJpaEntity offeringJpaEntity) {
    return new Offering(offeringJpaEntity.getId(), offeringJpaEntity.getName(), offeringJpaEntity.getPrice(), offeringJpaEntity.getDuration());
  }

  public static OfferingJpaEntity toEntity(Offering offering) {
    OfferingJpaEntity offeringJpaEntity = new OfferingJpaEntity();
    offeringJpaEntity.setId(offering.id());
    offeringJpaEntity.setName(offering.name());
    offeringJpaEntity.setPrice(offering.price());
    offeringJpaEntity.setDuration(offering.duration());
    return offeringJpaEntity;
  }
}
