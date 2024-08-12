package com.isaiah.main.repositories;

import com.isaiah.main.objects.Recipe;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Integer> {
	
	//save or update recipe
	<S extends Recipe> S save(S Recipe);
	
	//read operations
	Optional<Recipe> findByRecipeID(int recipeID);
	
	//delete operations
	void deleteByRecipeID(int recipeID);
	void delete(Recipe recipe);
	
	

}
