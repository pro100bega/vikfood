package com.epam.vikfood.dao;

import java.util.List;

import com.epam.vikfood.model.Recipe;

public interface RecipeDao {
	boolean checkIfRecipeExists(String recipeTitle);
	
	boolean checkIfRecipeExists(int recipeId);
	
	boolean addRecipe(final Recipe recipe);

	boolean editRecipe(final Recipe recipe);

	Recipe getRecipe(int id);

	List<Recipe> getRecipeList(int offset, int count);
}
