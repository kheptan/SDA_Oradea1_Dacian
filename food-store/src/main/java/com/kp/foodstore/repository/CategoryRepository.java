package com.kp.foodstore.repository;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.kp.foodstore.entities.Category;

public interface CategoryRepository extends CrudRepository<Category, Integer> {
	
	<S extends Category> S save(S entity);
	
	Optional<Category> findById(Integer primaryKey);
	
	List<Category> findAll();

	void deleteById(Integer id);
	
	@Query("select c from Category c where id in ?1")
    List<Category> findByIdIn(List<Integer> keys);	
}
