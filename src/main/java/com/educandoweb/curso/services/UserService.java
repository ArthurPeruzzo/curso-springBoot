package com.educandoweb.curso.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.curso.entities.User;
import com.educandoweb.curso.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository; //dependencia para usar os metodos da classe JpaRepository
	
	
	public List<User> findAll(){//buscar todos os usuarios
		return userRepository.findAll();
	}
	
	public User findById(Long id) {
		
		Optional<User> obj = userRepository.findById(id);
		
		return obj.get();
	}
	
	public User insert(User obj) {
		
		return userRepository.save(obj);
	}
}
