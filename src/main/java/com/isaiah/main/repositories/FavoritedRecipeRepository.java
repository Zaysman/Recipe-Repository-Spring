package com.isaiah.main.repositories;

import com.isaiah.main.objects.FavoritedRecipe;

import java.util.Optional;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FavoritedRecipeRepository extends JpaRepository<FavoritedRecipe, Integer> {
	
	//save or update recipe
	<S extends FavoritedRecipe> S save(S FavoritedRecipe);
	
	//read operations
	Optional<FavoritedRecipe> findByEntryID(int entryID);
	List<FavoritedRecipe> findByUserID(int userID);
	
	//delete operations
	void deleteByEntryID(int entryID);
	void delete(FavoritedRecipe favoritedRecipe);

	
	
}
