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
/**
 * <h1>GameController</h1>
 * 
 * This class represents the controller for the Game class. It offers a few methods for printing the game sessions on the website.
 * @see Game
 * 
 * @author Manuel Exposito Herrera
 * 
 * 
 *@version 1.0
 */
@Controller
@RequiredArgsConstructor
public class GameController {

	private final GameService gameservice;
	private final ProductService productservice;
	private final MemberService memberservice;
	
	/**
	 * It shows the sessions on the website.
	 * @param A model so we can use some of its methods.
	 * @return the html page with the list printed on it.
	 */
	@GetMapping("/games")
	public String showGamesSessions(Model model) {
		
		model.addAttribute("gameSessions", gameservice.orderByGameSessionsDate());
		
		model.addAttribute("productsList", productservice.findAll());
		model.addAttribute("membersList", memberservice.findAll());
		//this will allow us to add a new session with the modal, instead of using a getMapping method specifically for adding the new game session
		model.addAttribute("game", new Game());
		
		return "games";
		
	}
	/**
	 * It shows the specifications of one session, which is chosen by id.
	 * @param A long that represents the game id.
	 * @param A model so we can use some of its methods.
	 * @return the html page with the details of the game session.
	 */
	@GetMapping("/games/{id}")
	public String showGameDetails(@PathVariable("id") Long gameId, Model model){
		
		model.addAttribute("game", gameservice.findById(gameId).orElse(null));
		
		return "gamesDetails";
		
	}
	/**
	 * This method will delete one session, which is chosen by id.
	 * @param A long that represents the game id.
	 * @param A model so we can use some of its methods.
	 * @return  redirection to the html page with the game list printed on it
	 */
	@GetMapping("/games/delete/{id}")
	public String delete(@PathVariable("id") Long gameId, Model model) {
		
		Game g = gameservice.findById(gameId).orElse(null);
		gameservice.delete(g);
		return "redirect:/games";
		
	}
	
	
	/**
	 * This method allows us to save a new game session.
	 * @param the game session
	 * @return redirection to the html page with the game list printed on it
	 */
	@PostMapping("/games/submit")
	public String save(@ModelAttribute("game") Game g) {
		
		gameservice.save(g);
		return "redirect:/games";
	}
	
	
}
