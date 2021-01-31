package com.bowlinggame.bowlinggame.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bowlinggame.bowlinggame.exception.ParsingException;
import com.bowlinggame.bowlinggame.model.Roll;
import com.bowlinggame.bowlinggame.model.Set;
import com.bowlinggame.bowlinggame.parser.*;

/*
 * Service class to redirect the score calculation to the calculator class
 * */

@Service
public class BowlingGameService {

	@Autowired
	private RollParser rollParser;
	
	@Autowired
    private SetParser setParser;


    public int scoreOfGame(Object input){
        List<Roll> parsedRoll = null;
        try {
            parsedRoll = rollParser.parse(input);
        } catch (ParsingException e) {
            e.printStackTrace();
        }
        List<Set> parsedFrame = setParser.parse(parsedRoll);
        ScoreCalculatorService calc = new ScoreCalculatorService(parsedFrame);
        int score = calc.score();
        return score;
    }
    
}
