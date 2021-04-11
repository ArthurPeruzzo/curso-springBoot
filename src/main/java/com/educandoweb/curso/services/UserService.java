package com.educandoweb.curso.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.educandoweb.curso.entities.User;
import com.educandoweb.curso.repositories.UserRepository;
import com.educandoweb.curso.services.exceptions.DatabaseException;
import com.educandoweb.curso.services.exceptions.ResourceNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository; //dependencia para usar os metodos da classe JpaRepository
	
	
	public List<User> findAll(){//buscar todos os usuarios
		return userRepository.findAll();
	}
	
	public User findById(Long id) {
		
		Optional<User> obj = userRepository.findById(id);
		
		return obj.orElseThrow(()-> new ResourceNotFoundException(id)); // tenta fazer o get, se nao conseguir, lança excecao
	}
	
	public User insert(User obj) {
		
		return userRepository.save(obj);
	}
	
	public void delete(Long id) {
		try {
			userRepository.deleteById(id);
		}catch(EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		}catch(DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
		
	}
	
	public User update(Long id, User obj){
		try {
			User entity = userRepository.getOne(id); //deixa o usuario preparado para ser manipulado, sem ir no banco de dados
			updateData(entity, obj);
			return userRepository.save(entity);
		} catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(User entity, User obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
	}
}
