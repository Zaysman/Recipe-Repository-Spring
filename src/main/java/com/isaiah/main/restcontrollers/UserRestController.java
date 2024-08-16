package com.isaiah.main.restcontrollers;

import com.isaiah.main.objects.User;
import com.isaiah.main.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserRestController {
	
	@Autowired
	private UserService userService;
	
	
	//GET user by ID
	@GetMapping(value ="/getuser/{userID}", produces = "application/json")
	public User getUser(@PathVariable int userID) {
		return userService.readUserByUserID(userID);
	}
	
	//POST create a new user
	@PostMapping(value = "/createuser", consumes = "application/json", produces = "application/json")
	public User createUser(@RequestBody User user) {
		user = userService.createUser(user);
		return user;
	}
	
	//Put update user
	@PutMapping(value = "/updateuser/{userID}", consumes = "application/json", produces = "application/json")
	public User updateUser(@PathVariable int userID, @RequestBody User user) {
		User existingUser = userService.readUserByUserID(userID);
		
		if(existingUser != null) {
			existingUser.setUsername(user.getUsername());
			existingUser.setPassword(user.getPassword());
			existingUser.setEmail(user.getEmail());
			userService.updateUser(existingUser);
			return existingUser;
		} else {
			//Handle user not found
			return null;
		}
	}
	
	//Delete a user by ID
	@DeleteMapping(value = "/deleteuser/{userID}")
	public void deleteUser(@PathVariable int userID) {
		userService.deleteUserByUserID(userID);	
	}
	
}
