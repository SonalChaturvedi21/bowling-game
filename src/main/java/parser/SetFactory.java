package parser;

import java.util.List;

/*
 * SetFactory class to fetch the set with rolls and index
 * 
 * */

import model.*;

public class SetFactory {
	
	public Set getSet(List<Roll> rolls, int i) {
        Roll firstRoll = rolls.get(i);
        if(firstRoll.getNumberOfKnockedPins() == 10){
            return new Strike(rolls.get(i));
        }
        Roll secondRoll;
        if(i+1 < rolls.size()){
            secondRoll = rolls.get(i+1);
            if(firstRoll.getNumberOfKnockedPins() + secondRoll.getNumberOfKnockedPins() == 10){
                return new Spare(rolls.get(i),rolls.get(i+1));
            }
        }
        else{
            secondRoll = new Roll();
        }

        return new Set(firstRoll,secondRoll);
    }

}
