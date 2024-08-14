package com.isaiah.services;

import com.isaiah.main.objects.Recipe;
import com.isaiah.main.repositories.RecipeRepository;
import com.isaiah.main.services.RecipeService;

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

public class RecipeServiceTests {
	
	@Mock
	private RecipeRepository recipeRepository;
	
	@InjectMocks
	private RecipeService recipeService;
	
	private Recipe recipe;
	
	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
		recipe = new Recipe();
	}
	
	@Test
	void createRecipe_shouldCreateIngredient() {
		
		recipeService.createRecipe(recipe);
		
		verify(recipeRepository, times(1)).save(recipe);
	}
	
	@Test
	void readRecipeByRecipeID_shouldReturnRecipeIfExists() {
		
		when(recipeRepository.findByRecipeID(recipe.getRecipeID())).thenReturn(Optional.of(recipe));
		
		Recipe foundRecipe = recipeService.readRecipeByRecipeID(recipe.getRecipeID());
		
		assertNotNull(foundRecipe);
		assertEquals(recipe.getRecipeTitle(), foundRecipe.getRecipeTitle());
	}
	
	
	@Test
	void readRecipeByRecipeID_ShouldReturnNullIfNotExists() {
		
		when(recipeRepository.findByRecipeID(recipe.getRecipeID())).thenReturn(Optional.empty());
		
		Recipe foundRecipe = recipeService.readRecipeByRecipeID(recipe.getRecipeID());
		
		assertNull(foundRecipe);
		
	}
	
	@Test
	void updateRecipe_shouldUpdateExistingRecipe() {
		recipe.setRecipeTitle("updated Title");
		
		recipeService.updateRecipe(recipe);
		
		verify(recipeRepository, times(1)).save(recipe);
	}
	
	@Test
	void deleteRecipeByRecipeID_shouldDeleteRecipeIfExists() {
		
		recipeService.deleteByRecipeID(recipe.getRecipeID());
		
		verify(recipeRepository, times(1)).deleteByRecipeID(recipe.getRecipeID());
	}
	
	
	
	

}
