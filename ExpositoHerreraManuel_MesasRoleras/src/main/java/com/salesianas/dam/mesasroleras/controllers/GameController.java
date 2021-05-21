package com.salesianas.dam.mesasroleras.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.salesianas.dam.mesasroleras.model.Game;
import com.salesianas.dam.mesasroleras.services.GameService;
import com.salesianas.dam.mesasroleras.services.MemberService;
import com.salesianas.dam.mesasroleras.services.ProductService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class GameController {

	private final GameService gameservice;
	private final ProductService productservice;
	private final MemberService memberservice;
	
	@GetMapping("/games")
	public String showGamesSessions(Model model) {
		
		model.addAttribute("gameSessions", gameservice.orderByGameSessionsDate());
		
		model.addAttribute("productsList", productservice.findAll());
		model.addAttribute("membersList", memberservice.findAll());
		model.addAttribute("game", new Game());
		
		return "games";
		
	}
	
	@GetMapping("/games/{id}")
	public String showGameDetails(@PathVariable("id") Long gameId, Model model){
		
		model.addAttribute("game", gameservice.findById(gameId).orElse(null));
		
		return "gamesDetails";
		
	}
	
	@GetMapping("/games/delete/{id}")
	public String delete(@PathVariable("id") Long gameId, Model model) {
		
		Game g = gameservice.findById(gameId).orElse(null);
		gameservice.delete(g);
		return "redirect:/games";
		
	}
	
	
	
	@PostMapping("/games/submit/")
	public String save(@ModelAttribute("game") Game g) {
		
		
		gameservice.save(g);
		return "redirect:/games";
	}
	
	
}
