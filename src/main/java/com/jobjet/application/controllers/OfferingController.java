package com.jobjet.application.controllers;

import com.jobjet.domain.usecases.CreateOfferingUseCase;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/services")
public class OfferingController {

  public OfferingController(CreateOfferingUseCase createOfferingUseCase) {
  }
}
