package com.example.demo.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(MyCustomeException.class)
	public ResponseEntity<?> handleEmployeeNotFoundException(MyCustomeException ex,WebRequest req){
		ErrorInfo err = new ErrorInfo(new Date(),ex.getMessage(),req.getDescription(true));
		
		ResponseEntity<ErrorInfo> error = new ResponseEntity<ErrorInfo>(err,HttpStatus.NOT_FOUND);
		return error;
		
	}
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> handleEmployeeNotFoundException(ResourceNotFoundException res,WebRequest req){
		ErrorInfo err = new ErrorInfo(new Date(),res.getMessage(),req.getDescription(true));
		
		ResponseEntity<ErrorInfo> error = new ResponseEntity<ErrorInfo>(err,HttpStatus.BAD_REQUEST);
		return error;
		
	}
	

}
