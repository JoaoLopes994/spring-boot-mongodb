package com.joaosilva.workshopmongo.resources.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.joaosilva.workshopmongo.services.exception.ObjectNotFoundException;

@ControllerAdvice
public class ResourceExcepetionHandler {

	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest requestHttp) {
		
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError standardError = new StandardError(System.currentTimeMillis(), status.value() , "Não encontrado", e.getMessage(), requestHttp.getRequestURI());
		return ResponseEntity.status(status).body(standardError);
	}
	
}
