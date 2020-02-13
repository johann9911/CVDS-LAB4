package hangman.model;

public class BonusScore implements GameScore {
	private int puntaje;
	private final int penalizacion=5;
	private final int bonificacion=10;
	
	/**
	 * Contructor para objetos de tipo BonusScore
	 */
	public BonusScore() {
		puntaje=0;
	}
	/**
	 * Calcular El puntaje de un juego
	 * @pre puntaje=0
	 * @post puntaje >0
	 * @param correctCount Letras correctas
	 * @param incorrectCount Letras Incorrectas
	 * @throws GameException [correctCount<0;incorrectCount<0]
	 * @return
	 */
	public int calculateScore(int correctCount, int incorrectCount ) throws GameException {
		if(correctCount<0 || incorrectCount<0) throw new GameException(GameException.numeroInvalido);
		puntaje=puntaje-(incorrectCount*penalizacion)+(correctCount*bonificacion);
		if(puntaje<0)puntaje=0;
		return puntaje;
	}
	
	public int reiniciarPuntaje() {
		puntaje=0;
		return puntaje;
	}
}
