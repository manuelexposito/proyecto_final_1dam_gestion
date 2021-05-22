package com.salesianas.dam.mesasroleras.services;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.salesianas.dam.mesasroleras.model.Game;
import com.salesianas.dam.mesasroleras.repository.GameRepository;
import com.salesianas.dam.mesasroleras.services.base.BaseService;
/**
 * <h1>GameService</h1>
 * 
 * This class represents the service of the POJO class Game. It will allow us to use the CRUD methods inherited by BaseService.
 * @see BaseService
 * @see GameRepository
 * @see Game
 * @author Manuel Exposito Herrera
 *
 *@version 1.0
 */
@Service
public class GameService extends BaseService<Game, Long, GameRepository>{

	public GameService(GameRepository repository) {
		super(repository);
	}

	/**
	 * This method returns the list of sessions ordered chronologically.
	 * @return the list of sessions ordered chronologically.
	 */
	public List<Game> orderByGameSessionsDate(){
		
		return this.repository.findAll()
							  .stream()
							  .sorted(Comparator.comparing(Game::getDate))
							  .collect(Collectors.toList());
		
	}	
	
	
	
}
