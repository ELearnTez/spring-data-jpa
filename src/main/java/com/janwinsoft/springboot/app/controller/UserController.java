package com.janwinsoft.springboot.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.janwinsoft.springboot.app.entity.User;
import com.janwinsoft.springboot.app.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;

	@GetMapping("{id}")
	public ResponseEntity<User> getUserById(@PathVariable int id){
		User user = userService.getUserById(id);
		return ResponseEntity.ok(user);
	}
	
	@GetMapping
	public ResponseEntity<List<User>>  getAllUsers(){
		List<User> users = userService.getAllUsers();
		if(users != null && users.size() >0 ) {
			return ResponseEntity.ok(users);
		}
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	public ResponseEntity<User> saveUser(@RequestBody User user){
		User savedUser = userService.saveUser(user);
		return ResponseEntity.ok(savedUser);
	}
	
	@PutMapping
	public ResponseEntity<User> updateUser(@RequestBody User user){
		User updatedUser = userService.updateUser(user);
		return ResponseEntity.ok(updatedUser);
	}
	
	
	/*@DeleteMapping("{id}")
	public ResponseEntity<String> deleteUser(@PathVariable int id){
		String message = userService.deleteUser(id);
		return ResponseEntity.ok(message);
	}
	
	@RequestMapping(value = "/activate/{id}", method = {RequestMethod.POST, RequestMethod.PUT})
	public  ResponseEntity<String> activateUser(@PathVariable int id){
		String message = userService.activateUser(id);
		return ResponseEntity.ok(message);
	}*/
	
	
}
