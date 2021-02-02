package com.bowlinggame.bowlinggame.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bowlinggame.bowlinggame.model.Player;
import com.bowlinggame.bowlinggame.service.PlayerService;

/*
 * Player Contoller to provide APIs for get and post calls for a Player(id, name, lane allotted)
 * 
 * */

@RestController
@RequestMapping("/api")
public class PlayerController {
	
		@Autowired
	    PlayerService playerService;

	    @GetMapping("/players")
	    private List<Player> getAllPlayers() {
	    	System.out.println("------ \n\n\n players controller");
	        return playerService.getAllPlayers();
	    }

	    @GetMapping("/players/{id}")
	    private Player getPlayer(@PathVariable("id") int id) {
	        return playerService.getPlayerById(id);
	    }
	    
	    @PostMapping("/players")
	    private int savePerson(@RequestBody Player player) {
	        playerService.saveOrUpdate(player);
	        return player.getId();
	    }
	    
	    
	    
    
}
