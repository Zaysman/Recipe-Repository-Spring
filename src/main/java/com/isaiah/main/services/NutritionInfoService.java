package com.isaiah.main.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isaiah.main.objects.NutritionInfo;
import com.isaiah.main.repositories.NutritionInfoRepository;

import jakarta.transaction.Transactional;

@Service
public class NutritionInfoService {
	
	@Autowired
	private NutritionInfoRepository nutritionInfoRepository;
	
	public NutritionInfo createNutritionInfo(NutritionInfo nutritionInfo) {
		return nutritionInfoRepository.save(nutritionInfo);
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
	
	@Transactional
	public void deleteNutritionInfoByNutritionID(int nutritionID) {
		nutritionInfoRepository.deleteByNutritionID(nutritionID);
	}
	
	@Transactional
	public void deleteNutritionInfoByRecipeID(int recipeID) {
		nutritionInfoRepository.deleteByRecipeID(recipeID);
	}
	
	@Transactional
	public void delete(NutritionInfo nutritionInfo) {
		nutritionInfoRepository.delete(nutritionInfo);
	}
	
	
	

}
