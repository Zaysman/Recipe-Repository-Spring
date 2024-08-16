package com.isaiah.main.services;

import com.isaiah.main.objects.Step;
import com.isaiah.main.objects.Recipe;
import com.isaiah.main.repositories.StepRepository;

import jakarta.transaction.Transactional;

import java.util.Optional;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class StepService {

	@Autowired
	private StepRepository stepRepository;
	
	
	public Step createStep(Step step) {
		return stepRepository.save(step);
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
	
	@Transactional
	public void deleteStepByStepID(int stepID) {
		stepRepository.deleteByStepID(stepID);
	}
	
	@Transactional
	public void deleteStepsByRecipeID(int recipeID) {
		stepRepository.deleteByRecipeID(recipeID);
	}
	
	@Transactional
	public void delete(Step step) {
		stepRepository.delete(step);
	}
	
	
}
