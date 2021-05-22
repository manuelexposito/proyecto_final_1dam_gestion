package com.salesianas.dam.mesasroleras.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.salesianas.dam.mesasroleras.model.Game;

/**
 * <h1>GameRepository</h1>
 * 
 * This interface represents the data access object(DAO) for the model {@link Game}. Extends the interface JpaRepository.
 * 
 * @see Game
 * @see JpaRepository
 * 
 * @author Manuel Exposito Herrera
 *
 */
@Repository
public interface GameRepository extends JpaRepository<Game, Long> {

}
