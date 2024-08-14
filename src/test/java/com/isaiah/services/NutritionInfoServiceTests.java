package com.isaiah.services;

import com.isaiah.main.objects.NutritionInfo;
import com.isaiah.main.repositories.NutritionInfoRepository;
import com.isaiah.main.services.NutritionInfoService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class NutritionInfoServiceTests {
	
	@Mock
	private NutritionInfoRepository nutritionInfoRepository;
	
	@InjectMocks
	private NutritionInfoService nutritionInfoService;
	
	private NutritionInfo nutritionInfo;
	
	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
		nutritionInfo = new NutritionInfo();
	}
	
	@Test
	void createNutritionInfo_shouldCreateNutritionInfo() {
		
		nutritionInfoService.createNutritionInfo(nutritionInfo);
		
		verify(nutritionInfoRepository, times(1)).save(nutritionInfo);
	}
	
	@Test
	void readNutritionInfoByNutritionID_shouldReturnNutritionInfoIfExists() {
		when(nutritionInfoRepository.findByNutritionID(nutritionInfo.getNutritionID())).thenReturn(Optional.of(nutritionInfo));
		
		NutritionInfo foundNutritionInfo = nutritionInfoService.readNutritionInfoByNutritionID(nutritionInfo.getNutritionID());
		
		assertNotNull(foundNutritionInfo);
		assertEquals(nutritionInfo.getRecipeID(), foundNutritionInfo.getRecipeID());
	}
	
	@Test
	void readNutritionInfoByNutritionID_shouldReturnNullIfNotExists() {
		when(nutritionInfoRepository.findByNutritionID(nutritionInfo.getNutritionID())).thenReturn(Optional.empty());
		
		NutritionInfo foundNutritionInfo = nutritionInfoService.readNutritionInfoByNutritionID(nutritionInfo.getNutritionID());
		
		assertNull(foundNutritionInfo);
	}
	
	@Test
	void updateRecipe_shouldUpdateExistingNutritionInfo() {
		nutritionInfo.setProtein(1);
		
		nutritionInfoService.updateNutritionInfo(nutritionInfo);
		
		verify(nutritionInfoRepository, times(1)).save(nutritionInfo);
	}
	
	
	@Test
	void deleteNutritionInfoByNutritionID_shouldDeleteNutritionInfoIfExists() {
		
		nutritionInfoService.deleteNutritionInfoByNutritionID(nutritionInfo.getNutritionID());
		
		verify(nutritionInfoRepository, times(1)).deleteByNutritionID(nutritionInfo.getNutritionID());
	}

	
	@Test
	void deleteNutritionInfoByRecipeID_shouldDeleteNutritionInfoIfExists() {
		
		nutritionInfoService.deleteNutritionInfoByRecipeID(nutritionInfo.getRecipeID());
		
		verify(nutritionInfoRepository, times(1)).deleteByRecipeID(nutritionInfo.getRecipeID());;
	}

}
