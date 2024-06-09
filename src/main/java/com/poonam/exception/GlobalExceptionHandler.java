package com.poonam.exception;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ResourceAlreadyExistException.class)
	@ResponseStatus(code = HttpStatus.CONFLICT)
	public ExceptionResponse ResourceAlreadyExist(ResourceAlreadyExistException ex, HttpServletRequest request) {
		ExceptionResponse response=new ExceptionResponse();
		
		response.setMessage(ex.getMessage());
		response.setPath(request.getRequestURI());
		response.setStatusCode(HttpStatus.CONFLICT);
		response.setTime(LocalDateTime.now());
		
		return response;
		
	}
	@ExceptionHandler(ResourceNotExistsException.class)
	@ResponseStatus(code = HttpStatus.CONFLICT)
	public ExceptionResponse ResourceAlreadyExist(ResourceNotExistsException ex, HttpServletRequest request) {
		ExceptionResponse response=new ExceptionResponse();
		
		response.setMessage(ex.getMessage());
		response.setPath(request.getRequestURI());
		response.setStatusCode(HttpStatus.CONFLICT);
		response.setTime(LocalDateTime.now());
		
		return response;
		
	}
	

}
