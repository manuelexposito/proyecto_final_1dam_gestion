package com.salesianas.dam.mesasroleras.services;

import org.springframework.stereotype.Service;

import com.salesianas.dam.mesasroleras.model.Product;
import com.salesianas.dam.mesasroleras.repository.ProductRepository;
import com.salesianas.dam.mesasroleras.services.base.BaseService;
/**
 * <h1>ProductService</h1>
 * 
 * This class represents the service of the POJO class Product. It will allow us to use the CRUD methods inherited by BaseService.
 * @see BaseService
 * @see ProductRepository
 * @see Product
 * @author Manuel Exposito Herrera
 *
 *@version 1.0
 */
@Service
public class ProductService extends BaseService<Product, Long, ProductRepository> {

	public ProductService(ProductRepository repository) {
		super(repository);
		
	}

}
