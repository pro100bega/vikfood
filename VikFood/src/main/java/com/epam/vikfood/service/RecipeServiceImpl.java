package com.epam.vikfood.service;

import static com.epam.vikfood.constants.ExceptionMessages.RECIPE_ID_IS_LESS_THAN_ZERO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.vikfood.dao.RecipeDao;
import com.epam.vikfood.model.Recipe;
import com.epam.vikfood.service.exception.RecipeServiceException;

@Service
public class RecipeServiceImpl implements RecipeService {

	@Autowired
	private RecipeDao recipeDao;

	@Override
	public boolean addRecipe(final Recipe recipe, final boolean checkRecipe) {
		// TODO validation logic and logging

		if (checkRecipe) {
			boolean exists = recipeDao.checkIfRecipeExists(recipe.getTitle());

			if (exists) {
				return false;
			}
		}

		return recipeDao.addRecipe(recipe);
	}

	@Override
	public boolean editRecipe(final Recipe recipe) {
		// TODO validation logic and logging

		return recipeDao.editRecipe(recipe);
	}

	@Override
	public Recipe getRecipe(final int id) {
		// TODO logging
		
		if (id < 0) {
			throw new RecipeServiceException("Id passed: " + id + ". " + RECIPE_ID_IS_LESS_THAN_ZERO);
		}

		return recipeDao.getRecipe(id);
	}

	@Override
	public List<Recipe> getRecipeList(int offset, int count) {
		// TODO logging
		
		offset = offset < 0 ? 0 : offset;

		count = count > 50 ? 50 : count;

		return recipeDao.getRecipeList(offset, count);
	}
}
