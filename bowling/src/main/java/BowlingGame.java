import java.util.ArrayList;
import java.util.List;

public class BowlingGame {

    private boolean multiply = false;
    private int multiplyTimes=0;
    private int currentFrame;
    private int throwNumber;
    private int currentScore;
    //    private List<Frame> frameScores;
    private int[] scores;

    private BowlingGame() {
        currentFrame = 0;
        currentScore = 0;
        scores = new int[21];
        throwNumber = 1;
    }

    public static BowlingGame startGame() {
        return new BowlingGame();
    }

    public void throwBall(int score) {
        int multipliedScore = score;
        if (multiply){
            multipliedScore+=10;
            multiplyTimes--;
            if(multiplyTimes==0){
                multiply = false;
            }
        }
        scores[throwNumber - 1] = multipliedScore;
        if (score == 10) {
            multiply = true;
            multiplyTimes += 2;
            currentFrame++;
            throwNumber += 2;
        } else {
            if (throwNumber % 2 == 0) {
                currentFrame++;
            }
            throwNumber++;
        }
        this.currentScore += multipliedScore;

    }

    public int curreentScore() {
        return this.currentScore;
    }

    public int currentFrame() {
        return currentFrame + 1;
    }

    public void printResults() {

    }

//
//    private static class Frame {
//        private Integer firstThrow;
//        private Integer secondThrow;
//    }

}