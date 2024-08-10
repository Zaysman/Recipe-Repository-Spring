package com.isaiah.services;

import com.isaiah.objects.User;
import com.isaiah.repositories.UserRepository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public void createUser(User user) {
		Optional<User> existingUser = userRepository.findByUsername(user.getUsername());
		if(existingUser.isPresent()) {
			throw new RuntimeException("Username already exists");
		}
		
		userRepository.save(user);
	}
	
	public User readUserByUserID(int userID) {
		return userRepository.findByUserID(userID).orElse(null);
	}
	
	public User readUserByUsername(String username) {
		return userRepository.findByUsername(username).orElse(null);
	}
	
	public void updateUser(User user) {
		userRepository.save(user);
	}
	
	public void deleteUserByUserID(int userID) {
		userRepository.deleteByUserID(userID);
	}
	
	
	
}
