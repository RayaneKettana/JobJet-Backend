package com.jobjet.domain.usecases;

import com.jobjet.domain.entities.Offering;
import com.jobjet.domain.repositories.IOfferingRepository;
import com.jobjet.domain.usecases.inputs.CreateOfferingInput;

public class CreateOfferingUseCase {

    private final IOfferingRepository repository;

    public CreateOfferingUseCase(IOfferingRepository repository) {
        this.repository = repository;
    }

    public Offering execute(CreateOfferingInput input) {
        if (repository.exists(input.name()))
            throw new OfferingAlreadyExist();

        Offering newOffering = new Offering(
                null,
                input.name(),
                input.price(),
                input.duration()
        );

        return repository.save(newOffering);
    }

}
