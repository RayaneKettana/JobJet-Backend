package com.jobjet.application.controllers;

import com.jobjet.domain.usecases.CreateOfferingUseCase;
import com.jobjet.domain.entities.Offering;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/offerings")
public class OfferingController {

  private final CreateOfferingUseCase createOfferingUseCase;

  public OfferingController(CreateOfferingUseCase createOfferingUseCase) {
    this.createOfferingUseCase = createOfferingUseCase;
  }

  @PostMapping
  public ResponseEntity<Offering> createOffering(@RequestBody CreateOfferingUseCase.CreateOfferingInput input) {
    try {
      Offering newOffering = createOfferingUseCase.execute(input);
      return ResponseEntity.status(201).body(newOffering);
    } catch (Exception e) {
      return ResponseEntity.badRequest().build();
    }
  }
}
