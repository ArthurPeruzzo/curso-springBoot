package com.educandoweb.curso.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.curso.entities.Order;
import com.educandoweb.curso.repositories.OrderRepository;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository OrderRepository; //dependencia para usar os metodos da classe JpaRepository
	
	
	public List<Order> findAll(){//buscar todos os usuarios
		return OrderRepository.findAll();
	}
	
	public Order findById(Long id) {
		
		Optional<Order> obj = OrderRepository.findById(id);
		
		return obj.get();
	}
}
