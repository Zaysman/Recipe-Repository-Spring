package com.isaiah.main.repositories;

import com.isaiah.main.objects.Ingredient;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, Integer> {
	
	//save or update
	<S extends Ingredient> S save(S Ingredient);
	
	//read operations
	Optional<Ingredient> findByEntryID(int ingredientID); 
	List<Ingredient> findIngredientsByRecipeID(int recipeID);
	
	//delete operations
	void deleteByEntryID(int ingredientID);
	void deleteByRecipeID(int recipeID);
	void delete(Ingredient ingredient);
	

}
