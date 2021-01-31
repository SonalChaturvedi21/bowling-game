package com.bowlinggame.bowlinggame.parser;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

import com.bowlinggame.bowlinggame.model.*;

public class SetFactoryTest {

    SetFactory factory;

    @Before
    public void setUp(){
        factory = new SetFactory();
    }

    /**
     *Two rolls for each one number of knocked pins equal to one - expected one Set with 2 knocked pins
     */
    @Test
    public void oneSetWithTwoKnockedPins(){
        List<Roll> rolls = new ArrayList<Roll>();
        rolls.add(new Roll(1));
        rolls.add(new Roll(1));
        Set set = factory.getSet(rolls,0);
        assertEquals(set.isSpare(),false);
        assertEquals(set.isStrike(),false);
        assertEquals(set.numberOfKnockedPins(),2);

    }

    /**
     *a set of one Strike and expected number of knocked pins equal to 10
     */
    @Test
    public void oneSetWithOneStrike(){
        List<Roll> rolls = new ArrayList<Roll>();
        rolls.add(new Roll(10));
        Set set = factory.getSet(rolls,0);
        assertEquals(set.isStrike(),true);
        assertEquals(set.numberOfKnockedPins(),10);

    }

    /**
     *two rolls, first one 1 knocked pin and second a spare, expected a set of type spare and number of knocked pins equal to 10
     */
    @Test
    public void oneSetWithOneSpare(){
        List<Roll> rolls = new ArrayList<Roll>();
        rolls.add(new Roll(1));
        rolls.add(new Roll(9));
        Set set = factory.getSet(rolls,0);
        assertEquals(set.isSpare(),true);
        assertEquals(set.numberOfKnockedPins(),10);
    }
}