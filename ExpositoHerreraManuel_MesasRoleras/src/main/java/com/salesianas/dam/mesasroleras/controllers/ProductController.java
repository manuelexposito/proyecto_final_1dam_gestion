package com.salesianas.dam.mesasroleras.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import com.salesianas.dam.mesasroleras.model.Product;
import com.salesianas.dam.mesasroleras.services.ProductService;

import lombok.RequiredArgsConstructor;
/**
 * <h1>ProductController</h1>
 * 
 * This class represents the controller for the Product class. It offers a few methods for printing the products on the website.
 * @see Product
 * 
 * @author Manuel Exposito Herrera
 *
 *@version 1.0
 */
@Controller
@RequiredArgsConstructor
public class ProductController {

	
	private final ProductService productservice;
	
	/**
	 * It shows the products on the website.
	 * @param A model so we can use some of its methods.
	 * @return the html page with the list printed on it.
	 */
	@GetMapping("/products")
	public String productsList(Model model) {
		
		
		model.addAttribute("productsList", productservice.findAll());
		model.addAttribute("product", new Product());
		return "indexProducts";
		
	}
	
	
	/**
	 * This method allows us to save a new product.
	 * @param the product
	 * @return redirection to the html page with the game list printed on it
	 */
	@PostMapping("/products/submit")
	public String save(@ModelAttribute("product") Product p) {
		
		productservice.save(p);
		return "redirect:/products";
	}
	
	/**
	 * This method allows us to edit the attributes of a product chosen by id.
	 * @param A long that represents the product id.
	 * @param A model so we can use some of its methods.
	 * @return redirection to the html page with the list printed on it.
	 */
	@GetMapping("/products/edit/{id}")
	public String edit(@PathVariable("id") Long productId, Model model) {
		
		Product editP = productservice.findById(productId).orElse(null);
		
		if(editP != null) {
			model.addAttribute("product", editP);
			return "formProductEdit";
		} else
			return "redirect:/products";
		
	}
	/**
	 * This method will submit the changes on the product chosen by id.
	 * @param the product.
	 * @return redirection to the html page with the list printed on it.
	 */
	@PostMapping("/products/edit/submitEdit")
	public String processEdit(@ModelAttribute("product") Product p) {
		
		productservice.edit(p);
		
		return "redirect:/products";
		
	}
	
	/**
	 * This method allows us to delete a product chosen by id.
	 * @param A long that represents the member id.
	 * @return redirection to the html page with the list printed on it.
	 */
	@GetMapping("/products/delete/{id}")
	public String delete(@PathVariable("id") Long productId) {
		
		Product p = productservice.findById(productId).orElse(null);
		
		productservice.delete(p);
		return "redirect:/products";
	}
	
	
	
}
