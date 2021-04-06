package com.educandoweb.curso.Resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.curso.entities.Product;
import com.educandoweb.curso.services.ProductService;

@RestController
@RequestMapping(value = "/products")
public class ProductResource {
	
	@Autowired //injecao de dependencia
	private ProductService service; //dependencia para usar os metodos da classe ProductService
	
	@GetMapping
	public ResponseEntity<List<Product>> findAll(){
		
		List<Product> list = service.findAll(); 
		
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")// o {id} faz com que possa colocar um id na url;
	public ResponseEntity<Product> findById(@PathVariable Long id){ // PathVariable aceita o valor que foi passado na url
		
		Product obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
