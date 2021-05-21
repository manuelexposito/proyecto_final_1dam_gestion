package com.salesianas.dam.mesasroleras.services;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.salesianas.dam.mesasroleras.model.Game;
import com.salesianas.dam.mesasroleras.repository.GameRepository;
import com.salesianas.dam.mesasroleras.services.base.BaseService;
@Service
public class GameService extends BaseService<Game, Long, GameRepository>{

	public GameService(GameRepository repository) {
		super(repository);
	}

	
	public List<Game> orderByGameSessionsDate(){
		
		return this.repository.findAll()
							  .stream()
							  .sorted(Comparator.comparing(Game::getDate))
							  .collect(Collectors.toList());
		
	}	
	
	/*
	 * return this.repository.findAll()
							  .stream()
							  .filter(x -> x.getIsPremium().equalsIgnoreCase("true"))
							  .collect(Collectors.toList());
		
	 */
	
}
