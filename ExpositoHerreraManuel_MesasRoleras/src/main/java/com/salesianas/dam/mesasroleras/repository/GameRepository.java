package com.salesianas.dam.mesasroleras.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.salesianas.dam.mesasroleras.model.Game;
@Repository
public interface GameRepository extends JpaRepository<Game, Long> {

}
