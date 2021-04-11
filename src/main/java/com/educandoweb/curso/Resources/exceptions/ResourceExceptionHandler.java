package com.educandoweb.curso.Resources.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.educandoweb.curso.services.exceptions.ResourceNotFoundException;

@ControllerAdvice //intercepta as excecoes para o objeto executar tratamento
public class ResourceExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class) //serve para interceptar execao do tipo resource para cair nesse metodo
	public ResponseEntity<StandardError> ResourceNotFound(ResourceNotFoundException e, HttpServletRequest request){
		
		String error = "Resource not found";
		
		HttpStatus status = HttpStatus.NOT_FOUND;
		
		StandardError er = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
		
		return ResponseEntity.status(status).body(er);
	}
}
