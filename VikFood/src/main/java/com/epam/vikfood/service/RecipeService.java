package com.epam.vikfood.service;

import java.util.List;

import com.epam.vikfood.model.Recipe;

public interface RecipeService {
	boolean addRecipe(final Recipe recipe, boolean checkRecipe);
	
	boolean editRecipe(final Recipe recipe);
	
	Recipe getRecipe(int id);
	
	List<Recipe> getRecipeList(int offset, int count);
}
