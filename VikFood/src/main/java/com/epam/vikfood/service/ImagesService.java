package com.epam.vikfood.service;

public interface ImagesService {
	boolean addImage(int recipeId, String title, byte[] image);
	
	boolean deleteImage(int recipeId, String title);
}
