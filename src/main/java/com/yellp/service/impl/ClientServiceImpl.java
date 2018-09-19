package com.yellp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.yellp.dao.ClientRepository;
import com.yellp.entity.Client;
import com.yellp.service.ClientService;

@Component
public class ClientServiceImpl implements ClientService{

	@Autowired
	private ClientRepository clientRepository;

	@Override
	public void registerClient(Client client) {
		clientRepository.save(client);
	}

}
