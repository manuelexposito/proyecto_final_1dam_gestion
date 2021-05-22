package com.salesianas.dam.mesasroleras.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <h1>Product</h1>
 * This class represents the products that the club will offer to their members, for buying or renting out.
 * 
 * @author Manuel Exposito Herrera
 *
 *
 *
 *@version 1.0
 */
@Data
@NoArgsConstructor
@Entity
public class Product {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	private String name, publisher, image;
	private double price;
	private int numPlayers;
	
	public Product(String name, String publisher, String image, double price, int numPlayers) {
		super();
		this.name = name;
		this.publisher = publisher;
		this.image = image;
		this.price = price;
		this.numPlayers = numPlayers;
	}
	
	
	
}
