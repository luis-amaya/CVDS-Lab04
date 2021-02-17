package hangman.model;

/**
 * Bonus score scheme.
 * 1. Game begins with 0 points.
 * 2. Correct letter gets a +10 points bonus.
 * 3. Wrong letters gets a -5 points penalty.
 * 4. Minimun score is 0.
 * @author Luis Amaya
 * @author Sebastian Mina
 * @version 1.1 17/02/2021
 */
public class BonusScore implements GameScore{

    @Override
    public int calculateScore(int correctCount, int incorrectCount) {
        // TODO Auto-generated method stub
        return 0;
    }
    
}
