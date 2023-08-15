package com.jobjet.application.controllers;

import com.jobjet.domain.entities.Offering;
import com.jobjet.domain.usecases.CreateOfferingInput;
import com.jobjet.domain.usecases.CreateOfferingUseCase;
import com.jobjet.domain.usecases.OfferingAlreadyExist;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/offerings")
public class OfferingController {

    private final CreateOfferingUseCase createOfferingUseCase;

    public OfferingController(CreateOfferingUseCase createOfferingUseCase) {
        this.createOfferingUseCase = createOfferingUseCase;
    }

    @PostMapping
    public ResponseEntity<?> createOffering(@RequestBody CreateOfferingInput input) {
        try {
            Offering newOffering = createOfferingUseCase.execute(input);
            return ResponseEntity.status(201).body(newOffering);
        } catch (OfferingAlreadyExist e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
//      ResponseEntity.created("offering/newOffering.id).body(newOffering).build();
//        TODO
    }
}
