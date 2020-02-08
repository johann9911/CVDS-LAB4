package hangman.model;

public class GameException extends Exception{
	public static String numeroInvalido="el valor digitado esta fuera de rango";
	
	public GameException(String msg) {
		super(msg);
	}
}
