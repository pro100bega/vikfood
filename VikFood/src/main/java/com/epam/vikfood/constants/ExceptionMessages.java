package com.epam.vikfood.constants;

public final class ExceptionMessages {
	public static final String RECIPE_ID_IS_LESS_THAN_ZERO = "Recipe id can`t be less than 0";
	
	public static final String RECIPE_DOES_NOT_EXIST = "Recipe does not exist";
	
	public static final String IMAGE_WRITE_ERROR = "Error occured within saving image";
	
	public static final String IMAGE_ALREADY_EXISTS = "Image already exists";
	
	public static final String IMAGE_FILE_DOES_NOT_EXIST = "Image file does not exist";
	
	public static final String IMAGE_COULD_NOT_BE_DELETED = "Image could not be deleted";
	
	private ExceptionMessages() {}
}
