package hangman.model;

public interface GameScore {
	
	public abstract int calculateScore(int correctCount, int incorrectCount ) throws GameException;
	public abstract void reiniciarPuntaje();
}
