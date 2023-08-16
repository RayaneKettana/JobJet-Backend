package com.jobjet.application.controllers;

import com.jobjet.domain.entities.Offering;
import com.jobjet.domain.usecases.CreateOfferingInput;
import com.jobjet.domain.usecases.CreateOfferingUseCase;
import com.jobjet.domain.usecases.OfferingAlreadyExist;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<Offering> createOffering(@RequestBody CreateOfferingInput input) {
        Offering newOffering = createOfferingUseCase.execute(input);
        return ResponseEntity.status(HttpStatus.CREATED).body(newOffering);
    }
    @ExceptionHandler(OfferingAlreadyExist.class)
    public ResponseEntity<ErrorDetails> handleOfferingAlreadyExistException(OfferingAlreadyExist e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorDetails("OFFERING_ALREADY_EXISTS", e.getMessage()));
    }

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
