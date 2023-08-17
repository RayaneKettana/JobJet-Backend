package com.jobjet.infrastructure.config;

import com.jobjet.domain.usecases.CreateOfferingUseCase;
import com.jobjet.domain.usecases.DeleteOfferingUseCase;
import com.jobjet.domain.usecases.UpdateOfferingUseCase;
import com.jobjet.infrastructure.persistence.entities.repositories.OfferingRepositoryImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OfferingConfiguration {
    private final OfferingRepositoryImpl offeringRepository;

    public OfferingConfiguration(OfferingRepositoryImpl offeringRepository) {
        this.offeringRepository = offeringRepository;
    }

    @Bean
    CreateOfferingUseCase createOfferingUseCase() {
        return new CreateOfferingUseCase(offeringRepository);
    }

    @Bean
    DeleteOfferingUseCase deleteOfferingUseCase() {
        return new DeleteOfferingUseCase(offeringRepository);
    }

    @Bean
    UpdateOfferingUseCase updateOfferingUseCase() {
        return new UpdateOfferingUseCase(offeringRepository);
    }
}
