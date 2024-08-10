package com.isaiah.objects;

import jakarta.persistence.*;

@Entity //Every persistent POJO class is an entity and is declared using the @Entity annotation (at class level)
@Table(name = "userLogin", uniqueConstraints = @UniqueConstraint(columnNames = "username")) //Defines the table the object is supposed to use. Hibernate will use the class name as the table name by default.
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //This means we'll use the database to determine the ID for the object
	@Column(name = "userID")
	private int userID;
	
	@Column(name = "username")
	private String username;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "email")
	private String email;
	
	public User() {
		this(-1, "default username", "default password", "default@email.com");
		//Hibernate requires a No-argument constructor
	}
	
	public User(int userID, String username, String password, String email) {
		super();
		this.userID = userID;
		this.username = username;
		this.password = password;
		this.email = email;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "User [userID=" + userID + ", username=" + username + ", password=" + password + ", email=" + email
				+ "]";
	}
	
}
