import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BowlingGameTest {


//    @Test
//    public void startGame() {
//
//    }

    @Test
    public void testBowlingGame_firstThrow4_resultIs4(){
        BowlingGame bowlingGame = BowlingGame.startGame();

        bowlingGame.throwBall(4);
        assertEquals(4, bowlingGame.curreentScore());
    }

    @Test
    public void testBowlingGame_firstThrow10_movedToNextFrame(){
        BowlingGame bowlingGame = BowlingGame.startGame();
        bowlingGame.throwBall(10);
        bowlingGame.throwBall(10);
        bowlingGame.throwBall(10);
        bowlingGame.throwBall(10);
        bowlingGame.throwBall(10);
        bowlingGame.throwBall(10);
        bowlingGame.throwBall(10);
        bowlingGame.throwBall(10);
        bowlingGame.throwBall(10);
        bowlingGame.throwBall(10);
        assertEquals(11, bowlingGame.currentFrame());
    }

    @Test
    public void testBowlingGame_twoThrows_movedToNextFrame(){
        BowlingGame bowlingGame = BowlingGame.startGame();

        bowlingGame.throwBall(3);
        bowlingGame.throwBall(4);
        bowlingGame.throwBall(4);
        bowlingGame.throwBall(4);
        assertEquals(3, bowlingGame.currentFrame());
    }

    @Test
    public void testBowlingGame_firstThrow10_resultAfterAreDuplicated(){
        BowlingGame bowlingGame = BowlingGame.startGame();
        bowlingGame.throwBall(10);
        bowlingGame.throwBall(10);
        bowlingGame.throwBall(3);
        bowlingGame.throwBall(3);
        assertEquals(4, bowlingGame.currentFrame());
        assertEquals(56, bowlingGame.curreentScore());
    }
}