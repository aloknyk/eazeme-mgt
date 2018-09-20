package com.yellp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.yellp.dao.UserRepository;
import com.yellp.entity.ApplicationUser;
import com.yellp.service.UserService;

@Component
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Override
	public void registerClient(ApplicationUser client) {
		client.setPassword(passwordEncoder.encode(client.getPassword()));
		userRepository.save(client);
	}

}
