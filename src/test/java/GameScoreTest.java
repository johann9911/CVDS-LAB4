import org.junit.Test;
import hangman.model.GameScore;

public class GameScoreTest {
	
	/* OriginalScore:
	 * 1. Digite valores invalidos, lance excepcion
	 * 2. Juego retorne un resultado normal, se comporte por medio de la formula, 100-10*letras_Incorrectas>=0, siempre y cuando las letras_Incorrectas<=10
	 * 3. Todo resultado, que sobrepase la condicion de la formula de letras incorrectas deberia retornar 0
	 * 
	 * Condiciones de frontera
	 * 1. Valido -->  correctas=0 , incorrectas=0
	 * 				  correctas=1 , incorrectas=0
	 * 			 	  correctas=0 , incorrectas=1
	 *    Invalidas-->correctas=-1 , incorrectas=0	 
	 *  		      correctas=0 , incorrectas=-1
	 *  		      correctas=-1 , incorrectas=-1  			  
	 *
	 * 2.correctas=0 , incorrectas=0 ,Resultado 100 
	 *   correctas=0 , incorrectas=1 ,Resultado 90 
	 *   correctas=0 , incorrectas=9 ,Resultado 10 
	 *   correctas=0 , incorrectas=10 ,Resultado 0 
	 *   correctas=5 , incorrectas=0 ,Resultado 100 
	 *   correctas=5 , incorrectas=9 ,Resultado 10  
	 *   
	 * 3. correctas=0 , incorrectas=11 ,Resultado 0 
	 * 	  correctas=0 , incorrectas=12 ,Resultado 0
	 * 	  correctas=0 , incorrectas=23 ,Resultado 0  
	 * 
	 * BonusScore:
	 * 1. Digite valores invalidos, lance excepcion.
	 * 3. Juego retorne un resultado normal,cada que supere el numero de incorrectas puntaje-5*letras_Incorrectas=0
	 * 4. Juego retorne un resultado normal, por medio de la formula, 10*letra_Correcta-5*letras_Incorrectas>=0
	 * 
	 * Condiciones de frontera
	 * 1. Valido -->  correctas=0 , incorrectas=0
	 * 				  correctas=1 , incorrectas=0
	 * 			 	  correctas=0 , incorrectas=1
	 *    Invalidas-->correctas=-1 , incorrectas=0	 
	 *  		      correctas=0 , incorrectas=-1
	 *  		      correctas=-1 , incorrectas=-1  			  
	 *
	 * 2.correctas=0 , incorrectas=1 ,Resultado 0 
	 *   correctas=0 , incorrectas=2 ,Resultado 0 
	 *   correctas=0 , incorrectas=10 ,Resultado 0 
	 * 
	 * 3.correctas=0 , incorrectas=0 ,Resultado 0 
	 *   correctas=1 , incorrectas=0 ,Resultado 10 
	 *   correctas=1 , incorrectas=1 ,Resultado 5
	 *   correctas=4 , incorrectas=2 ,Resultado 30 
	 * 
	 * PowerBonusScore:
	 * 1. Digite valores invalidos, lance excepcion
	 * 2. Juego retorne un resultado normal,donde la i-ésima intento correcto se comporte como 500<=5^i
	 * 3. Juego retorne un resultado normal,cada que supere el numero de incorrectas puntaje-8*letras_Incorrectas=0
	 * 4. Juego retorne un resultado normal, por medio de la formula, 500-(5^i letra_Correcta)+(5*letras_Incorrectas)>=0
	 * 
	 * Condiciones de frontera
	 * 
	 * 1. Valido -->  correctas=0 , incorrectas=0
	 * 				  correctas=1 , incorrectas=0
	 * 			 	  correctas=0 , incorrectas=1
	 *    Invalidas-->correctas=-1 , incorrectas=0	 
	 *  		      correctas=0 , incorrectas=-1
	 *  		      correctas=-1 , incorrectas=-1  			  
	 *
	 * 2.correctas=0 , incorrectas=0 ,Resultado 0
	 *   correctas=1 , incorrectas=0 ,Resultado 5 
	 *   correctas=4 , incorrectas=0 ,Resultado 500
	 *   correctas=3 , incorrectas=0 ,Resultado 125
	 * 
	 * 3.correctas=0 , incorrectas=0 ,Resultado 0 
	 *   correctas=0 , incorrectas=1 ,Resultado 0 
	 *   correctas=0 , incorrectas=2 ,Resultado 0
	 *   correctas=0 , incorrectas=20 ,Resultado 0
	 * 4.correctas=1 , incorrectas=1 ,Resultado 0 
	 *   correctas=2 , incorrectas=1 ,Resultado 17 
	 *   correctas=5 , incorrectas=5 ,Resultado 500
	 *   
	 * 
	 */	
	
	@Test
	public void DeberialanzarExcepcion(){
		
	}
	
}
