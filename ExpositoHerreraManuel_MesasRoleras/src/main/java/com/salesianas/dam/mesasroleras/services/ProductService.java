package com.salesianas.dam.mesasroleras.services;

import org.springframework.stereotype.Service;

import com.salesianas.dam.mesasroleras.model.Product;
import com.salesianas.dam.mesasroleras.repository.ProductRepository;
import com.salesianas.dam.mesasroleras.services.base.BaseService;
@Service
public class ProductService extends BaseService<Product, Long, ProductRepository> {

	public ProductService(ProductRepository repository) {
		super(repository);
		
	}

}
