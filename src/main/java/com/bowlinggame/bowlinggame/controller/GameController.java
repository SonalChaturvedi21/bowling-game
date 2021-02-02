package com.bowlinggame.bowlinggame.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bowlinggame.bowlinggame.model.Game;
import com.bowlinggame.bowlinggame.service.BowlingGameService;

@RestController
@RequestMapping("/bowling-game")
public class GameController {
	
	@Autowired
	BowlingGameService gameService;
	
	@RequestMapping(value = "/startGame", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    public ResponseEntity<Integer> startGame(@RequestBody Game game) {
        gameService.createGame(game);
        return ResponseEntity.status(HttpStatus.OK).body(game.getGameId()); 
    }
	
	@RequestMapping(value = "/deleteGame/{id}", method = RequestMethod.DELETE, produces = "application/json")
    public ResponseEntity<String> deleteGame(@PathVariable(value = "id") int id) {
        if (gameService.deleteGame(id)) {
            return ResponseEntity.status(HttpStatus.OK).body(new String("The game with given id is deleted successfully"));
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new String("There is no game with given id."));
    }
}
