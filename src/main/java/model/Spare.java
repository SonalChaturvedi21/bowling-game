package model;

/*
 * A spare class providing if the set(firstroll, secondroll) is making up a spare(sum of 2 rolls knocking 10 pins)
 * */

public class Spare extends Set{
	
	public Spare(Roll firstRoll, Roll secondRoll) {
        super(firstRoll, secondRoll);
    }

    public boolean isSpare(){
        return true;
    }

}
