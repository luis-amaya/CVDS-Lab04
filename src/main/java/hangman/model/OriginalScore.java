package hangman.model;
/**
 * Original score scheme
 * 1. Game begins with 100 points
 * 2. Correct letters don't get a bonus
 * 3. Wrong letters gets a -10 points penalty
 * 4. Minimun score is 0.
 * @author Luis Amaya
 * @author Sebastian Mina
 * @version 1.0 17/02/2021
 */
public class OriginalScore implements GameScore{

    private final int initialScore = 100;
    private final int penaltyPoints = 10;
    

    @Override
    public int calculateScore(int correctCount, int incorrectCount) throws GameScoreException {
        int score;
        if(correctCount < 0 || incorrectCount < 0){
            throw new GameScoreException(GameScoreException.INVALID_VALUE);
        }
        score = initialScore - (penaltyPoints * incorrectCount);
        if(score < MINIMUNSCORE){
            score = 0;
        }
        return score;
    }
    
}
