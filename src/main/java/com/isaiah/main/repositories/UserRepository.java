package com.isaiah.main.repositories;

import com.isaiah.main.objects.User;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	
	//save or update user
	<S extends User> S save(S user);
	
	//Read operations
	Optional<User> findByUserID(int userID);
	Optional<User> findByUsername(String username);
	Optional<User> findByEmail(String email);
	List<User> findAll();

	//delete operations
	void deleteByUserID(int userID);

	void deleteByUsername(String username);
	
	void delete(User user);
}
