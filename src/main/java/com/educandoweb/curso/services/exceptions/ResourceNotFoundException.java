package com.educandoweb.curso.services.exceptions;

public class ResourceNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	public ResourceNotFoundException(Object id) { //tratamento para quando digitar um id que nao existe
		super("Resource not found id " + id);
	}

}
