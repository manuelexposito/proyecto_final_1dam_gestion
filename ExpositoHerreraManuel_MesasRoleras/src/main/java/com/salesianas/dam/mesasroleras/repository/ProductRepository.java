package com.salesianas.dam.mesasroleras.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.salesianas.dam.mesasroleras.model.Product;
/**
 * <h1>ProductRepository</h1>
 * 
 * This interface represents the data access object(DAO) for the model {@link Product}. Extends the interface JpaRepository.
 * 
 * @see Product
 * @see JpaRepository
 * 
 * @author Manuel Exposito Herrera
 *
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

}
