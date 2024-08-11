package com.isaiah.main.services;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.isaiah.main.objects.NutritionInfo;
import com.isaiah.main.objects.hibernate.HibernateClient;

public class NutritionInfoService {
	
	private static HibernateClient HC;
	
	public static void createNutritionInfo(NutritionInfo nutritionInfo) {
		Session session = HC.getSessionFactory().openSession();
		Transaction t = null;
		
		try {
			t = session.beginTransaction();
			session.save(nutritionInfo);
			t.commit();
			
		} catch(Exception e) {
			rollbackTransactionIfNotNull(t);
			e.printStackTrace();
			
		} finally {
			session.close();
		}
	}
	
	public static NutritionInfo readNutritionInfoByID(int nutritionID) {
		Session session = HC.getSessionFactory().openSession();
		Transaction t = null;
		NutritionInfo nutritionInfo = null;
		
		try {
			t = session.beginTransaction();
			nutritionInfo = session.get(NutritionInfo.class, nutritionID);
			
			
		} catch(Exception e) {
			rollbackTransactionIfNotNull(t);
			e.printStackTrace();
			
		} finally {
			session.close();
		}
		
		return nutritionInfo;
	}
	
	public static NutritionInfo readNutritionInfo(NutritionInfo nutritionInfo) {
		return readNutritionInfoByID(nutritionInfo.getNutritionID());
	}
	
	public static void updateNutritionInfoByID(int nutritionID, NutritionInfo update) {
		Session session = HC.getSessionFactory().openSession();
		Transaction t = null;
		
		try {
			t = session.beginTransaction();
			NutritionInfo current = session.get(NutritionInfo.class, nutritionID);
			
			current.setCalcium(update.getCalcium());
			current.setCalories(update.getCalories());
			current.setCarbs(update.getCarbs());
			current.setCholesterol(update.getCholesterol());
			current.setIron(update.getIron());
			current.setNutritionID(update.getNutritionID());
			current.setPotassium(update.getPotassium());
			current.setProtein(update.getProtein());
			current.setRecipeID(update.getRecipeID());
			current.setSatFat(update.getSatFat());
			current.setSodium(update.getSodium());
			current.setTransFat(update.getTransFat());
			current.setVitaminA(update.getVitaminA());
			current.setVitaminC(update.getVitaminC());
			current.setVitaminD(update.getVitaminD());
			
			session.update(current);
			t.commit();
			
		} catch(Exception e) {
			rollbackTransactionIfNotNull(t);
			e.printStackTrace();
		
		} finally {
			session.close();
		}
	}
	
	public static void updateNutrition(NutritionInfo nutritionInfo) {
		updateNutritionInfoByID(nutritionInfo.getNutritionID(), nutritionInfo);
		
	}
	
	public static void deleteNutritionInfoByID(int nutritionID) {
		Session session = HC.getSessionFactory().openSession();
		Transaction t = null;
		
		try {
			t = session.beginTransaction();
			NutritionInfo nutritionInfo = session.get(NutritionInfo.class, nutritionID);
			session.delete(nutritionInfo);
			t.commit();
			
		} catch(Exception e) {
			rollbackTransactionIfNotNull(t);
			e.printStackTrace();
			
		} finally {
			session.close();
		}
		
	}
	
	public static void deleteNutritionInfo(NutritionInfo nutritionInfo) {
		deleteNutritionInfoByID(nutritionInfo.getNutritionID());
	}
	
	/*
	 * Utility Method
	 */
	private static void rollbackTransactionIfNotNull(Transaction t) {
		if(t != null) {
			t.rollback();
		}



	}

}
