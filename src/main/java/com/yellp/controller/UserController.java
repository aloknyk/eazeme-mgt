package com.yellp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.yellp.entity.ApplicationUser;
import com.yellp.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService clientService;

	@PostMapping("/register")
	public String register(@RequestBody ApplicationUser client) {
		clientService.registerClient(client);
		return "You have successfully registered";
	}

}
