package com.isaiah.main.exceptions;


import java.sql.SQLException;

import org.hibernate.exception.ConstraintViolationException;

public class UniqueUsernameConstraintViolationException extends ConstraintViolationException {
	
	public UniqueUsernameConstraintViolationException(String message, Throwable cause) {
		super(message, (SQLException) cause, "unique_username");
		
	}
	

}
