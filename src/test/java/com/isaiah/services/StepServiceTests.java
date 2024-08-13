package com.isaiah.services;

import com.isaiah.main.objects.Step;
import com.isaiah.main.repositories.StepRepository;
import com.isaiah.main.services.StepService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
public class StepServiceTests {

	@Mock //creates a mock version of StepRepository
	private StepRepository stepRepository;
	
	@InjectMocks //Injects the mock stepRepository into stepService.
	private StepService stepService;
	
	private Step step;
	
	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this); //initialize the mock repository
		step = new Step();
		step.setStepID(2);
		step.setStepNum(1);
		step.setRecipeID(4);
		step.setStepDesc("Be careful");
		step.setStepNote("Step note goes here");
	}
	
	@Test
	void createStep_shouldCreateUser() {
		
		//Act: call the createStep method to attempt to create the step
		stepService.createStep(step);
		
		/*Assert:
		 * Verifies that the save method from the repository was called exactly once with the step object as the argument.
		 * Ensures that the proper repository method was called
		 */
		verify(stepRepository, times(1)).save(step);
	}
	
	@Test
	void readStepByStepID_shouldReturnStepIfExists() {
		
		//Arrange
		when(stepRepository.findByStepID(step.getStepID())).thenReturn(Optional.of(step));
	
		//Act: Calls the readStepByStepID method to retrieve the step.
		Step foundStep = stepService.readStepByStepID(2);
		
		//Assert: Checks to see if the returned is not null and that step description matches the expected value
		assertNotNull(foundStep);
		assertEquals(step.getStepDesc(), foundStep.getStepDesc());
	}
	
	@Test
	void readStepByStepID_shouldReturnNullIfNotExists() {
		
		/*Arrange:
		 * Simulate the scenario where a step doesn't exists in the database.
		 * The mock repository will return an empty Optional.
		 */
		when(stepRepository.findByStepID(step.getStepID())).thenReturn(Optional.empty());
		
		/*
		 * Act: Calls stepRepository to read user with given stepID
		 */
		Step foundStep = stepService.readStepByStepID(step.getStepID());
		
		/*
		 * Assert:
		 * Check if the returned step is null, indicating that no user with the given ID exists
		 */
		assertNull(foundStep);
	}
	
	
	@Test
	void updateStep_shouldUpdateExistingStep() {
		step.setStepDesc("updated Description");
		
		//Act calls the updateStep method from the Step service.
		stepService.updateStep(step);
		
		/*Assert:
		 * Verifies that the save method was called exactly once with updated step object.
		 * This ensures that the step details are updated in the database.
		 */
		verify(stepRepository, times(1)).save(step);
		
	}
	
	@Test
	void deleteStepByStepID_shouldDeleteStepIfExists() {
		
		/* Act: 
		 * Calls the deleteStepByStepID to delete step
		 */
		stepService.deleteStepByStepID(step.getStepID());
		
		/* Assert:
		 * Verifies that the delete method was called exactly once with the correct stepID
		 * This ensures the step was deleted from the database/
		 */
		verify(stepRepository, times(1)).deleteByStepID(step.getStepID());
	}
	
	@Test
	void deleteStepsByRecipeID_shouldDeleteStepIfExists() {
		
		/* Act: 
		 * Calls the deleteStepByStepID to delete step
		 */
		stepService.deleteStepsByRecipeID(step.getRecipeID());
		
		/* Assert:
		 * Verifies that the delete method was called exactly once with the correct stepID
		 * This ensures the step was deleted from the database/
		 */
		verify(stepRepository, times(1)).deleteByRecipeID(step.getRecipeID());
	}
	
	
	
	
}
