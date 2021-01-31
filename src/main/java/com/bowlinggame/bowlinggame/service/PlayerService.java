package com.bowlinggame.bowlinggame.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bowlinggame.bowlinggame.model.Player;
import com.bowlinggame.bowlinggame.repository.PlayerRepository;

/*
 * Service class to provide/store player details directed from the controller to repository
 * */

@Service
public class PlayerService {
	
	@Autowired
	PlayerRepository playerRepository;
	
	 public List<Player> getAllPlayers() {
	        List<Player> players = new ArrayList<Player>();
	        playerRepository.findAll().forEach(player -> players.add(player));
	        return players;
	    }

	    public Player getPlayerById(int id) {
	        return playerRepository.findById(id);
	    }
	    
	    public void saveOrUpdate(Player player) {
	        playerRepository.save(player);
	    }

}
