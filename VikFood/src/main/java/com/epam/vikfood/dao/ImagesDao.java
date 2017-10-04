package com.epam.vikfood.dao;

public interface ImagesDao {
	boolean addImageToRecipe(int recipeId, String title);
	
	boolean deleteRecipeImage(int recipeId, String title);
}
