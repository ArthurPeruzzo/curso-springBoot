package com.educandoweb.curso.Resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.curso.entities.Category;
import com.educandoweb.curso.services.CategoryService;

@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {
	
	@Autowired //injecao de dependencia
	private CategoryService userService; //dependencia para usar os metodos da classe CategoryService
	
	@GetMapping
	public ResponseEntity<List<Category>> findAll(){
		
		List<Category> list = userService.findAll(); 
		
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")// o {id} faz com que possa colocar um id na url;
	public ResponseEntity<Category> findById(@PathVariable Long id){ // PathVariable aceita o valor que foi passado na url
		
		Category obj = userService.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
