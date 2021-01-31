package com.bowlinggame.bowlinggame.parser;

import java.util.List;

import org.junit.*;
import static org.junit.Assert.assertEquals;

import com.bowlinggame.bowlinggame.exception.ParsingException;
import com.bowlinggame.bowlinggame.model.Roll;

public class StringRollParserTest {

    StringRollParser parser;

    @Before
    public void setUp(){
        parser = new StringRollParser();
    }

    /**
     *testcase1: Only 1 knocked pin
     *expected number of knocked pins equal to 1
     */
    @Test
    public void rollWithOnlyOneKnockedPin(){
        String input = "1";
        int result = parser.knockedPinsOf(0,input);
        assertEquals(result,1);
    }

    /**
     *testcase2: roll With miss
     *expected number of knocked pins equal to 0
     */
    @Test
    public void rollWithMiss(){
        String input = "-";
        int result = parser.knockedPinsOf(0,input);
        assertEquals(result,0);
    }

    /**
     *testcase3: roll with a strike
     *expected number of knocked pins equals to 10
     */
    @Test
    public void rollWithStrike(){
        String input = "X";
        int result = parser.knockedPinsOf(0,input);
        assertEquals(result,10);
    }

    /**
     *testcase4: set with rolls making a spare
     *expected number of knocked pins equal to 1 for the first roll and equal to 9 for the second roll
     */
    @Test
    public void rollsMakingASpare(){
        String input = "1/";
        int resultOfFirstRoll = parser.knockedPinsOf(0,input);
        assertEquals(resultOfFirstRoll,1);
        int resultOfSecondRoll = parser.knockedPinsOf(1,input);
        assertEquals(resultOfSecondRoll,9);
    }

    /**
     *testcase5: one roll with 1 knocked pin
     *      expected  number of knocked pins of the created Roll equal to 1
     */
    @Test
    public void oneRollWithOneKnockedPin(){
        String input = "1";
        Roll roll = parser.createRoll(input,0);
        assertEquals(roll.getNumberOfKnockedPins(),1);
    }

    /**
     *testcase6: roll with one Strike
     *expected number of knocked pins of the created roll equal to 10
     */
    @Test
    public void createRollWithOneStrike(){
        String input = "X";
        Roll roll = parser.createRoll(input,0);
        assertEquals(roll.getNumberOfKnockedPins(),10);
    }

    /**
     *testcase7: set with rolls(1,9)
     *expected number of knocked pins of the first roll equal to 1 and 9 for the second roll
     */
    @Test
    public void setWithRolls1and9(){
        String input = "1/";
        Roll firstRoll = parser.createRoll(input,0);
        assertEquals(firstRoll.getNumberOfKnockedPins(),1);
        Roll secondRoll = parser.createRoll(input,1);
        assertEquals(secondRoll.getNumberOfKnockedPins(),9);
    }



    /**
     *tescase8: 11111111111111111111 (20 ones)
     *expected 20 rolls for each one the number of knocked pins is equal to 1
     */
    @Test
    public void ParseAllOnesInputExpected_20_RolesWithValue_1(){
        String input = "11111111111111111111";
        List<Roll> rolls = null;
        try {
            rolls = parser.parse(input);
        } catch (ParsingException e) {
            Assert.fail();
        }
        assertEquals(rolls.size(),20);
        for(Roll r : rolls)
            assertEquals(r.getNumberOfKnockedPins(),1);
    }

    /**
     *testcase9: -------------------- (20 misses)
     *expected 20 Rolls for each one the number of knocked pins is equal to 0
     */
    @Test
    public void setOfTwentyRollsWithZeroMisses(){
        String input = "--------------------";
        List<Roll> rolls = null;
        try {
            rolls = parser.parse(input);
        } catch (ParsingException e) {
            Assert.fail();
        }
        assertEquals(rolls.size(),20);
        for(Roll r : rolls)
            assertEquals(r.getNumberOfKnockedPins(),0);
    }

    /**
     *testcase10: XXXXXXXXXX (12 strikes)
     *expected 12 rolls for each one the number of knocked pins is equal to 10
     */
    @Test
    public void twelveRollsWithAllStrikes(){
        String input = "XXXXXXXXXXXX";
        List<Roll> rolls = null;
        try {
            rolls = parser.parse(input);
        } catch (ParsingException e) {
            Assert.fail();
        }
        assertEquals(rolls.size(),12);
        for(Roll r : rolls)
            assertEquals(r.getNumberOfKnockedPins(),10);
    }

    /**
     *testcase11: 1$1$1$1$1$1$1$1$1$1$ (one and spares) expected 20 rolls for each one the number of first roll knocked pins is equal to 1 and the number of second Roll knocked pins is equal to 9
     */
    @Test
    public void twentyRollsWith1andSpareInEach(){
        String input = "1$1$1$1$1$1$1$1$1$1$";
        List<Roll> rolls = null;
        try {
            rolls = parser.parse(input);
        } catch (ParsingException e) {
            Assert.fail();
        }
        assertEquals(rolls.size(),20);
        for(int i=0;i < rolls.size();i=i+2){
            assertEquals(rolls.get(i).getNumberOfKnockedPins(),1);
            assertEquals(rolls.get(i+1).getNumberOfKnockedPins(),9);
        }
    }

    /**
     *testcase 12: 1$1$1$1$1$1$1$1$1$1
     *expected ParsingException
     */
    @Test
    public void parsingFailedTest(){
        String input = "1$1$1$1$1$1$1$1$1$1";
        List<Roll> rolls = null;
        try {
            rolls = parser.parse(input);
            Assert.fail();
        } catch (ParsingException e) {
            assertEquals(e.getMessage(),"Input length not valid");
        }
    }

    /**
     *testcase13: XXXXXXXXXXX
     *expected ParsingException
     */
    @Test
    public void parsingFailedTestForElevenStrikes(){
        String input = "XXXXXXXXXXX";
        List<Roll> rolls = null;
        try {
            rolls = parser.parse(input);
            Assert.fail();
        } catch (ParsingException e) {
            assertEquals(e.getMessage(),"Input length not valid");
        }
    }

    /**
     *testcase14: XXXXXXXXXXX$$ (11 strikes and last 2 spares)
     *expected ParsingException
     */
    @Test
    public void parsingExceptionTestForElevenStrikesAndTwoSpares(){
        String input = "XXXXXXXXXXX$$";
        List<Roll> rolls = null;
        try {
            rolls = parser.parse(input);
            Assert.fail();
        } catch (ParsingException e) {
            assertEquals(e.getMessage(),"Input length not valid");
        }
    }
}
