package com.FTR.Terminals.exception;

import java.util.stream.Collectors;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import com.FTR.Terminals.dto.Message;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionControllerAdvice {
    
    @ExceptionHandler(Exception.class)
	public ResponseEntity<Message> exceptionHandler(Exception ex) {
		Message error = new Message();
		error.setMessage(ex.getMessage());
		return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}

    @ExceptionHandler(ServiceException.class)
	public ResponseEntity<Message> exceptionHandler(ServiceException e) {
		Message error = new Message();
		error.setMessage(e.getMessage());
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}

    @ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<Message> exceptionHandler(DataIntegrityViolationException e) {
		Message error = new Message();
		error.setMessage(e.getMessage());
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}

    @ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Message> handleValidationExceptions(MethodArgumentNotValidException ex) {
		Message error = new Message();
		error.setMessage(ex.getBindingResult().getAllErrors().stream().map(ObjectError::getDefaultMessage)
				.collect(Collectors.joining(", ")));
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}

    @ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<Message> handleConstraintValidationExceptions(ConstraintViolationException ex) {
		Message error = new Message();
		error.setMessage(ex.getConstraintViolations().stream().map(ConstraintViolation::getMessage)
				.collect(Collectors.joining(", ")));
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);

	}
}
