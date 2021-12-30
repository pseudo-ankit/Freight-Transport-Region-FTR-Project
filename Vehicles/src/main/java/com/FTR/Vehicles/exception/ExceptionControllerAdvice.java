package com.FTR.Vehicles.exception;

import java.util.Locale;
import java.util.stream.Collectors;

import com.FTR.Vehicles.dto.Message;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionControllerAdvice {

    @Autowired
    private MessageSource message;

    // @ExceptionHandler(Exception.class)
    // public ResponseEntity<Message> exceptionHandler(Exception e){
    //     Message mssg = new Message(message.getMessage(ExceptionConstants.SERVER_ERROR.toString(), null, Locale.ENGLISH));
    //     return new ResponseEntity<>(mssg, HttpStatus.INTERNAL_SERVER_ERROR);
    // }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<Message> exceptionHandler(InvalidFormatException e){
        return new ResponseEntity<>(new Message(message.getMessage("input.date.invalid", null, Locale.ENGLISH)), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ServiceException.class)
    public ResponseEntity<Message> exceptionHandler(ServiceException e){
        return new ResponseEntity<>(
            new Message(message.getMessage(e.getMessage(), null, Locale.ENGLISH)),
            HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException .class)
	public ResponseEntity<Message> exceptionHandler(MethodArgumentNotValidException ex) {
		Message error = new Message();
		BindingResult result = ex.getBindingResult();
           
        
        error.setMessage(result.getAllErrors()
                                .stream()
                                .map(ObjectError::getDefaultMessage)
                                .collect(Collectors.joining(", ")));
                                
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
