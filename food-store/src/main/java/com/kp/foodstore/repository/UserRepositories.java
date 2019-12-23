package com.kp.foodstore.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.kp.foodstore.entities.AppOperator;

public interface UserRepositories extends CrudRepository<AppOperator, Integer>{
	
	Optional<AppOperator> findById(Integer id);

	<S extends AppOperator> S save(S entity);

}
