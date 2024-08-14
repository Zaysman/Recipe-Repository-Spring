package com.isaiah.services;

import com.isaiah.main.objects.Ingredient;
import com.isaiah.main.objects.Step;
import com.isaiah.main.repositories.IngredientRepository;
import com.isaiah.main.services.IngredientService;

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
public class IngredientServiceTests {

	@Mock
	private IngredientRepository ingredientRepository;
	
	
	@InjectMocks
	private IngredientService ingredientService;
	
	private Ingredient ingredient;
	
	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
		ingredient = new Ingredient();
		ingredient.setName("Salt");
		ingredient.setUnit("miligrams");
		ingredient.setQuantity(3);
		ingredient.setRecipeID(4);
		ingredient.setEntryID(2);
	}
	
	@Test
	void createIngredient_shouldCreateIngredient() {
		
		ingredientService.createIngredient(ingredient);
		
		verify(ingredientRepository, times(1)).save(ingredient);
		
	}
	
	@Test
	void readIngredientByEntryID_shouldReturnIngredientIfExists() {
		
		
		when(ingredientRepository.findByEntryID(ingredient.getEntryID())).thenReturn(Optional.of(ingredient));
		
		Ingredient foundIngredient = ingredientService.readIngredientByEntryID(ingredient.getEntryID());
		
		assertNotNull(foundIngredient);
		assertEquals(ingredient.getName(), foundIngredient.getName());
	}
	
	@Test
	void readStepByStepID_shouldReturnNullIfNotExists() {
		
		/*Arrange:
		 * Simulate the scenario where a step doesn't exists in the database.
		 * The mock repository will return an empty Optional.
		 */
		when(ingredientRepository.findByEntryID(ingredient.getEntryID())).thenReturn(Optional.empty());
		
		/*
		 * Act: Calls stepRepository to read user with given stepID
		 */
		Ingredient foundStep = ingredientService.readIngredientByEntryID(ingredient.getEntryID());
		
		/*
		 * Assert:
		 * Check if the returned step is null, indicating that no user with the given ID exists
		 */
		assertNull(foundStep);
	}
	
	
	@Test
	void updateIngredient_shouldUpdateExistingStep() {
		ingredient.setName("Not Salt");
		
		//Act calls the updateIngredient method from the Step service.
		ingredientService.updateIngredient(ingredient);
		
		/*Assert:
		 * Verifies that the save method was called exactly once with updated ingredient object.
		 * This ensures that the ingredient details are updated in the database.
		 */
		verify(ingredientRepository, times(1)).save(ingredient);
		
	}
	
	
	@Test
	void deleteStepByStepID_shouldDeleteStepIfExists() {
		
		
		ingredientService.deleteIngredientByEntryID(ingredient.getEntryID());
		
		
		verify(ingredientRepository, times(1)).deleteByEntryID(ingredient.getEntryID());
	}
	
	@Test
	void deleteStepsByRecipeID_shouldDeleteStepIfExists() {
		
		
		ingredientService.deleteIngredientsByRecipeID(ingredient.getRecipeID());
		
		
		verify(ingredientRepository, times(1)).deleteByRecipeID(ingredient.getRecipeID());
	}
	
	
	
	
}
