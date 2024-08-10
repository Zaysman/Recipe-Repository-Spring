package com.isaiah.services;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.query.Query;

import com.isaiah.objects.User;
import com.isaiah.objects.hibernate.HibernateClient;
import com.isaiah.exceptions.UniqueUsernameConstraintViolationException;

import java.sql.SQLIntegrityConstraintViolationException;
import jakarta.persistence.PersistenceException;

public class UserService {

	private static HibernateClient HC;
	
	public static void createUser(User user) throws UniqueUsernameConstraintViolationException {
		Session session = HC.getSessionFactory().openSession();
		Transaction transaction = null;
		
		try {
			transaction = session.beginTransaction();
			
			session.save(user);
			transaction.commit();
			System.out.println("user successfully added via UserService:\n" + user);
		} catch(PersistenceException pe) {
			System.out.println("Caught PersistenceException. Handling");
			rollbackTransactionIfNotNull(transaction);
			Throwable cause = pe.getCause();
			
			if(cause instanceof SQLIntegrityConstraintViolationException) {
				System.out.println("Caught SQLIntegrityConstraintViolationException");
				throw new UniqueUsernameConstraintViolationException("Username already exists", cause);

			}
			
		} catch(Exception e) {
			
			rollbackTransactionIfNotNull(transaction);
			e.printStackTrace();
			
		} finally {
			session.close();
		}
		
		
		
	}
	
	
	public static User readUserByID(int userID) {
		User user = null;
		Session session = HC.getSessionFactory().openSession();
		Transaction transaction = null;
		
		try {
			transaction = session.beginTransaction();
			user = session.get(User.class, userID);
			
		} catch(Exception e) {
			rollbackTransactionIfNotNull(transaction);
			e.printStackTrace();
			
		} finally {
			session.close();
		}
		
		//System.out.println("Successfully read and retrieved User ID: " + user.getUserID() + " from DB via Hibernate");
		
		return user;
	}
	
	public static User readUserByUsername(String username) {
		User user = null;
		Session session = HC.getSessionFactory().openSession();
		Transaction transaction = null;
		
		try {
			transaction = session.beginTransaction();
			Query query = session.createQuery("from User where username=:username"); //Make sure that entity name, in this case User, needs to match the class name, not table name
			query.setParameter("username", username);
			List<User> userList = query.list();
			user = userList.getFirst();
			
		} catch(Exception e) {
			rollbackTransactionIfNotNull(transaction);
			e.printStackTrace();
			
		} finally {
			session.close();
		}
		
		return user;
	}
		
	public static User readUser(User user){
		return readUserByID(user.getUserID());
		
	}
	
	public static void updateUsernameByID(int userID, String updateUsername) {
		Session session = HC.getSessionFactory().openSession();
		Transaction transaction = null;
		
		try {
			transaction = session.beginTransaction();
			User user = session.get(User.class, userID);
			user.setUsername(updateUsername);
			session.update(user);
			transaction.commit();
			
			
		} catch(Exception e) {
			
			rollbackTransactionIfNotNull(transaction);
			e.printStackTrace();
			
		} finally {
			session.close();
		}
		
	}
	
	public static void updateUsername(User user) {
		updateUsernameByID(user.getUserID(), user.getUsername());
	}
	
	public static void updatePasswordByID(int userID, String updatePassword) {
		Session session = HC.getSessionFactory().openSession();
		Transaction transaction = null;
		
		try {
			transaction = session.beginTransaction();
			User user = session.get(User.class, userID);
			user.setPassword(updatePassword);
			session.update(user);
			transaction.commit();
			
		} catch(Exception e) {
			rollbackTransactionIfNotNull(transaction);
			e.printStackTrace();
		} finally {
			session.close();
		}
		
	}
	
	public static void updatePassword(User user) {
		updatePasswordByID(user.getUserID(), user.getPassword());
	}
	
	
	public static void updateEmailByID(int userID, String updateEmail) {
		Session session = HC.getSessionFactory().openSession();
		Transaction transaction = null;
		
		try {
			transaction = session.beginTransaction();
			User user = session.get(User.class, userID);
			user.setEmail(updateEmail);
			session.update(user);
			transaction.commit();
			
		} catch(Exception e) {
			rollbackTransactionIfNotNull(transaction);
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	
	public static void updateEmail(User user) {
		updateEmailByID(user.getUserID(), user.getEmail());
		
	}
	
	
	public static void deleteUserById(int userID) {
		Session session = HC.getSessionFactory().openSession();
		Transaction transaction = null;
		
		try {
			transaction = session.beginTransaction();
			User user = session.get(User.class, userID);
			session.delete(user);
			transaction.commit();
			
			
		} catch(Exception e) {
			rollbackTransactionIfNotNull(transaction);
			e.printStackTrace();
		} finally {
			session.close();
		}
		
	}
	
	public static void deleteUser(User user) {
		deleteUserById(user.getUserID());
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
