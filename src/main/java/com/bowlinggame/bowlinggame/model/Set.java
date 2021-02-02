package com.bowlinggame.bowlinggame.model;

/**
 * Set class representing a set of 2 rolls first and second 
 * 
 */

public class Set {
	
	private Roll firstRoll;
    private Roll secondRoll;

    public Set(Roll firstRoll,Roll secondRoll){
        this.firstRoll = firstRoll;
        this.secondRoll = secondRoll;
    }
    
    public Set(Roll firstRoll) {
        this.firstRoll = firstRoll;
        this.secondRoll = new Roll();
    }

    public int numberOfKnockedPins() {
        return firstRoll.getNumberOfKnockedPins() + secondRoll.getNumberOfKnockedPins();
    }

    public int numberOfPinsKnockedInFirstRoll() {
        return firstRoll.getNumberOfKnockedPins();
    }

    public boolean isStrike(){
        return false;
    }

    public boolean isSpare(){
        return false;
    }

	@Override
	public String toString() {
		return "Set [firstRoll=" + firstRoll + ", secondRoll=" + secondRoll + "]";
	}

	public Roll getFirstRoll() {
		return firstRoll;
	}

	public void setFirstRoll(Roll firstRoll) {
		this.firstRoll = firstRoll;
	}

	public Roll getSecondRoll() {
		return secondRoll;
	}

	public void setSecondRoll(Roll secondRoll) {
		this.secondRoll = secondRoll;
	}

    
}
