package com.bowlinggame.bowlinggame.model;

/*
 * A strike representing a first roll which knocks all 10 pins 
 * */

public class Strike extends Set {
	
	public Strike(Roll firstRoll) {
        super(firstRoll);
    }

    public boolean isStrike(){
        return true;
    }
}
