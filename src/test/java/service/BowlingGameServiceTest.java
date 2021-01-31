package service;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import parser.RollParser;
import parser.SetParser;
import parser.StringRollParser;

public class BowlingGameServiceTest {

	StringRollParser rollParser;
    SetParser setParser;
    BowlingGameService gameService;

    @Before
    public void setUp(){
        rollParser = new StringRollParser();
        setParser = new SetParser();
        gameService = new BowlingGameService();
    }
    
    /**
     * testcase1: XXXXXXXXXXXX (12 strikes) expected score equal to 200
     */
    @Test
    public void allStrikes(){
        String input = "XXXXXXXXXXXX";
        assertEquals(gameService.scoreOfGame(input),300);
    }

    /**
     *testcase2: 1$1$1$1$1$1$1$1$1$1$2 (11 spare and last 2) expected score equal to 150
     */
    @Test
    public void allSparesAndLastStrike(){
        String input = "1$1$1$1$1$1$1$1$1$1$2";
        assertEquals(gameService.scoreOfGame(input),150);
    }

    /**
     *testcase3: 11111111111111111111 (20 ones) expected score equal to 20
     */
    @Test
    public void allOnes(){
        String input = "11111111111111111111";
        assertEquals(gameService.scoreOfGame(input),20);
    }

    /**
     *testcase4: 9-9-9-9-9-9-9-9-9-9- (9 for first miss second)expected score equal to 90
     */
    @Test
    public void NinesAndMisses(){
        String input = "9-9-9-9-9-9-9-9-9-9-";
        assertEquals(gameService.scoreOfGame(input),90);
    }

    /**
     *testcase5: 5$5$5$5$5$5$5$5$5$5$5 (5 for first spare second and last 5) expected score equal to 150
     */
    @Test
    public void FiveAndSpareWithFinalFive(){
        String input = "5$5$5$5$5$5$5$5$5$5$5";
        assertEquals(gameService.scoreOfGame(input),150);
    }
}
