package com.bowlinggame.bowlinggame.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StrikeTest {
    /**
     *Strike(Roll(10))
     *expected numberOfPinsKnockedInFirstRoll equal to 10
     */
    @Test
    public void setOneWithOneStrike(){
        Set set = new Strike(new Roll(10));
        assertEquals(set.numberOfPinsKnockedInFirstRoll(),10);
        assertEquals(set.numberOfKnockedPins(),10);
    }

    /**
     *Strike(Roll(10))
     *expected isSStrike return true
     */
    @Test
    public void setTwoWithOneStrike(){
        Set set = new Strike(new Roll(10));
        assertEquals(set.isStrike(),true);
    }

    /**
     *Strike(Roll(10))
     *expected isSpare return false
     */
    @Test
    public void setThreeWithOneStrike(){
        Set set = new Strike(new Roll(10));
        assertEquals(set.isSpare(),false);
    }
}
