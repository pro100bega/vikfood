package com.epam.vikfood.service;

import static com.epam.vikfood.constants.ExceptionMessages.RECIPE_DOES_NOT_EXIST;
import static com.epam.vikfood.constants.ExceptionMessages.IMAGE_WRITE_ERROR;
import static com.epam.vikfood.constants.ExceptionMessages.IMAGE_ALREADY_EXISTS;
import static com.epam.vikfood.constants.ExceptionMessages.IMAGE_FILE_DOES_NOT_EXIST;
import static com.epam.vikfood.constants.ExceptionMessages.IMAGE_COULD_NOT_BE_DELETED;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.epam.vikfood.dao.ImagesDao;
import com.epam.vikfood.dao.RecipeDao;
import com.epam.vikfood.service.exception.ImagesServiceException;

public class ImagesServiceImpl implements ImagesService{

	private static final String IMAGES_ROOT_DIRECTORY = "recipes/";
	
	@Autowired
	private ImagesDao imagesDao;
	
	@Autowired
	private RecipeDao recipeDao;
	
	@Override
	public boolean addImage(int recipeId, String title, byte[] image) {
		boolean recipeExists = recipeDao.checkIfRecipeExists(recipeId);
		
		if (!recipeExists) {
			throw new ImagesServiceException("Recipe id: " + recipeId + ". " + RECIPE_DOES_NOT_EXIST);
		}
		
		final File imageFile = new File(buildFileName(recipeId, title));
		
		if (imageFile.exists()) {
			throw new ImagesServiceException("Image with title: " + title + ". " + IMAGE_ALREADY_EXISTS);
		}
		
		try {
			imageFile.createNewFile();
			
			IOUtils.write(image, new FileOutputStream(imageFile));
		} catch (IOException e) {
			throw new ImagesServiceException(IMAGE_WRITE_ERROR, e);
		}
		
		return imagesDao.addImageToRecipe(recipeId, title);
	}

	@Override
	public boolean deleteImage(int recipeId, String title) {
		boolean recipeExists = recipeDao.checkIfRecipeExists(recipeId);
		
		if (!recipeExists) {
			throw new ImagesServiceException("Recipe id: " + recipeId + ". " + RECIPE_DOES_NOT_EXIST);
		}
		
		final File imageFile = new File(buildFileName(recipeId, title));
		
		if (!imageFile.exists()) {
			throw new ImagesServiceException("Image with title: " + title + ". " + IMAGE_FILE_DOES_NOT_EXIST);
		}
		
		boolean isFileDeleted = imageFile.delete();
		
		if (!isFileDeleted) {
			throw new ImagesServiceException("Image with title: " + title + ". " + IMAGE_COULD_NOT_BE_DELETED);
		}
		
		return imagesDao.deleteRecipeImage(recipeId, title);
	}
	
	private String buildFileName(int recipeId, String title) {
		final StringBuilder fileName = new StringBuilder(IMAGES_ROOT_DIRECTORY);
		
		fileName.append(recipeId);
		fileName.append("/");
		fileName.append(title);
		fileName.append(".jpg");
		
		return fileName.toString();
	}
}
