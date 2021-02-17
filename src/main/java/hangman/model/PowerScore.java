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

    @Override
    public int calculateScore(int correctCount, int incorrectCount) {
        // TODO Auto-generated method stub
        return 0;
    }
    
}
