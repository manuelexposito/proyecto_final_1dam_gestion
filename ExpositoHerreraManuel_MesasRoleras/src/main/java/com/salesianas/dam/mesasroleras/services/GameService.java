package com.salesianas.dam.mesasroleras.services;

import org.springframework.stereotype.Service;

import com.salesianas.dam.mesasroleras.model.Game;
import com.salesianas.dam.mesasroleras.repository.GameRepository;
import com.salesianas.dam.mesasroleras.services.base.BaseService;
@Service
public class GameService extends BaseService<Game, Long, GameRepository>{

	public GameService(GameRepository repository) {
		super(repository);
	}

}
