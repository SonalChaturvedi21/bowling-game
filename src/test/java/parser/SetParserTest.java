package parser;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

import exception.ParsingException;
import model.*;

public class SetParserTest {

    List<Roll> rolls;
    StringRollParser rollParser;

    @Before
    public void setUp(){
        rollParser = new StringRollParser();
        rolls = null;
    }

    /**
     *testcase1: 11111111111111111111
     *expected number of created sets equal to 10 and for each set the number of knocked pins equals to 2
     */
    @Test
    public void setOfTenSetsWithTwoKnockedPinsInEach(){
        String input = "11111111111111111111";
        try {
            rolls = rollParser.parse(input);
        } catch (ParsingException e) {
            Assert.fail();
        }
        SetParser setParser = new SetParser();
        List<Set> allSets = setParser.parse(rolls);
        assertEquals(allSets.size(),10);
        for(Set set : allSets){
            assertEquals(set.numberOfKnockedPins(),2);
        }
    }

    /**
     *testcase2:  -------------------- (all misses)
     *expected  number of created sets equal to 10 and for each set the number of knocked pins equals to 0
     */
    @Test
    public void setOfTenSetsWithAllMisses(){
        String input = "--------------------";
        try {
            rolls = rollParser.parse(input);
        } catch (ParsingException e) {
            Assert.fail();
        }
        SetParser setParser = new SetParser();
        List<Set> allSets = setParser.parse(rolls);
        assertEquals(allSets.size(),10);
        for(Set set : allSets){
            assertEquals(set.numberOfKnockedPins(),0);
        }
    }

    /**
     *testcase3: XXXXXXXXXXXX
     *expected number of sets equal to 11 and for each set the number of knocked pins equal to 10
     */
    @Test
    public void setOfElevenSetsWithStrikesInAll(){
        String input = "XXXXXXXXXXXX";
        try {
            rolls = rollParser.parse(input);
        } catch (ParsingException e) {
            Assert.fail();
        }
        SetParser setParser = new SetParser();
        List<Set> allSets = setParser.parse(rolls);
        assertEquals(allSets.size(),12);
        for(Set set : allSets){
            assertEquals(set.numberOfKnockedPins(),10);
        }
    }

    /**
     *testcase4: 1$1$1$1$1$1$1$1$1$1$2
     *expected number of sets equals to 11 and for each set the number of knocked pins equals to 10 with last 2
     */
    @Test public void setOfElevenSetsWithTenKnockedPinsInEachWithLastTwo(){
        String input = "1$1$1$1$1$1$1$1$1$1$2";
        try {
            rolls = rollParser.parse(input);
        } catch (ParsingException e) {
            Assert.fail();
        }
        SetParser setParser = new SetParser();
        List<Set> allSets = setParser.parse(rolls);
        assertEquals(allSets.size(),11);
        for(int i=0;i<allSets.size()-1;i++)
            assertEquals(allSets.get(i).numberOfKnockedPins(),10);
        assertEquals(allSets.get(allSets.size()-1).numberOfKnockedPins(),2);
    }

    /**
     *testcase5: XXXXXXXXXXX2
     *expected number of sets equal to 12 and for each set the number of knocked pins equals to 10 and the last one equal to 2
     */
    @Test public void setOfTwelveSetsEachWithTenKnockedPinsAndLastTwo(){
        String input = "XXXXXXXXXXX2";
        try {
            rolls = rollParser.parse(input);
        } catch (ParsingException e) {
            Assert.fail();
        }
        SetParser setParser = new SetParser();
        List<Set> allSets = setParser.parse(rolls);
        assertEquals(allSets.size(),12);
        for(int i=0;i<allSets.size()-1;i++)
            assertEquals(allSets.get(i).numberOfKnockedPins(),10);
        assertEquals(allSets.get(allSets.size()-1).numberOfKnockedPins(),2);
    }
}