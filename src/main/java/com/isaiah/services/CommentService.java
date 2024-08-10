package com.isaiah.services;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.LinkedList;

import com.isaiah.objects.Comment;
import com.isaiah.objects.Recipe;
import com.isaiah.objects.hibernate.HibernateClient;

public class CommentService {
	
	private static HibernateClient HC;
	
	public static void createComment(Comment comment) {
		Session session = HC.getSessionFactory().openSession();
		Transaction t = null;
		
		try {
			t = session.beginTransaction();
			session.save(comment);
			t.commit();
			
		} catch(Exception e) {
			rollbackTransactionIfNotNull(t);
			e.printStackTrace();
			
			
		} finally {
			session.close();
		}
		
	}
	
	public static Comment readCommentByID(int commentID) {
		Session session = HC.getSessionFactory().openSession();
		Transaction t = null;
		Comment comment = null;
		
		try {
			t = session.beginTransaction();
			comment = session.get(Comment.class, commentID);
			t.commit();
			
		} catch(Exception e) {
			rollbackTransactionIfNotNull(t);
			e.printStackTrace();
			
		} finally {
			session.close();
		}
		
		return comment;
	}
	
	public static Comment readComment(Comment comment) {
		return readCommentByID(comment.getCommentID());
	}
	
	public static LinkedList<Comment> readCommentsByRecipeID(int recipeID) {
		LinkedList<Comment> comments = null;
		Session session = HC.getSessionFactory().openSession();
		Transaction t = null;
		
		try {
			t = session.beginTransaction();
			Query query = session.createQuery("from comments where recipeID=:recipeID");
			query.setParameter("recipeID", recipeID);
			comments = (LinkedList<Comment>) query.list();
			
		} catch(Exception e) {
			rollbackTransactionIfNotNull(t);
			e.printStackTrace();
			
		} finally {
			session.close();
		}
		
		return comments;
	}
	
	public static LinkedList<Comment> readCommentsByRecipe(Recipe recipe) {
		return readCommentsByRecipeID(recipe.getRecipeID());
	}
	
	
	public static void updateCommentByID(int commentID, Comment update) {
		Session session = HC.getSessionFactory().openSession();
		Transaction t = null;
		
		try {
			t = session.beginTransaction();
			Comment current = session.get(Comment.class, commentID);
			current.setAuthorID(update.getAuthorID());
			current.setCommentContent(update.getCommentContent());
			current.setCommentID(commentID);
			current.setCommentRating(update.getCommentRating());
			current.setRecipeID(update.getRecipeID());
			
			session.update(current);
			t.commit();
			
			
		} catch(Exception e) {
			rollbackTransactionIfNotNull(t);
			e.printStackTrace();
		} finally {
			session.close();
		}
		
	}
	
	public static void updateComment(Comment comment) {
		updateCommentByID(comment.getCommentID(), comment);
	}
	
	
	
	public static void deleteCommentByID(int commentID) {
		Session session = HC.getSessionFactory().openSession();
		Transaction t = null;
		
		try {
			t = session.beginTransaction();
			Comment comment = session.get(Comment.class, commentID);
			session.delete(comment);
			
			t.commit();
			
		} catch(Exception e) {
			rollbackTransactionIfNotNull(t);
			e.printStackTrace();
			
		} finally {
			session.close();
		}
	}
	
	public static void deleteComment(Comment comment) {
		deleteCommentByID(comment.getCommentID());
	}
	
	public static void deleteCommentsByRecipeID(int recipeID) {
		Session session = HC.getSessionFactory().openSession();
		Transaction t = null;
		
		try {
			t = session.beginTransaction();
			Query query = session.createQuery("from comments where recipeID=:recipeID");
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
	
	public static void deleteCommentsByRecipe(Recipe recipe) {
		deleteCommentsByRecipeID(recipe.getRecipeID());
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
