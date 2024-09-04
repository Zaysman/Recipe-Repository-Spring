package com.isaiah.main.objects;



import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "favoritedRecipes")
public class FavoritedRecipe {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "entryID")
	private int entryID;
	
	@Column(name = "userID")
	private int userID; //ID of the user that favorited the recipe
	
	@Column(name = "favoritedRecipeID")
	private int favoritedRecipeID; //ID of the recipe that has been favorited.

}
