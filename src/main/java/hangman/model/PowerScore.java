package hangman.model;
/**
 * Power Score scheme
 * 1. Game beigns with 0 points.
 * 2. I-th correct letter gets a 5^i score
 * 3. Every wrong letter gets a -8 points penalty.
 * 4. Minimun score is 0.
 * 5. If score is higher than 500, the score is 500 points.
 * @author Luis Amaya
 * @author Sebastina Mina
 * @version 1.0 17/02/2021
 */
public class PowerScore implements GameScore{
    private final int initialScore = 0;
    private final int bonusPoints = 5;
    private final int penaltyPoints = 8;
    private final int maxScore = 500;

    @Override
    public int calculateScore(int correctCount, int incorrectCount) throws GameScoreException {
        int score;
        if(correctCount < 0 || incorrectCount < 0){
            throw new GameScoreException(GameScoreException.INVALID_VALUE);
        }
        score = (int)Math.pow(bonusPoints, correctCount) - (penaltyPoints * incorrectCount);
        if(score > maxScore){
            score = maxScore;
        }else if(score < MINIMUNSCORE){
            score = MINIMUNSCORE;
        }
        return score;
    }
    
    public int getInitialScore(){
        return initialScore;
    }
}
