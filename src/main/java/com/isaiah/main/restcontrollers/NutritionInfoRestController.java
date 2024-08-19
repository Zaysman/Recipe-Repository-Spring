package com.isaiah.main.restcontrollers;

import com.isaiah.main.objects.NutritionInfo;
import com.isaiah.main.services.NutritionInfoService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("nutritioninfo")
public class NutritionInfoRestController {

	@Autowired
	private NutritionInfoService nutritionInfoService;
	
	
	//Get nutritionInfo by nutritionID
	@GetMapping(value = "/getnutritioninfobynutritionid/{nutritionID}", produces = "application/json")
	@CrossOrigin(origins = "http://localhost:3000")
	public NutritionInfo getNutritionInfoByNutritionID(@PathVariable int nutritionID) {
		return nutritionInfoService.readNutritionInfoByNutritionID(nutritionID);
	}
	
	//Get nutritionInfo by recipeID
	@GetMapping(value = "/getnutritioninfobyrecipeid/{recipeID}", produces = "application/json")
	@CrossOrigin(origins = "http://localhost:3000")
	public NutritionInfo getNutritionInfoByRecipeID(@PathVariable int recipeID) {
		return nutritionInfoService.readNutritionInfoByRecipeID(recipeID);
	}
	
	//Post create a new NutritionInfo object
	@PostMapping(value = "/createnutritioninfo", consumes = "application/json", produces = "application/json")
	@CrossOrigin(origins = "http://localhost:3000")
	public NutritionInfo createNutritionInfo(@RequestBody NutritionInfo nutritionInfo) {
		return nutritionInfoService.createNutritionInfo(nutritionInfo);
	}
	
	//Put update NutritionInfo
	@PutMapping(value = "/updatenutritioninfo/{nutritionID}", consumes = "application/json", produces = "application/json")
	@CrossOrigin(origins = "http://localhost:3000")
	public NutritionInfo updateNutritionInfo(@PathVariable int nutritionID, @RequestBody NutritionInfo nutritionInfo) {
		NutritionInfo existingNutritionInfo = nutritionInfoService.readNutritionInfoByNutritionID(nutritionID);
		
		if(existingNutritionInfo != null) {
			existingNutritionInfo.setCalcium(nutritionInfo.getCalcium());
			existingNutritionInfo.setCalories(nutritionInfo.getCalories());
			existingNutritionInfo.setCarbs(nutritionInfo.getCarbs());
			existingNutritionInfo.setCholesterol(nutritionInfo.getCholesterol());
			existingNutritionInfo.setIron(nutritionInfo.getIron());
			existingNutritionInfo.setPotassium(nutritionInfo.getPotassium());
			existingNutritionInfo.setProtein(nutritionInfo.getProtein());
			existingNutritionInfo.setRecipeID(nutritionInfo.getRecipeID());
			existingNutritionInfo.setSatFat(nutritionInfo.getSatFat());
			existingNutritionInfo.setSodium(nutritionInfo.getSodium());
			existingNutritionInfo.setTransFat(nutritionInfo.getTransFat());
			existingNutritionInfo.setVitaminA(nutritionInfo.getVitaminA());
			existingNutritionInfo.setVitaminC(nutritionInfo.getVitaminC());
			existingNutritionInfo.setVitaminD(nutritionInfo.getVitaminD());
			nutritionInfoService.updateNutritionInfo(existingNutritionInfo);
			return existingNutritionInfo;
		} else {
			//handle NutritionInfo not found
			return null;
		}
		
	}
	
	//Delete a NutritionInfo by nutritionID
	@DeleteMapping(value = "/deletenutritioninfo/{nutritionID}")
	@CrossOrigin(origins = "http://localhost:3000")
	public void deleteNutritionInfo(@PathVariable int nutritionID) {
		nutritionInfoService.deleteNutritionInfoByNutritionID(nutritionID);
	}
}
