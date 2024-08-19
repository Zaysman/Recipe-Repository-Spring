package com.isaiah.main.restcontrollers;

import com.isaiah.main.objects.Comment;
import com.isaiah.main.services.CommentService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("comment")
public class CommentRestController {
	
	@Autowired
	private CommentService commentService;
	
	
	//Get comment by commentID
	@GetMapping(value = "/getcommentbycommentid/{commentID}")
	@CrossOrigin(origins = "http://localhost:3000")
	public Comment getComment(@PathVariable int commentID) {
		return commentService.readCommentByCommentID(commentID);
	}
	
	//Get comments by recipeID
	@GetMapping(value = "getcommentsbyrecipeid/{recipeID}")
	@CrossOrigin(origins = "http://localhost:3000")
	public List<Comment> getComments(@PathVariable int recipeID) {
		return commentService.readCommentsByRecipeID(recipeID);
	}
	
	
	//Post create a new comment
	@PostMapping(value = "/createcomment", consumes = "application/json", produces = "application/json")
	@CrossOrigin(origins = "http://localhost:3000")
	public Comment createComment(@RequestBody Comment comment) {
		return commentService.createComment(comment);
	}
	
	//Put update comment
	@PutMapping(value = "/updatecomment/{commentID}", consumes = "application/json", produces = "application/json")
	@CrossOrigin(origins = "http://localhost:3000")
	public Comment updateComment(@PathVariable int commentID, @RequestBody Comment comment) {
		Comment existingComment = commentService.readCommentByCommentID(commentID);
		
		if(existingComment != null) {
			existingComment.setAuthorID(comment.getAuthorID());
			existingComment.setCommentContent(comment.getCommentContent());
			existingComment.setCommentRating(comment.getCommentRating());
			existingComment.setRecipeID(comment.getRecipeID());
			return commentService.updateComment(existingComment);
			//return existingComment;
		} else {
			
			return null;
		}	
	}
	
	//Delete a comment by ID
	@DeleteMapping(value = "/deletecomment/{commentID}")
	@CrossOrigin(origins = "http://localhost:3000")
	public void deleteComment(@PathVariable int commentID) {
		commentService.deleteCommentByCommentID(commentID);
	}

}
