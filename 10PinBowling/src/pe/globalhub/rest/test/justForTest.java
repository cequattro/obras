package pe.globalhub.rest.test;

import static org.junit.Assert.*;

import org.junit.Test;

public class justForTest {

	@Test
	public void InitialTestByWilly() {
		TenPinBowlingGame bg= new TenPinBowlingGame("7/");
		int result=(bg.oneFrameScore("7/"));
		assertEquals(10,result);
	}
	
	@Test
    public void should_7_oneFrameScore_miss(){
        String input="7-";
        int expect=7;
        TenPinBowlingGame TenPinBowlingGame = new TenPinBowlingGame(input);
        int result = TenPinBowlingGame.oneFrameScore(input);
        assertEquals(expect,result);
    }

    @Test
    public void should_10_oneFrameScore_spare(){
        String input="7/";
        int expect=10;
        TenPinBowlingGame TenPinBowlingGame = new TenPinBowlingGame(input);
        int result = TenPinBowlingGame.oneFrameScore(input);
        assertEquals(expect,result);
    }
    @Test
    public void should_X_oneFrameScore_strike(){
        String input="X";
        int expect=10;
        TenPinBowlingGame TenPinBowlingGame = new TenPinBowlingGame(input);
        int result = TenPinBowlingGame.oneFrameScore(input);
        assertEquals(expect,result);
    }

    @Test
    public void should_20_oneFrameScore_XX(){
        String input="XX";
        int expect=20;
        TenPinBowlingGame TenPinBowlingGame = new TenPinBowlingGame(input);
        int result = TenPinBowlingGame.oneFrameScore(input);
        assertEquals(expect,result);
    }
    @Test
    public void should_6_oneFrameScore_6(){
        String input="6";
        int expect=6;
        TenPinBowlingGame TenPinBowlingGame = new TenPinBowlingGame(input);
        int result = TenPinBowlingGame.oneFrameScore(input);
        assertEquals(expect,result);
    }
    @Test
    public void should_16_oneFrameScore_X6(){
        String input="X6";
        int expect=16;
        TenPinBowlingGame TenPinBowlingGame = new TenPinBowlingGame(input);
        int result = TenPinBowlingGame.oneFrameScore(input);
        assertEquals(expect,result);
    }
    @Test
    public void should_7_oneTurnScore_miss(){
        String input="7-";
        int expect=7;
        TenPinBowlingGame TenPinBowlingGame = new TenPinBowlingGame(input);
        int result = TenPinBowlingGame.oneTurnScore(0);
        assertEquals(expect,result);
    }
    @Test
    public void should_13_oneTurnScore_spare(){
        String input="7/|3-";
        int expect=13;
        TenPinBowlingGame TenPinBowlingGame = new TenPinBowlingGame(input);
        int result = TenPinBowlingGame.oneTurnScore(0);
        assertEquals(expect,result);
    }
    @Test
    public void should_10_oneTurnScore_spare(){
        String input="7/|-3";
        int expect=10;
        TenPinBowlingGame TenPinBowlingGame = new TenPinBowlingGame(input);
        int result = TenPinBowlingGame.oneTurnScore(0);
        assertEquals(expect,result);
    }

    @Test
    public void should_19_oneTurnScore_strike(){
        String input="X|81";
        int expect=19;
        TenPinBowlingGame TenPinBowlingGame = new TenPinBowlingGame(input);
        int result = TenPinBowlingGame.oneTurnScore(0);
        assertEquals(expect,result);
    }
    @Test
    public void should_23_oneTurnScore_strike(){
        String input="X|X|35";
        int expect=23;
        TenPinBowlingGame TenPinBowlingGame = new TenPinBowlingGame(input);
        int result = TenPinBowlingGame.oneTurnScore(0);
        assertEquals(expect,result);
    }

    @Test
    public void should_90_oneGameScore_allMiss(){
        String input="9-|9-|9-|9-|9-|9-|9-|9-|9-|9-||";
        int expect=90;
        TenPinBowlingGame TenPinBowlingGame = new TenPinBowlingGame(input);
        int result = TenPinBowlingGame.score();
        assertEquals(expect,result);
    }
    @Test
    public void should_150_oneGameScore_allSpare(){
        String input="5/|5/|5/|5/|5/|5/|5/|5/|5/|5/||5";
        int expect=150;
        TenPinBowlingGame TenPinBowlingGame = new TenPinBowlingGame(input);
        int result = TenPinBowlingGame.score();
        assertEquals(expect,result);
    }
    @Test
    public void should_300_oneGameScore_allStrike(){
        String input="X|X|X|X|X|X|X|X|X|X||XX";
        int expect=300;
        TenPinBowlingGame TenPinBowlingGame = new TenPinBowlingGame(input);
        int result = TenPinBowlingGame.score();
        assertEquals(expect,result);
    }

    @Test
    public void should_167_oneGameScore_MixScore(){
        String input="X|7/|9-|X|-8|8/|-6|X|X|X||81";
        int expect=167;
        TenPinBowlingGame TenPinBowlingGame = new TenPinBowlingGame(input);
        int result = TenPinBowlingGame.score();
        assertEquals(expect,result);
    }

}
