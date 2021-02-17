package hangman.model;
/**
 * Interface to calculate hangman's score
 * @author Luis Amaya
 * @author Sebastian Mina
 * @version 1.0 17/02/2021
 */
public interface GameScore {

    /**
     * Calculates the score for the current playing session
     * @pre true
     * @pos Game score calculated.
     * @param correctCount, int  that indicates player's correct attempts.
     * @param incorrectCount, int that indicates player's incorrect attempts.
     * @return int With the score calculateed.
     * @throws GameScoreException 
     */
    public int calculateScore(int correctCount, int incorrectCount);
}
