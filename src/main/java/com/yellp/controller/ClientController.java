package com.yellp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.yellp.entity.Client;
import com.yellp.service.ClientService;

@RestController
public class ClientController {

	@Autowired
	private ClientService clientService;

	@PostMapping("/register")
	public String register(@RequestBody Client client) {
		clientService.registerClient(client);
		return "You have successfully registered";
	}

}
