package com.epam.vikfood.service.exception;

public class ImagesServiceException extends RuntimeException{
	private static final long serialVersionUID = 6613538240287274439L;

	public ImagesServiceException() {
		super();
	}
	
	public ImagesServiceException(String message) {
		super(message);
	}
	
	public ImagesServiceException(Exception e) {
		super(e);
	}
	
	public ImagesServiceException(String message, Exception e) {
		super(message, e);
	}
}
