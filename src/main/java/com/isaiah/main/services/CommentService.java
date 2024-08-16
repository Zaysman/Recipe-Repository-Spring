package com.isaiah.main.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

import com.isaiah.main.objects.Comment;
import com.isaiah.main.repositories.CommentRepository;

import jakarta.transaction.Transactional;

@Service
public class CommentService {
	
	@Autowired
	private CommentRepository commentRepository;
	
	public Comment createComment(Comment comment) {
		Comment savedComment = commentRepository.save(comment);
		return savedComment;
	}
	
	public Comment readCommentByCommentID(int commentID) {
		return commentRepository.findByCommentID(commentID).orElse(null);
	}
	
	public List<Comment> readCommentsByRecipeID(int recipeID) {
		return commentRepository.findCommentsByRecipeID(recipeID);
	}
	
	public Comment updateComment(Comment comment) {
		return commentRepository.save(comment);
	}
	
	@Transactional
	public void deleteCommentByCommentID(int commentID) {
		commentRepository.deleteByCommentID(commentID);
	}
	
	@Transactional
	public void deleteCommentsByRecipeID(int recipeID) {
		commentRepository.deleteByRecipeID(recipeID);
	}
	
	
	

}
