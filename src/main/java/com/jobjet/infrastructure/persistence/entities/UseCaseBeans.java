package com.jobjet.infrastructure.persistence.entities;

import com.jobjet.domain.usecases.CreateOfferingUseCase;
import com.jobjet.infrastructure.persistence.entities.repositories.OfferingRepositoryImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseBeans {
    private final OfferingRepositoryImpl offeringRepository;

    public UseCaseBeans(OfferingRepositoryImpl offeringRepository) {
        this.offeringRepository = offeringRepository;
    }

    @Bean
    CreateOfferingUseCase createOfferingUseCase() {
        return new CreateOfferingUseCase(offeringRepository);
    }
}
