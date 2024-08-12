package com.isaiah.main.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isaiah.main.objects.NutritionInfo;
import com.isaiah.main.repositories.NutritionInfoRepository;

@Service
public class NutritionInfoService {
	
	@Autowired
	private NutritionInfoRepository nutritionInfoRepository;
	
	public void createNutritionInfo(NutritionInfo nutritionInfo) {
		nutritionInfoRepository.save(nutritionInfo);
	}
	
	public NutritionInfo readNutritionInfoByNutritionID(int nutritionID) {
		return nutritionInfoRepository.findByNutritionID(nutritionID).orElse(null);
	}
	
	public NutritionInfo readNutritionInfoByRecipeID(int recipeID) {
		return nutritionInfoRepository.findByRecipeID(recipeID).orElse(null);
	}
	
	public NutritionInfo updateNutritionInfo(NutritionInfo nutritionInfo) {
		return nutritionInfoRepository.save(nutritionInfo);
	}
	
	public void deleteNutritionInfoByNutritionID(int nutritionID) {
		nutritionInfoRepository.deleteByNutritionID(nutritionID);
	}
	
	public void deleteNutritionInfoByRecipeID(int recipeID) {
		nutritionInfoRepository.deleteByRecipeID(recipeID);
	}
	
	public void delete(NutritionInfo nutritionInfo) {
		nutritionInfoRepository.delete(nutritionInfo);
	}
	
	
	

}
