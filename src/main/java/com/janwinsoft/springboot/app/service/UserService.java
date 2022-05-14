package com.janwinsoft.springboot.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.janwinsoft.springboot.app.entity.User;
import com.janwinsoft.springboot.app.exception.UserNotFoundException;
import com.janwinsoft.springboot.app.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;

	public User getUserById(int id) {
		return userRepository.findById(id)
				.orElseThrow(() -> new UserNotFoundException("User Not Found With Id "+id, 1001));
	}

	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	public User saveUser(User user) {
		return userRepository.saveAndFlush(user);
	}

	public User updateUser(User user) {
		this.getUserById(user.getId());
		return userRepository.saveAndFlush(user);
	}
	

}
