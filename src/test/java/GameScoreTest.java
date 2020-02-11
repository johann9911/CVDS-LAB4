import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import hangman.model.*;

public class GameScoreTest {
	private OriginalScore c =  new OriginalScore();
	private BonusScore c2 =  new BonusScore();
	private PowerScore c3 =  new PowerScore();
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
	public void DeberialanzarExcepcionOriginalScore(){
		try {
			c.CalculateScore(-1, 0);
			fail("No se genero excepcion");
		}catch(GameException ec) {
			assertEquals(ec.getMessage(),GameException.numeroInvalido);
		}
		try {
			c.CalculateScore(0, -1);
			fail("No se genero excepcion");
		}catch(GameException ec) {
			assertEquals(ec.getMessage(),GameException.numeroInvalido);
		}
		try {
			c.CalculateScore(-1, -1);
			fail("No se genero excepcion");
		}catch(GameException ec) {
			assertEquals(ec.getMessage(),GameException.numeroInvalido);
		}
	}
	
	@Test
	public void NoDeberiaLanzarExcepcionOriginalScore(){
		try {
			assertEquals(c.CalculateScore(0, 0),100);
			assertEquals(c.CalculateScore(1, 0),100);
			assertEquals(c.CalculateScore(0, 1),90);
		}catch(GameException ec) {
			fail("Se genero excepcion");
		}
		
	}
	
	@Test
	public void DeberiaRetornarResultadoNormalOriginalScore() throws GameException{
		assertEquals(c.CalculateScore(0, 0),100);
		assertEquals(c.CalculateScore(0, 1),90);
		assertEquals(c.CalculateScore(0, 9),10);
		assertEquals(c.CalculateScore(0, 10),0);
		assertEquals(c.CalculateScore(5, 0),100);
		assertEquals(c.CalculateScore(0, 9),10);
	}
	
	@Test
	public void DeberiaRetornarCeroAlSobrepasarLaFormula() throws GameException{
		assertEquals(c.CalculateScore(0, 11),0);
		assertEquals(c.CalculateScore(0, 12),0);
		assertEquals(c.CalculateScore(0, 23),0);
	}
	
	@Test
	public void DeberialanzarExcepcionBonusScore(){
		try {
			c2.CalculateScore(-1, 0);
			fail("No se genero excepcion");
		}catch(GameException ec) {
			assertEquals(ec.getMessage(),GameException.numeroInvalido);
		}
		try {
			c2.CalculateScore(0, -1);
			fail("No se genero excepcion");
		}catch(GameException ec) {
			assertEquals(ec.getMessage(),GameException.numeroInvalido);
		}
		try {
			c2.CalculateScore(-1, -1);
			fail("No se genero excepcion");
		}catch(GameException ec) {
			assertEquals(ec.getMessage(),GameException.numeroInvalido);
		}
	}
	
	@Test
	public void NoDeberiaLanzarExcepcionBonusScore(){
		try {
			assertEquals(c2.CalculateScore(0, 0),0);
			assertEquals(c2.CalculateScore(1, 0),10);
			assertEquals(c2.CalculateScore(0, 1),0);
		}catch(GameException ec) {
			fail("Se genero excepcion");
		}
	}
	
	@Test
	public void DeberiaRetornarResultadoNormalBonusScore() throws GameException{
		assertEquals(c2.CalculateScore(0, 1),0);
		assertEquals(c2.CalculateScore(0, 2),0);
		assertEquals(c2.CalculateScore(0, 10),0);
	}
	
	@Test
	public void DeberiaRetornarResultadoNormalSiguiendoFormulaBonusScore() throws GameException{
		assertEquals(c2.CalculateScore(0, 0),0);
		assertEquals(c2.CalculateScore(1, 0),10);
		assertEquals(c2.CalculateScore(1, 1),5);
		assertEquals(c2.CalculateScore(4, 2),30);
	}
	
	@Test
	public void DeberialanzarExcepcionPowerBonusScore(){
		try {
			c3.CalculateScore(-1, 0);
			fail("No se genero excepcion");
		}catch(GameException ec) {
			assertEquals(ec.getMessage(),GameException.numeroInvalido);
		}
		try {
			c3.CalculateScore(0, -1);
			fail("No se genero excepcion");
		}catch(GameException ec) {
			assertEquals(ec.getMessage(),GameException.numeroInvalido);
		}
		try {
			c3.CalculateScore(-1, -1);
			fail("No se genero excepcion");
		}catch(GameException ec) {
			assertEquals(ec.getMessage(),GameException.numeroInvalido);
		}
	}
	
	@Test
	public void NoDeberiaLanzarExcepcionPowerBonusScore(){
		try {
			assertEquals(c3.CalculateScore(0, 0),0);
			assertEquals(c3.CalculateScore(1, 0),5);
			assertEquals(c3.CalculateScore(0, 1),0);
		}catch(GameException ec) {
			fail("Se genero excepcion");
		}
	}
	
	
	@Test
	public void DeberiaRetornarResultadoNormalConIesimoIntentoPowerBonusScore() throws GameException{
		assertEquals(c3.CalculateScore(0, 0),0);
		assertEquals(c3.CalculateScore(1, 0),5);
		assertEquals(c3.CalculateScore(4, 0),500);
		assertEquals(c3.CalculateScore(3, 0),125);
	}
	
	@Test
	public void DeberiaRetornarResultadoNormalSuperandoIntentosFallidosPowerScore() throws GameException{
		assertEquals(c3.CalculateScore(0, 0),0);
		assertEquals(c3.CalculateScore(0, 1),0);
		assertEquals(c3.CalculateScore(0, 2),0);
		assertEquals(c3.CalculateScore(0, 20),0);
	}
	
	@Test
	public void DeberiaRetornarResultadoNormalSiguiendoFormulaPowerScore() throws GameException{
		assertEquals(c3.CalculateScore(1, 1),0);
		assertEquals(c3.CalculateScore(2, 1),17);
		assertEquals(c3.CalculateScore(5, 5),500);
	}
}
