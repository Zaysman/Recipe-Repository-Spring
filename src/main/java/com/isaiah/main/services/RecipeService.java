package com.isaiah.main.services;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.isaiah.main.objects.Recipe;
import com.isaiah.main.objects.hibernate.HibernateClient;

public class RecipeService {
	
	private static HibernateClient HC;
	
	public static void createRecipe(Recipe recipe) {
		Session session = HC.getSessionFactory().openSession();
		Transaction t = null;
		
		try {
			t = session.beginTransaction();
			session.save(recipe);
			t.commit();
			
		} catch (Exception e) {
			rollbackTransactionIfNotNull(t);
			e.printStackTrace();
			
		} finally {
			session.close();
		}
	}
	
	public static Recipe readRecipeByID(int recipeId) {
		Recipe recipe = null;
		Session session = HC.getSessionFactory().openSession();
		Transaction t = null;
		
		try {
			t = session.beginTransaction();
			recipe = session.get(Recipe.class, recipeId);
		
		} catch(Exception e) {
			rollbackTransactionIfNotNull(t);
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return recipe;
		
	}

	public static Recipe readRecipe(Recipe recipe) {
		return readRecipeByID(recipe.getRecipeID());
	}
	
	public static void updateRecipeById(int recipeId, Recipe updateRecipe) {
		Session session = HC.getSessionFactory().openSession();
		Transaction t = null;
		
		try {
			t = session.beginTransaction();
			Recipe recipe = session.get(Recipe.class, recipeId);
			recipe.setServSize(updateRecipe.getServSize());
			recipe.setDifflvl(updateRecipe.getDifflvl());
			recipe.setRating(updateRecipe.getRating());
			recipe.setRecipeTitle(updateRecipe.getRecipeTitle());
			recipe.setRecipeDesc(updateRecipe.getRecipeDesc());
			recipe.setCuisineType(updateRecipe.getCuisineType());
			recipe.setPrepTime(updateRecipe.getPrepTime());
			recipe.setCookTime(updateRecipe.getCookTime());
			recipe.setTotalTime(updateRecipe.getTotalTime());
			recipe.setAuthorId(updateRecipe.getAuthorId());
			recipe.setNutritionInfoId(updateRecipe.getNutritionInfoId());
			
			session.update(recipe);
			t.commit();
			
		} catch(Exception e) {
			rollbackTransactionIfNotNull(t);
			e.printStackTrace();
			
		} finally {
			session.close();
		}
		
	}
	
	public static void updateRecipe(Recipe recipe) {
		updateRecipeById(recipe.getRecipeID(), recipe);
		
	}
	
	public static void deleteRecipeById(int recipeId) {
		Session session = HC.getSessionFactory().openSession();
		Transaction t = null;
		
		try {
			t = session.beginTransaction();
			Recipe recipe = session.get(Recipe.class, recipeId);
			session.delete(recipe);
			t.commit();
			
		} catch(Exception e) {
			rollbackTransactionIfNotNull(t);
			e.printStackTrace();
		
		} finally {
			session.close();
		}
	}
	
	public static void deleteRecipe(Recipe r) {
		deleteRecipeById(r.getRecipeID());
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
