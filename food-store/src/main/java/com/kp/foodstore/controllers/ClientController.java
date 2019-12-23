package com.kp.foodstore.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kp.foodstore.dao.ClientDao;
import com.kp.foodstore.entities.Client;
import com.kp.foodstore.service.ClientService;

@RestController
@RequestMapping(path="/app/client")
public class ClientController {
	@Autowired 
	ClientService service;
	
	@PostMapping(path="/new")
	public void addClient(@RequestBody ClientDao client) {
		service.add(client);
	}
	
	@GetMapping(path="/get/{id}")
	public Client getClient(@PathVariable Integer id) {
		return service.getClient(id);
	}

}
