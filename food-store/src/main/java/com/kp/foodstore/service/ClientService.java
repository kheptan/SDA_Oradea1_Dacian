package com.kp.foodstore.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kp.foodstore.dao.ClientDao;
import com.kp.foodstore.entities.Client;
import com.kp.foodstore.repository.ClientRepository;

@Service
public class ClientService {
	
	@Autowired
	ClientRepository repository;
	
	public void add(ClientDao clnt) {
		Client client = new Client();
		client.setAddress(clnt.getAddress());
		client.setName(clnt.getName());
		client.setPhone(clnt.getPhone());
		repository.save(client);
	}

	public Client getClient(Integer id) {
		Optional<Client> client  = repository.findById(id);
		if(client.isPresent()) {
			return client.get();
		} else {
			return null;
		}
	}
}
