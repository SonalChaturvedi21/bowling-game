package com.bowlinggame.bowlinggame.model;

/*
 * Roll class representing a roll object which signifies one ball roll of a set(consisting of two rolls)
 * */
public class Roll {

	private int numberOfKnockedPins;

    public Roll(int numberOfKnockedPins) {
        this.numberOfKnockedPins = numberOfKnockedPins;
    }

    public Roll(){
        this.numberOfKnockedPins = 0;
    }

    public int getNumberOfKnockedPins() {
        return numberOfKnockedPins;
    }

	@Override
	public String toString() {
		return "Roll [numberOfKnockedPins=" + numberOfKnockedPins + "]";
	}
    
}
