package com.isaiah.main.repositories;

import com.isaiah.main.objects.NutritionInfo;

import java.util.Optional;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NutritionInfoRepository extends JpaRepository<NutritionInfo, Integer> {
	
	//save or update NutritionInfo
	<S extends NutritionInfo> S save(S nutritionInfo);
	
	//read operations
	Optional<NutritionInfo> findByNutritionID(int nutritionID);
	Optional<NutritionInfo> findByRecipeID(int recipeID);
	
	//delete operations
	void deleteByNutritionID(int nutritionID);
	void deleteByRecipeID(int recipeID);
	void delete(NutritionInfo nutritionInfo);

}
