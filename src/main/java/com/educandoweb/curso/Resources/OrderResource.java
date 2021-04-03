package com.educandoweb.curso.Resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.curso.entities.Order;
import com.educandoweb.curso.services.OrderService;

@RestController
@RequestMapping(value = "/orders")
public class OrderResource {
	
	@Autowired //injecao de dependencia
	private OrderService OrderService; //dependencia para usar os metodos da classe OrderService
	
	@GetMapping
	public ResponseEntity<List<Order>> findAll(){
		
		List<Order> list = OrderService.findAll(); 
		
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")// o {id} faz com que possa colocar um id na url;
	public ResponseEntity<Order> findById(@PathVariable Long id){ // PathVariable aceita o valor que foi passado na url
		
		Order obj = OrderService.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
