package com.bowlinggame.bowlinggame.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bowlinggame.bowlinggame.service.BowlingGameService;

/*
 * Score calculator controller to provide API for resultant score for entered input rolls string
 * */

@RestController
@RequestMapping("/score")
public class ScoreCalculatorContoller {
	
	@Autowired
	BowlingGameService bowlingGameService;
	
	@GetMapping("/{input}")
    private int getScore(@PathVariable("input") String input) {
        return bowlingGameService.scoreOfGame(input);
    }

}
