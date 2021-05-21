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

@Controller
@RequiredArgsConstructor
public class ProductController {

	
	private final ProductService productservice;
	
	
	@GetMapping("/products")
	public String productsList(Model model) {
		
		
		model.addAttribute("productsList", productservice.findAll());
		model.addAttribute("product", new Product());
		return "indexProducts";
		
	}
	

	@PostMapping("/products/submit")
	public String save(@ModelAttribute("product") Product p, Model model) {
		
		productservice.save(p);
		return "redirect:/products";
	}
	
	
	@GetMapping("/products/edit/{id}")
	public String edit(@PathVariable("id") Long productId, Model model) {
		
		Product editP = productservice.findById(productId).orElse(null);
		
		if(editP != null) {
			model.addAttribute("product", editP);
			return "formProductEdit";
		} else
			return "redirect:/products";
		
	}
	
	@PostMapping("/products/edit/submitEdit")
	public String processEdit(@ModelAttribute("product") Product p) {
		
		productservice.edit(p);
		
		return "redirect:/products";
		
	}
	
	@GetMapping("/products/delete/{id}")
	public String delete(@PathVariable("id") Long productId) {
		
		Product p = productservice.findById(productId).orElse(null);
		
		productservice.delete(p);
		return "redirect:/products";
	}
	
	
	
}
