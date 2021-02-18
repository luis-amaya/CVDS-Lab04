package hangman.model;

import static org.junit.Assert.assertEquals;

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
    public void originalScoreWrongCorrectCountNumber(){
        try {
            score = scoreToUse('o');
            score.calculateScore(-4, 2);
            Assert.fail("Should've throwed an exception");
        } catch (Exception e) {
            Assert.assertEquals(GameScoreException.INVALID_VALUE, e.getMessage());
        }
    }
    //ORIGINAL SCORE 4
    @Test
    public void originalScoreWrongIncorrectCountNumber(){
        try {
            score = scoreToUse('o');
            score.calculateScore(2, -4);
            Assert.fail("Should've throwed an exception");
        } catch (Exception e) {
            //TODO: handle exception
        }
    }
    //ORIGINAL SCORE BORDER 1
    @Test
    public void originalScoreBorderWithResultZero(){
        try {
            score = scoreToUse('o');
            Assert.assertEquals(0, score.calculateScore(0, 12));
        } catch (Exception e) {
            Assert.fail("An exception occurred");
        }
    }
    //ORIGINAL SOCRE BORDER 2
    @Test
    public void originalScoreBorderWithResultHigherThanZero(){
        try {
            score = scoreToUse('o');
            Assert.assertEquals(90, score.calculateScore(2, 1));
        } catch (Exception e) {
            Assert.fail("An exception occurred");
        }
    }
    //ORIGINAL SCORE BORDER 3
    @Test
    public void originalScoreBorderWithIncorrectCountLessThanZero(){
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
    public void originalScoreBorderWithCorrectCountLessThanZero(){
        try {
            score = scoreToUse('o');
            score.calculateScore(-1, 2);
            Assert.fail("Should've throwed an exception");
        } catch (Exception e) {
            Assert.assertEquals(GameScoreException.INVALID_VALUE, e.getMessage());
        }
    }


    //BONUS SCORE 1
    @Test 
    public void bonusScoreCorrectCountNIncorrectCountWithResultHigherThanZero(){
        try {
            score = scoreToUse('b');
            assertEquals(25, score.calculateScore(3, 1));
        } catch (Exception e) {
            Assert.fail("An exception occurred");
        }
    }
    //BONUS SCORE 2
    @Test
    public void bonusScoreCorrectCountNincorrectCountWithResultZero(){
        try {
            score = scoreToUse('b');
            assertEquals(0, score.calculateScore(0, 1));
        } catch (Exception e) {
            Assert.fail("An exception occurred");
        }
    }
    //BONUS SCORE 3
    @Test
    public void bonusScoreWrongCorrectCountNumber(){
        try {
            score = scoreToUse('b');
            score.calculateScore(-6, 2);
            Assert.fail("Should've throwed an exception");
        } catch (Exception e) {
            Assert.assertEquals(GameScoreException.INVALID_VALUE, e.getMessage());
        }
    }
    //BONUS SCORE 4
    @Test
    public void bonusScoreWrongIncorrectCountNumber(){
        try {
            score = scoreToUse('b');
            score.calculateScore(2, -8);
            Assert.fail("Should've throwed an exception");
        } catch (Exception e) {
            Assert.assertEquals(GameScoreException.INVALID_VALUE, e.getMessage());
        }
    }
    //BONUS SCORE BORDER 1
    @Test
    public void bonusScoreBorderWithResultHigherThanZero(){
        try {
            score = scoreToUse('b');
            Assert.assertEquals(15, score.calculateScore(2, 1));
        } catch (Exception e) {
            Assert.fail("An exception occurred");
        }
    }
    //BONUS SCORE BORDER 2
    @Test
    public void bonusScoreBorderWithResultEqualToZero(){
        try {
            score = scoreToUse('b');
            Assert.assertEquals(0, score.calculateScore(1, 2));
        } catch (Exception e) {
            Assert.fail("An exception occurred");
        }
    }
    //BONUS SOCRE BORDER 3
    @Test
    public void bonusScoreBorderWithIncorrectCountLessThanZero(){
        try {
            score = scoreToUse('b');
            score.calculateScore(2, -1);
            Assert.fail("Should've throwed an exception");
        } catch (Exception e) {
            Assert.assertEquals(GameScoreException.INVALID_VALUE, e.getMessage());
        }
    }
    //BONUS SOCRE BORDER 4
    @Test
    public void bonusScoreBorderWithCorrectCountLessThanZero(){
        try {
            score = scoreToUse('b');
            score.calculateScore(2, -1);
            Assert.fail("Should've throwed an exception");
        } catch (Exception e) {
            Assert.assertEquals(GameScoreException.INVALID_VALUE, e.getMessage());
        }
    }



    
    //POWER SCORE 1

    //POWER SCORE 2

    //POWER SCORE 3
    
    //POWER SCORE 4

    //POWER SCORE 5

    //POWER SCORE BORDER 1

    //POWER SCORE BORDER 2

    //POWER SCORE BORDER 3

    //POWER SCORE BORDER 4

    //POWER SCORE BORDER 5
}