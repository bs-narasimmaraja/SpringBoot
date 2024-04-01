package com.jsp.springbootdemo.exception;

public class NoStudentFoundException extends RuntimeException{
	private String message;
	
	@Override
	public String getMessage() {
		return message;
		
	}
	public NoStudentFoundException(String message) {
		this.message=message;
	}


}
