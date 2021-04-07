package com.educandoweb.curso.Resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.educandoweb.curso.entities.User;
import com.educandoweb.curso.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	@Autowired //injecao de dependencia
	private UserService service; //dependencia para usar os metodos da classe UserService
	
	@GetMapping
	public ResponseEntity<List<User>> findAll(){
		
		List<User> list = service.findAll(); 
		
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")// o {id} faz com que possa colocar um id na url;
	public ResponseEntity<User> findById(@PathVariable Long id){ // PathVariable aceita o valor que foi passado na url
		
		User obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<User> insert(@RequestBody User obj){//anotation para que o usuario passado seja convertido para objeto
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		
		return ResponseEntity.created(uri).body(obj);
	}
}
