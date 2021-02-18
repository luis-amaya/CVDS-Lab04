package hangman.model;

import org.junit.Assert;
import org.junit.Before;
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
 * -_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-
 * ORIGINAL SCORE
 * 
 * #           |         Clase Equivalencia                                                        |    Resultado
 * -_-_-_-_-_-_|_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_|_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-
 * 1.          |         correctCount >= 0 && incorrectCount > 10                                  |    0
 * 2.          |         correctCount >= 0 && incorrectCount <= 10                                 |    100 - (incorrectCount * 10) 
 * 3.          |         incorrectCount < 0                                                        |    Incorrect
 * 4.          |         correctCount < 0                                                          |    Incorrect
 * 
 * BORDER CASES
 * 
 * #           |         Clase Equivalencia                                                        |    Resultado
 * -_-_-_-_-_-_|_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_|_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-
 * 1.          |         correctCount = 0 && incorrectCount = 12                                   |    0
 * 2.          |         correctCount = 2 && incorrectCount = 1                                    |    90
 * 3.          |         incorrectCount = -1                                                       |    Incorrect
 * 4.          |         correctCount = -1                                                         |    Incorrect
 * 
 * 
 * 
 * 
 * -_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-
 * BONUS SCORE
 * 
 * #           |         Clase Equivalencia                                                        |    Resultado
 * -_-_-_-_-_-_|_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_|_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-
 * 1.          |         correctCount >= 2*incorrectCount && incorrectCount > 0                    |    (10*correctCount) - (5*incorrectCount)
 * 2.          |         0 <= correctCount < 2*incorrectCount && incorrectCount >= 1               |    0
 * 3.          |         incorrectCount < 0                                                        |    Incorrect
 * 4.          |         correctCount < 0                                                          |    Incorrect
 * 
 * BORDER CASES
 * 
 * #           |         Clase Equivalencia                                                        |    Resultado
 * -_-_-_-_-_-_|_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_|_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-
 * 1.          |         correctCount = 2 && incorrectCount = 1                                    |    15
 * 2.          |         correctCount = 1 && incorrectCount = 2                                    |    0
 * 3.          |         incorrectCount = -1                                                       |    Incorrect
 * 4.          |         correctCount = -1                                                         |    Incorrect
 * 
 * 
 * 
 * -_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-
 * POWER SCORE
 * #           |         Clase Equivalencia                                                        |    Resultado
 * -_-_-_-_-_-_|_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_|_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-
 * 1.          |         correctCount >= 0 && incorrectCount > 10               |    0
 * 2.          |         correctCount >= 0 && incorrectCount <= 10              |    100 - (incorrectCount * 10) 
 * 3.          |         incorrectCount < 0                                     |    Incorrect
 * 4.          |         correctCount < 0                                       |    Incorrect
 * 
 * 
 * 
 * 
 *  * BORDER CASES
 * 
 * #           |         Clase Equivalencia                                                        |    Resultado
 * -_-_-_-_-_-_|_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_|_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-
 * 1.          |         correctCount = 0 && incorrectCount = 12                                   |    0
 * 2.          |         correctCount = 2 && incorrectCount = 1                                    |    90
 * 3.          |         incorrectCount = -1                                                       |    Incorrect
 * 4.          |         correctCount = -1                                                         |    Incorrect
 * 
 */

public class GameScoreTest{

    private GameScore score;

    private GameScore scoreToUse(char score){
        if(score == 'o' || score == 'O'){
            this.score = new OriginalScore();
        }
        else if(score == 'b' || score == 'B'){
            this.score = new BonusScore();
        }
        else if(score == 'p' || score == 'P'){
            this.score = new PowerScore();
        }
        return this.score;
    }

    //ORIGINAL SCORE 1
    @Test
    public void originalScoreValidCorrectCountNIncorrectCountWithResultZero(){
        try {
            score = scoreToUse('o');
            Assert.assertEquals(0, score.calculateScore(0, 12));
        } catch (Exception e) {
            Assert.fail("An exception occurred");
        }
    }

    //ORIGINAL SCORE 2
    @Test
    public void originalScoreValidCorrectCountNIncorrectCountWithResultHigherThanZero(){
        try {
            score = scoreToUse('o');
            Assert.assertEquals(90, score.calculateScore(2, 1));
        } catch (Exception e) {
            Assert.fail("An exception occurred");
        }
    }

    //ORIGINAL SCORE 3
    @Test
    public void wrongCorrectCountNumber(){
        try {
            score = scoreToUse('o');
            score.calculateScore(-1, 2);
            Assert.fail("Should've throwed an exception");
        } catch (Exception e) {
            Assert.assertEquals(GameScoreException.INVALID_VALUE, e.getMessage());
        }
    }
    //ORIGINAL SCORE 4
    @Test
    public void wrongIncorrectCountNumber(){
        try {
            score = scoreToUse('o');
            score.calculateScore(2, -1);
            Assert.fail("Should've throwed an exception");
        } catch (Exception e) {
            //TODO: handle exception
        }
    }
    //ORIGINAL SCORE BORDER 1
    @Test
    public void validateOriginalScoreBorderWithResultZero(){
        try {
            score = scoreToUse('o');
            Assert.assertEquals(0, score.calculateScore(0, 12));
        } catch (Exception e) {
            Assert.fail("An exception occurred");
        }
    }
    //ORIGINAL SOCRE BORDER 2
    @Test
    public void validateOriginalScoreBorderWithResultHigherThanZero(){
        try {
            score = scoreToUse('o');
            Assert.assertEquals(90, score.calculateScore(2, 1));
        } catch (Exception e) {
            Assert.fail("An exception occurred");
        }
    }
    //ORIGINAL SCORE BORDER 3
    @Test
    public void validateOriginalScoreborderWithIncorrectCountLessThanZero(){
        try {
            score = scoreToUse('o');
            score.calculateScore(2, -1);
            Assert.fail("Should've throwed an exception");
        } catch (Exception e) {
            Assert.assertEquals(GameScoreException.INVALID_VALUE, e.getMessage());
        }
    }
    //ORIGINAL SCORE BORDER 4
    @Test
    public void validateOriginalScoreBorderWithCorrectCountLessThanZero(){
        try {
            score = scoreToUse('o');
            score.calculateScore(-1, 2);
            Assert.fail("Should've throwed an exception");
        } catch (Exception e) {
            Assert.assertEquals(GameScoreException.INVALID_VALUE, e.getMessage());
        }
    }


    //BONUS SCORE 1

    //BONUS SCORE 2

    //BONUS SCORE 3

    //BONUS SCORE 4

    //BONUS SCORE BORDER 1

    //BONUS SCORE BORDER 2

    //BONUS SOCRE BORDER 3

    //BONUS SOCRE BORDER 4
}