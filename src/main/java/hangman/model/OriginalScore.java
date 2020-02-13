package hangman.model;

public class OriginalScore implements GameScore {
	private int puntaje;
	private final int penalizacion=10;
	private final int bonificacion=0;
	
	/**
	 * Contructor para objetos de tipo OriginalScore
	 */
	public OriginalScore() {
		puntaje=100;
	}
	
	/**
	 * Calcular El puntaje de un juego
	 * @pre puntaje=100
	 * @post puntaje >0
	 * @param correctCount Letras correctas
	 * @param incorrectCount Letras Incorrectas
	 * @throws GameException  [correctCount<0;incorrectCount<0]
	 * @return
	 * 
	 */
	public int calculateScore(int correctCount, int incorrectCount ) throws GameException {
		if(correctCount<0 || incorrectCount<0) throw new GameException(GameException.numeroInvalido);
		puntaje=puntaje-(incorrectCount*penalizacion);
		if(puntaje<0) puntaje=0;
		return puntaje;
	}
	
	public int reiniciarPuntaje() {
		puntaje=100;
		return puntaje;
	}
}
