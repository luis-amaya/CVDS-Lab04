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

    @Override
    public int calculateScore(int correctCount, int incorrectCount) {
        // TODO Auto-generated method stub
        return 0;
    }
    
}
