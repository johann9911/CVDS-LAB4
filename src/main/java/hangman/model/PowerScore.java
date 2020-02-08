package hangman.model;

public class PowerScore implements GameScore {
		
	
		/**
		 * Calcular El puntaje de un juego
		 * @pre puntaje=0
		 * @post puntaje >0
		 * @param correctCount Letras correctas
		 * @param incorrectCount Letras Incorrectas
	 	 * @throws GameException [correctCount<0;incorrectCount<0]
		 * @return
		 */
		public int CalculateScore(int correctCount, int incorrectCount ) throws GameException {
			if(correctCount<0 || incorrectCount<0) throw new GameException(GameException.numeroInvalido);
			return 0;
		}
		
}
