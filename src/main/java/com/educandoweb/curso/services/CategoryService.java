package com.educandoweb.curso.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.curso.entities.Category;
import com.educandoweb.curso.repositories.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository CategoryRepository; //dependencia para usar os metodos da classe JpaRepository
	
	
	public List<Category> findAll(){//buscar todos os usuarios
		return CategoryRepository.findAll();
	}
	
	public Category findById(Long id) {
		
		Optional<Category> obj = CategoryRepository.findById(id);
		
		return obj.get();
	}
}
