package com.jobjet.application.controllers;

import com.jobjet.domain.entities.Offering;
import com.jobjet.domain.usecases.DeleteOfferingUseCase;
import com.jobjet.domain.usecases.GetAllOfferingsUseCase;
import com.jobjet.domain.usecases.UpdateOfferingUseCase;
import com.jobjet.domain.usecases.exceptions.OfferingNotFoundException;
import com.jobjet.domain.usecases.inputs.CreateOfferingInput;
import com.jobjet.domain.usecases.CreateOfferingUseCase;
import com.jobjet.domain.usecases.exceptions.OfferingAlreadyExist;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/offerings")
public class OfferingController {

  private final CreateOfferingUseCase createOfferingUseCase;
  private final DeleteOfferingUseCase deleteOfferingUseCase;
  private final UpdateOfferingUseCase updateOfferingUseCase;
  private final GetAllOfferingsUseCase getAllOfferingsUseCase;

  public OfferingController(
          CreateOfferingUseCase createOfferingUseCase,
          DeleteOfferingUseCase deleteOfferingUseCase,
          UpdateOfferingUseCase updateOfferingUseCase,
          GetAllOfferingsUseCase getAllOfferingsUseCase
  ) {
    this.createOfferingUseCase = createOfferingUseCase;
    this.deleteOfferingUseCase = deleteOfferingUseCase;
    this.updateOfferingUseCase = updateOfferingUseCase;
    this.getAllOfferingsUseCase = getAllOfferingsUseCase;
  }

  @PostMapping
  public ResponseEntity<Offering> createOffering(@RequestBody CreateOfferingInput input) {
    Offering newOffering = createOfferingUseCase.execute(input);
    return ResponseEntity.status(HttpStatus.CREATED).body(newOffering);
  }

  @DeleteMapping("/{offeringId}")
  public ResponseEntity<Void> deleteOffering(@PathVariable Long offeringId) {
    deleteOfferingUseCase.execute(offeringId);
    return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
  }

  @PutMapping("/{offeringId}")
  public ResponseEntity<Void> updateOffering(@PathVariable Long offeringId, @RequestBody Offering offering) {
    updateOfferingUseCase.execute(offering);
    return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
  }

  @GetMapping
  public ResponseEntity<List<Offering>> getAllOfferings() {
    List<Offering> offerings = getAllOfferingsUseCase.execute();
    return ResponseEntity.status(HttpStatus.OK).body(offerings);
  }


  @ExceptionHandler(OfferingAlreadyExist.class)
  public ResponseEntity<ErrorDetails> handleOfferingAlreadyExistException(OfferingAlreadyExist e) {
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorDetails("OFFERING_ALREADY_EXISTS", e.getMessage()));
  }

  @ExceptionHandler(OfferingNotFoundException.class)
  public ResponseEntity<ErrorDetails> handleOfferingNotFoundException(OfferingNotFoundException e) {
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorDetails("OFFERING_NOT_FOUND", e.getMessage()));
  }


  // TODO Refactor this class to reuse it in other controllers
  public static class ErrorDetails {
    private final String errorCode;
    private final String errorMessage;

    public ErrorDetails(String errorCode, String errorMessage) {
      this.errorCode = errorCode;
      this.errorMessage = errorMessage;
    }

    public String getErrorCode() {
      return errorCode;
    }

    public String getErrorMessage() {
      return errorMessage;
    }
  }


}
