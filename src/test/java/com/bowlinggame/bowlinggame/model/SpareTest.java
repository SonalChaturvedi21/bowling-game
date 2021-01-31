package com.bowlinggame.bowlinggame.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SpareTest {
    /**
     *Spare(Roll(1),Roll(9))
     *expected numberOfPinsKnockedInFirstRoll equal to 10
     */
    @Test
    public void setTestMakingASpareOne(){
        Set set = new Spare(new Roll(1),new Roll(9));
        assertEquals(set.numberOfPinsKnockedInFirstRoll(),1);
        assertEquals(set.numberOfKnockedPins(),10);
    }

    /**
     *Spare(Roll(1),Roll(9))
     *expected isSpare return true
     */
    @Test
    public void setTestMakingASpareTwo(){
        Set set = new Spare(new Roll(1),new Roll(9));
        assertEquals(set.isSpare(),true);
    }

    /**
     *Spare(Roll(1),Roll(9))
     *expected isStrike return false
     */
    @Test
    public void setTestForAStrike(){
        Set set = new Spare(new Roll(1),new Roll(9));
        assertEquals(set.isStrike(),false);
    }
}
