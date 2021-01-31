package model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SetTest {

    /**
     * Set Test class to test a Set with no strike or spare and 1 pin knocked in each roll
     */
    @Test
    public void setWithOneKnockedPinInEachRoll(){
        Set set = new Set(new Roll(1),new Roll(1));
        assertEquals(set.numberOfPinsKnockedInFirstRoll(),1);
        assertEquals(set.numberOfKnockedPins(),2);
        assertEquals(set.isStrike(),false);
        assertEquals(set.isSpare(),false);

    }

}
