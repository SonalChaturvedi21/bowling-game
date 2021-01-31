package model;

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

}
