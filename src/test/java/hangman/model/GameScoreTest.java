package hangman.model;

import org.junit.Assert;
import org.junit.Test;

import hangman.model.GameScore;
import hangman.model.GameScoreException;
import hangman.model.BonusScore;
import hangman.model.OriginalScore;
import hangman.model.PowerScore;

/**
 * GameScore's test class
 * @author Luis Amaya
 * @author Sebastian Mina
 * @version 1.0 17/02/2021
 * 
 */
public class GameScoreTest{

    @Test
    public void OriginalScoreCorrect(){
        try {
            
        } catch (Exception e) {
            Assert.assertEquals(GameScoreException.SCORE_NEGATIVE, e.getMessage());
        }
    }
}