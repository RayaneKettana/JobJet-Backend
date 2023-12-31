package com.jobjet.domain.usecases;

import com.jobjet.domain.entities.Offering;
import com.jobjet.domain.repositories.IOfferingRepository;
import com.jobjet.domain.usecases.exceptions.OfferingAlreadyExist;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import com.jobjet.domain.usecases.inputs.CreateOfferingInput;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

class CreateOfferingUseCaseTest {

    @InjectMocks
    private CreateOfferingUseCase createOfferingUseCase;

    @Mock
    private IOfferingRepository offeringRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this); // Initialise les mocks
    }

    @Test
    @DisplayName("shouldCreateOffering")
    public void shouldCreateOffering() {
        // Arrange
        CreateOfferingInput input = new CreateOfferingInput("Test", new BigDecimal(10), 1);
        Offering mockOffering = new Offering(null, "Test", new BigDecimal(10), 1);
        when(offeringRepository.save(any(Offering.class))).thenReturn(mockOffering);

        // Act
        Offering result = createOfferingUseCase.execute(input);

        // Assert
        Assertions.assertThat(result).isNotNull();
        Assertions.assertThat(result.name()).isEqualTo("Test");
    }

    @Test
    @DisplayName("shouldThrowOfferingAlreadyExist")
    public void shouldThrowOfferingAlreadyExist() {
        // Arrange
        CreateOfferingInput input = new CreateOfferingInput("Test", new BigDecimal(10), 1);
        when(offeringRepository.exists(anyString())).thenReturn(true);

        // Act & Assert
        Exception exception = assertThrows(OfferingAlreadyExist.class, () -> {
            createOfferingUseCase.execute(input);
        });

        // Optional: Further assertions on the exception if necessary
        assertTrue(exception.getMessage().contains("L'offre spécifiée existe déjà."));
    }

}
