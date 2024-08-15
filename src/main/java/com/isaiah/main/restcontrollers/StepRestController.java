package com.isaiah.main.restcontrollers;

import com.isaiah.main.objects.Step;
import com.isaiah.main.services.StepService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("step")
public class StepRestController {

	@Autowired
	private StepService stepService;
	
	
	//GET step by stepID
	@GetMapping(value = "/getstepbystepid/{stepID}", produces = "application/json")
	public Step getStepByStepID(@PathVariable int stepID) {
		return stepService.readStepByStepID(stepID);
	}
	
	//GET step by recipeID
	@GetMapping(value = "/getstepsbyrecipeid/{recipeID}", produces = "application/json")
	public List<Step> getStepsByRecipeID(@PathVariable int recipeID) {
		return stepService.readStepsByRecipeID(recipeID);
	}
	
	//Post create new recipe
	@PostMapping(value = "/createstep", consumes = "application/json", produces = "application/json")
	public Step createStep(@RequestBody Step step) {
		stepService.createStep(step);
		return step;
	}
	
	//Put update step
	@PutMapping(value = "/updatestep/{stepID}", consumes = "application/json", produces = "application/json")
	public Step updateStep(@PathVariable int stepID, @RequestBody Step step) {
		Step existingStep = stepService.readStepByStepID(stepID);
		
		if(existingStep != null) {
			existingStep.setRecipeID(step.getRecipeID());
			existingStep.setStepDesc(step.getStepDesc());
			existingStep.setStepNote(step.getStepNote());
			existingStep.setStepNum(step.getStepNum());
			stepService.updateStep(existingStep);
			return existingStep;
		} else {
			//handle step not found
			return null;
		}
	}
	
	
	//Delete a step by stepID
	@DeleteMapping(value = "/deletestep/{stepID}")
	public void deleteStep(@PathVariable int stepID) {
		stepService.deleteStepByStepID(stepID);
	}
}
