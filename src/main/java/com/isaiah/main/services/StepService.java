package com.isaiah.main.services;

import com.isaiah.main.objects.Step;
import com.isaiah.main.objects.Recipe;
import com.isaiah.main.repositories.StepRepository;

import java.util.Optional;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class StepService {

	@Autowired
	private StepRepository stepRepository;
	
	
	public void createStep(Step step) {
		stepRepository.save(step);
	}
	
	public Step readStepByStepID(int StepID) {
		return stepRepository.findByStepID(StepID).orElse(null);		
	}
	
	public List<Step> readStepsByRecipeID(int recipeID) {
		return stepRepository.findStepsByRecipeID(recipeID);
	}
	
	public Step updateStep(Step step) {
		return stepRepository.save(step);
	}
	
	public void deleteStepByStepID(int stepID) {
		stepRepository.deleteByStepID(stepID);
	}
	
	public void deleteStepsByRecipeID(int recipeID) {
		stepRepository.deleteByRecipeID(recipeID);
	}
	
	public void delete(Step step) {
		stepRepository.delete(step);
	}
	
	
}
