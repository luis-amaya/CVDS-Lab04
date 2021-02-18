package hangman.model;
/**
 * GameScore's exception class
 * @author Luis Amaya
 * @author Sebastina Mina
 * @version 1.0 17/02/2021
 */
public class GameScoreException extends Exception{
    public static final String SCORE_NEGATIVE = "Score value is negative";
    public static final String INVALID_VALUE = "The value is not valid";

    public GameScoreException(String message){
        super(message);
    }
}
