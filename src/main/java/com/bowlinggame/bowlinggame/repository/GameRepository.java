package com.bowlinggame.bowlinggame.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.bowlinggame.bowlinggame.model.Game;


public interface GameRepository extends CrudRepository<Game, Integer> {
	
	List<Game> findAll();
	Game findById(int id);
}