package com.salesianas.dam.mesasroleras.services.base;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 * <h1>BaseService</h1>
 * This abstract class represents the base structure of each service object for the POJO classes in this application. 
 * It contains the CRUD methods for the POJO classes.
 * 
 * @author Manuel Exposito Herrera
 *
 * @param <T> the data type of the element that will extend this class.
 * @param <ID> the data type of the attribute that will be used as PK.
 * @param <R> the data type of the repository for that object. 
 * 
 * @see MemberService
 * @see ProductService
 * @see GameService
 * 
 * @version 1.0
 */
public abstract class BaseService<T, ID, R extends JpaRepository<T, ID>> {

	@Autowired
	protected R repository;

	public BaseService(R repository) {
		this.repository = repository;
	}

	public T save(T t) {

		return repository.save(t);
	}

	public T edit(T t) {

		return repository.save(t);
	}

	public void delete(T t) {
		repository.delete(t);
	}

	public void deleteById(ID id) {
		repository.deleteById(id);
	}

	public List<T> findAll() {

		return repository.findAll();
	}

	public Optional<T> findById(ID id) {

		return repository.findById(id);
	}

}
