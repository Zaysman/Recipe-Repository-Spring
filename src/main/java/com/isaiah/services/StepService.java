package com.isaiah.services;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.LinkedList;

import com.isaiah.objects.Step;
import com.isaiah.objects.Recipe;
import com.isaiah.objects.hibernate.HibernateClient;

public class StepService {

	private static HibernateClient HC;

	public static void createStep(Step step) {
		Session session = HC.getSessionFactory().openSession();
		Transaction t = null;

		try {
			t = session.beginTransaction();
			session.save(step);
			t.commit();

		} catch(Exception e) {
			rollbackTransactionIfNotNull(t);
			e.printStackTrace();
			
		} finally {
			session.close();
		}

	}
	
	public static Step readStepByID(int stepID) {
		Session session = HC.getSessionFactory().openSession();
		Transaction t = null;
		Step step = null;
		
		try {
			t = session.beginTransaction();
			step = session.get(Step.class, stepID);
			
			
		} catch(Exception e) {
			rollbackTransactionIfNotNull(t);
			e.printStackTrace();
			
		} finally {
			session.close();
		}
		
		return step;
	}
	
	public static Step readStep(Step step) {
		return readStepByID(step.getStepID());
	}
	
	public static LinkedList<Step> readStepsByRecipeID(int recipeID) {
		Session session = HC.getSessionFactory().openSession();
		Transaction t = null;
		LinkedList<Step> steps = null;
		
		try {
			t = session.beginTransaction();
			Query query = session.createQuery("from steps where recipeID=:recipeID");
			query.setParameter("recipeID", recipeID);
			steps = (LinkedList<Step>) query.list();
			
			
		} catch(Exception e) {
			rollbackTransactionIfNotNull(t);
			e.printStackTrace();
			
		} finally {
			session.close();
		}
		
		return steps;
	}
	
	public static LinkedList<Step> readStepsByRecipe(Recipe recipe) {
		return readStepsByRecipeID(recipe.getRecipeID());
		
	}
	
	public static void updateStepByID(int stepID, Step update) {
		Session session = HC.getSessionFactory().openSession();
		Transaction t = null;
		
		try {
			t = session.beginTransaction();
			Step current = session.get(Step.class, stepID);
			current.setRecipeID(update.getRecipeID());
			current.setStepDesc(update.getStepDesc());
			current.setStepID(update.getStepID());
			current.setStepNote(update.getStepNote());
			current.setStepNum(update.getStepNum());
			
			session.update(current);
			t.commit();
			
			
		} catch(Exception e) {
			rollbackTransactionIfNotNull(t);
			e.printStackTrace();
			
		} finally {
			session.close();
		}
		
	}
	
	public static void updateStep(Step step) {
		updateStepByID(step.getStepID(), step);
	}
	
	public static void deleteStepByID(int stepID) {
		Session session = HC.getSessionFactory().openSession();
		Transaction t = null;
		
		try {
			t = session.beginTransaction();
			Step step = session.get(Step.class, stepID);
			session.delete(step);
			
			t.commit();
			
		} catch(Exception e) {
			rollbackTransactionIfNotNull(t);
			e.printStackTrace();
			
		} finally {
			session.close();
		}
	}
	
	public static void deleteStep(Step step) {
		deleteStepByID(step.getStepID());
	}
	
	public static void deleteStepsByRecipeID(int recipeID) {
		Session session = HC.getSessionFactory().openSession();
		Transaction t = null;
		
		try {
			t = session.beginTransaction();
			Query query = session.createQuery("from steps where recipeID=:recipeID");
			query.setParameter(recipeID, t);
			
			query.executeUpdate();
			
		} catch(Exception e) {
			rollbackTransactionIfNotNull(t);
			e.printStackTrace();
			
		} finally {
			session.close();
		}
		
	}
	
	public static void deleteStepsByRecipe(Recipe recipe) {
		deleteStepsByRecipeID(recipe.getRecipeID());
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
