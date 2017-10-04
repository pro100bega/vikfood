package com.epam.vikfood.service.exception;

public class RecipeServiceException extends RuntimeException {
	private static final long serialVersionUID = -7824851821067363215L;

	public RecipeServiceException() {
		super();
	}
	
	public RecipeServiceException(String message) {
		super(message);
	}
	
	public RecipeServiceException(Exception e) {
		super(e);
	}
	
	public RecipeServiceException(String message, Exception e) {
		super(message, e);
	}
}
