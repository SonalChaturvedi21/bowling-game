package com.bowlinggame.bowlinggame.parser;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.bowlinggame.bowlinggame.model.*;

/*
 * Set parser class to be given an input of rolls and output a list of sets
 * */

@Component
public class SetParser {
	
	public List<Set> parse(List<Roll> rolls) {
        int numberOfRoll=0;
        ArrayList<Set> frames = new ArrayList<Set>();
        SetFactory factory = new SetFactory();
        while (numberOfRoll < rolls.size()){
            Set currentFrame =factory.getSet(rolls,numberOfRoll);
            if(currentFrame.isStrike()){
            	numberOfRoll++;
            }
            else{
            	numberOfRoll = numberOfRoll + 2;
            }
            frames.add(currentFrame);
        }

        return frames;
    }

}
