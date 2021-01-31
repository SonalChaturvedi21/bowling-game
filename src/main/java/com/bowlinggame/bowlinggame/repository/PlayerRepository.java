package com.bowlinggame.bowlinggame.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.bowlinggame.bowlinggame.model.Player;


public interface PlayerRepository extends CrudRepository<Player, Integer> {
	
	List<Player> findAll();
	Player findById(int id);
}
