package com.isaiah.main.repositories;

import com.isaiah.main.objects.Step;

import java.util.Optional;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StepRepository extends JpaRepository<Step, Integer> {

	//save or update user
	<S extends Step> S save(S step);
	
	//read operations
	Optional<Step> findByStepID(int ID);
	List<Step> findStepsByRecipeID(int recipeID);
	
	//delete operations
	void deleteByStepID(int stepID);
	void deleteByRecipeID(int recipeID);
	void delete(Step step);
}
