package com.kp.foodstore.repository;

import java.util.Optional;
import java.util.Set;

import org.springframework.data.repository.CrudRepository;

import com.kp.foodstore.entities.Client;

public interface ClientRepository extends CrudRepository<Client, Integer> {

	<T extends Client> T save(T entity);
	
	Optional<Client> findById(Integer primaryKey);
	
	Set<Client> findAll();
	
}
