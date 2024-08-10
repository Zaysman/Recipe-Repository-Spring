package com.isaiah.services;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.LinkedList;

import com.isaiah.objects.Ingredient;
import com.isaiah.objects.Recipe;
import com.isaiah.objects.hibernate.HibernateClient;

public class IngredientService {
	
	private static HibernateClient HC;

	public static void createIngredient(Ingredient i) {
		Session session = HC.getSessionFactory().openSession();
		Transaction t = null;
		
		try {
			t = session.beginTransaction();
			session.save(i);
			t.commit();
			
			
		} catch(Exception e) {
			rollbackTransactionIfNotNull(t);
			e.printStackTrace();
		} finally {
			session.close();
		}
		
	}
	
	public static Ingredient readIngredientByEntryID(int entryID) {
		Ingredient ingredient = null;
		Session session = HC.getSessionFactory().openSession();
		Transaction t = null;
		
		try {
			t = session.beginTransaction();
			ingredient = session.get(Ingredient.class, entryID);
			
			
		} catch(Exception e) {
			rollbackTransactionIfNotNull(t);
			e.printStackTrace();
			
		} finally {
			session.close();
		}
		
		return ingredient;
	}
	
	public static Ingredient readIngredient(Ingredient ingredient) {
		return readIngredientByEntryID(ingredient.getEntryID());
	}
	
	public static LinkedList<Ingredient> readIngredientsByRecipeID(int recipeId) {
		LinkedList<Ingredient> ingredients = null;
		Session session = HC.getSessionFactory().openSession();
		Transaction t = null;
		
		try {
			t = session.beginTransaction();
			Query query = session.createQuery("from Ingredient where recipeID=:recipeID");
			query.setParameter("recipeId", recipeId);
			ingredients = (LinkedList<Ingredient>) query.list();
			
			
		} catch(Exception e) {
			rollbackTransactionIfNotNull(t);
			e.printStackTrace();
			
		} finally {
			session.close();
		}
		
		
		return ingredients;
	}
	
	public static LinkedList<Ingredient> readIngredientsByRecipe(Recipe recipe) {
		return readIngredientsByRecipeID(recipe.getRecipeID());
	}
	
	public static void updateIngredientByEntryID(int entryID, Ingredient update) {
		Session session = HC.getSessionFactory().openSession();
		Transaction t = null;
		
		try {
			t = session.beginTransaction();
			Ingredient current = session.get(Ingredient.class, entryID);
			current.setEntryID(update.getEntryID());
			current.setName(update.getName());
			current.setQuantity(update.getQuantity());
			current.setRecipeID(update.getRecipeID());
			current.setUnit(update.getUnit());
			
			session.update(current);
			t.commit();
			
			
		} catch(Exception e) {
			rollbackTransactionIfNotNull(t);
			e.printStackTrace();
			
			
		} finally {
			session.close();
		}
		
	}
	
	public static void updateIngredient(Ingredient ingredient) {
		updateIngredientByEntryID(ingredient.getEntryID(), ingredient);
	}
	
	
	
	public static void deleteIngredientByEntryID(int entryID) {
		Session session = HC.getSessionFactory().openSession();
		Transaction t = null;
		
		try {
			t = session.beginTransaction();
			Ingredient i = session.get(Ingredient.class, entryID);
			session.delete(i);
			
			t.commit();
			
			
		} catch(Exception e) {
			rollbackTransactionIfNotNull(t);
			e.printStackTrace();
			
		} finally {
			session.close();
		}
	}
	
	public static void deleteIngredient(Ingredient ingredient) {
		deleteIngredientByEntryID(ingredient.getEntryID());
	}
	
	public static void deleteIngredientsByRecipeID(int recipeID) {
		Session session = HC.getSessionFactory().openSession();
		Transaction t = null;
		
		try {
			t = session.beginTransaction();
			Query query = session.createQuery("delete from ingredients where recipeID=:recipeID");
			query.setParameter("recipeID", recipeID);
			
			query.executeUpdate();
			t.commit();
			
			
		} catch(Exception e) {
			rollbackTransactionIfNotNull(t);
			e.printStackTrace();
			
		} finally {
			session.close();
		}
	}
	
	public static void deleteIngredientsByRecipe(Recipe recipe) {
		deleteIngredientsByRecipeID(recipe.getRecipeID());
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
