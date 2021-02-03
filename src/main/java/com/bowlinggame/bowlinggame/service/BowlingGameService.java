package com.bowlinggame.bowlinggame.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bowlinggame.bowlinggame.exception.ParsingException;
import com.bowlinggame.bowlinggame.model.Game;
import com.bowlinggame.bowlinggame.model.Lane;
import com.bowlinggame.bowlinggame.model.Player;
import com.bowlinggame.bowlinggame.model.Roll;
import com.bowlinggame.bowlinggame.model.Set;
import com.bowlinggame.bowlinggame.parser.*;
import com.bowlinggame.bowlinggame.repository.GameRepository;
import com.bowlinggame.bowlinggame.repository.LaneRepository;
import com.bowlinggame.bowlinggame.repository.PlayerRepository;

/*
 * Service class to redirect the score calculation to the calculator class
 * */

@Service
public class BowlingGameService {

	@Autowired
	private RollParser rollParser;
	
	@Autowired
    private SetParser setParser;
	
	@Autowired
	GameRepository gameRepository;
	
	@Autowired
	PlayerRepository playerRepository;
	
	@Autowired
	LaneRepository laneRepository;
	
	public int createGame(Game game) {
		boolean isLaneValid= laneValidation(game.getPlayers());
		Random rd =  new Random();
		game.setGameId(rd.nextInt());
		gameRepository.save(game);
		List<Player> players=game.getPlayers();
		for(Player p:players)p.setGameId(game.getGameId());
		playerRepository.saveAll(players);
		System.out.println("player details----" + players);
		return game.getGameId();
	}
	
	public boolean deleteGame(int id) {
		if(gameRepository.findById(id)!=null) {
			gameRepository.delete(gameRepository.findById(id));
			return true;
		}
		return false;	
	}
	
    public int scoreOfGame(int gameId,int playerId,Object input)throws Exception{
        List<Roll> parsedRoll = null;
        try {
            parsedRoll = rollParser.parse(input);
        } catch (ParsingException e) {
            e.printStackTrace();
        }
        List<Set> parsedSet = setParser.parse(parsedRoll);
        ScoreCalculatorService calc = new ScoreCalculatorService(parsedSet);
        int score = calc.score();
        int spareCount=0;
        int strikeCount=0;
        int missCount=0;
        for(Set s:parsedSet) {
        	if(s.isSpare())spareCount++;
        	if(s.isStrike())strikeCount++;
        	if(s.getFirstRoll().getNumberOfKnockedPins()==0)missCount++;
        	if(s.getSecondRoll().getNumberOfKnockedPins()==0)missCount++;
        }
        Player p=playerRepository.findById(playerId);
        if(gameId!=p.getGameId())throw new ParsingException("Invalid game Id");
        p.setScore(score);
        p.setRollString(input.toString());
        p.setSpareCount(spareCount);
        p.setStrikeCount(strikeCount);
        p.setMissCount(missCount);
        
        playerRepository.save(p);
        return score;
    }
    
    private boolean laneValidation(List<Player> players) {
    	List<Lane> l=new ArrayList<Lane>();
    	
    	return false;
    }
    
}
