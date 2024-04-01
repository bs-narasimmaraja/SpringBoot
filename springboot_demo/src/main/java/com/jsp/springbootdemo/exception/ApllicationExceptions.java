package com.jsp.springbootdemo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.jsp.spring_demo.helper.ResponseStructure;

@RestControllerAdvice
public class ApllicationExceptions {

	@ExceptionHandler(value = NoStudentFoundException.class)
	public ResponseStructure<NoStudentFoundException> studentException(NoStudentFoundException nse){
		ResponseStructure<NoStudentFoundException> rs=new ResponseStructure<NoStudentFoundException>();
		rs.setStatuscode(HttpStatus.NOT_FOUND.value());
		rs.setMessage(nse.getMessage());
		rs.setData(nse);
		
		return rs;
		}
}
