package com.isaiah.main.repositories;

import com.isaiah.main.objects.Comment;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer>  {
	
	//save or update Comment
	<S extends Comment> S save(S comment);
	
	//read operations
	Optional<Comment> findByCommentID(int commentID);
	List<Comment> findCommentsByRecipeID(int recipeID);
	
	//delete operations
	void deleteByCommentID(int commentID);
	void deleteByRecipeID(int recipeID);
	void delete(Comment comment);
	
	

}
