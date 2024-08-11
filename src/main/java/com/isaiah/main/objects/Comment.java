package com.isaiah.main.objects;

import jakarta.persistence.*;

@Entity
@Table(name = "comments")
public class Comment {

	@Transient
	private User author;
	
	@Column(name = "commentContent")
	private String commentContent;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "commentID")
	private int commentID;
	
	@Column(name = "recipeID")
	private int recipeID;
	
	@Column(name = "authorID")
	private int authorID;
	
	@Column(name = "commentRating")
	private float commentRating;
	
	public Comment() {
		this(new User(), "Default Comment", -1, -1, 0.0f);
	}
	
	public Comment(User author, String commentContent, int commentID, int recipeID, float commentRating) {
		super();
		this.author = author;
		this.commentContent = commentContent;
		this.commentID = commentID;
		this.recipeID = recipeID;
		this.commentRating = commentRating;
	}

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

	public int getAuthorID() {
		return authorID;
	}

	public void setAuthorID(int authorID) {
		this.authorID = authorID;
	}

	public String getCommentContent() {
		return commentContent;
	}

	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}

	public int getCommentID() {
		return commentID;
	}

	public void setCommentID(int commentID) {
		this.commentID = commentID;
	}

	public int getRecipeID() {
		return recipeID;
	}

	public void setRecipeID(int recipeID) {
		this.recipeID = recipeID;
	}

	public float getCommentRating() {
		return commentRating;
	}

	public void setCommentRating(float commentRating) {
		this.commentRating = commentRating;
	}

	@Override
	public String toString() {
		return "Comment [author=" + author + ", commentContent=" + commentContent + ", commentID=" + commentID
				+ ", recipeID=" + recipeID + ", commentRating=" + commentRating + "]";
	}
	
	
	
}
