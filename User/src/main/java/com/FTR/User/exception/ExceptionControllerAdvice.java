package com.FTR.User.exception;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.FTR.User.dto.Message;

@RestControllerAdvice
public class ExceptionControllerAdvice {
	
	@Autowired
	private MessageSource messageSource;
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Message> exceptionHandler(Exception e){
		Message error = new Message();
		error.setMessage(e.getMessage());
		return new ResponseEntity<Message>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(ServiceException.class)
	public ResponseEntity<Message> exceptionHandler(ServiceException e){
		Message error = new Message();
		error.setMessage(messageSource.getMessage(e.getMessage(), 
							null, Locale.ENGLISH));
		return new ResponseEntity<Message>(error, HttpStatus.BAD_REQUEST);
	}
	
}
