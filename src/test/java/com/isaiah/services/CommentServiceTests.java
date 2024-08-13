package com.isaiah.services;

import com.isaiah.main.objects.Comment;
import com.isaiah.main.repositories.CommentRepository;
import com.isaiah.main.services.CommentService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class CommentServiceTests {

	@Mock
	private CommentRepository commentRepository;

	@InjectMocks
	private CommentService commentService;

	private Comment comment;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
		comment = new Comment();
		comment.setAuthorID(5);
		comment.setCommentContent("This is a comment");
		comment.setCommentID(2);
		comment.setCommentRating(3.0f);
		comment.setRecipeID(4);
	}


	@Test
	void createComment_shouldCreateComment() {

		/* Act:
		 *  call the Create CommentService and create a comment.
		 *  Should only call the save method from CommentRepository once.
		 */
		commentService.createComment(comment);

		/* Assert: 
		 * Verfies that the save method from commentRepository is called exactly once with the comment object as an argument.
		 * Ensures that the proper repository method was called
		 */
		verify(commentRepository, times(1)).save(comment);

	}


	@Test
	void readCommmentByCommentID_shouldReturnCommentIfExists() {

		/* Arrange:
		 * Call the findByCommentID and have it return the comment object 
		 */
		when(commentRepository.findByCommentID(comment.getCommentID())).thenReturn(Optional.of(comment));

		/* Act: 
		 * Calls readCommentByCommentID from CommentService to retrieve the comment object
		 */
		Comment foundComment = commentService.readCommentByCommentID(comment.getCommentID());

		/* Assert:
		 * Check to see if the returned Comment is not null and that the comment Content are the same.
		 */
		assertNotNull(foundComment);
		assertEquals(comment.getCommentContent(), foundComment.getCommentContent());
	}

	@Test
	void readCommmentByCommentID_shouldNotReturnCommentIfExists() {

		/* Arrange:
		 * Call the findByCommentID and have it return a null object 
		 */
		when(commentRepository.findByCommentID(comment.getCommentID())).thenReturn(Optional.empty());

		/* Act: 
		 * Calls readCommentByCommentID from CommentService to retrieve the comment object
		 */
		Comment foundComment = commentService.readCommentByCommentID(comment.getCommentID());

		/* Assert:
		 * Check to see if the returned Comment is not null and that the comment Content are the same.
		 */
		assertNull(foundComment);
		
	}
	
	@Test
	void updateComment_shouldUpdateExistingStep() {
		comment.setCommentContent("Updated Comment Content");
		
		/* Act:
		 * Calls the updateComment method from comment service
		 */
		commentService.updateComment(comment);
		
		/* Assert:
		 * Verifies that the save method was called exactly once with updated comment object.
		 * Ensures that the step details are updated in the database.
		 */
		verify(commentRepository, times(1)).save(comment);
		
	}
	
	@Test 
	void deleteCommentByCommentID_shouldDeleteCommentIfExists() {
		
		/* Act:
		 * Calls the deleteCommentByCommentID to delete Comment
		 */
		commentService.deleteCommentByCommentID(comment.getCommentID());
		
		/*
		 * Assert:
		 * Verifies that the delete method was called exactly once with the correct CommentID
		 * This ensures the correct method from commentRepository is called.
		 */
		verify(commentRepository, times(1)).deleteByCommentID(comment.getCommentID());
	}
	
	@Test 
	void deleteCommentsByRecipeID_shouldDeleteCommentIfExists() {
		
		/* Act:
		 * Calls the deleteCommentByCommentID to delete Comment
		 */
		commentService.deleteCommentsByRecipeID(comment.getRecipeID());
		
		/*
		 * Assert:
		 * Verifies that the delete method was called exactly once with the correct CommentID
		 * This ensures the correct method from commentRepository is called.
		 */
		verify(commentRepository, times(1)).deleteByRecipeID(comment.getRecipeID());
	}

}
