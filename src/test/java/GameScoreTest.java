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
	 * 2. Juego retorne un resultado normal,donde la i-�sima intento correcto se comporte como 500<=5^i
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
			c.calculateScore(-1, 0);
			c.reiniciarPuntaje();
			fail("No se genero excepcion");
		}catch(GameException ec) {
			assertEquals(ec.getMessage(),GameException.numeroInvalido);
		}
		try {
			c.calculateScore(0, -1);
			c.reiniciarPuntaje();
			fail("No se genero excepcion");
		}catch(GameException ec) {
			assertEquals(ec.getMessage(),GameException.numeroInvalido);
		}
		try {
			c.calculateScore(-1, -1);
			c.reiniciarPuntaje();
			fail("No se genero excepcion");
		}catch(GameException ec) {
			assertEquals(ec.getMessage(),GameException.numeroInvalido);
		}
	}
	
	@Test
	public void NoDeberiaLanzarExcepcionOriginalScore(){
		try {
			assertEquals(c.calculateScore(0, 0),100);
			c.reiniciarPuntaje();
			assertEquals(c.calculateScore(1, 0),100);
			c.reiniciarPuntaje();
			assertEquals(c.calculateScore(0, 1),90);
			c.reiniciarPuntaje();
		}catch(GameException ec) {
			fail("Se genero excepcion");
		}
		
	}
	
	@Test
	public void DeberiaRetornarResultadoNormalOriginalScore() throws GameException{
		assertEquals(c.calculateScore(0, 0),100);
		c.reiniciarPuntaje();
		assertEquals(c.calculateScore(0, 1),90);
		c.reiniciarPuntaje();
		assertEquals(c.calculateScore(0, 9),10);
		c.reiniciarPuntaje();
		assertEquals(c.calculateScore(0, 10),0);
		c.reiniciarPuntaje();
		assertEquals(c.calculateScore(5, 0),100);
		c.reiniciarPuntaje();
		assertEquals(c.calculateScore(0, 9),10);
		c.reiniciarPuntaje();
	}
	
	@Test
	public void DeberiaRetornarCeroAlSobrepasarLaFormula() throws GameException{
		assertEquals(c.calculateScore(0, 11),0);
		c.reiniciarPuntaje();
		assertEquals(c.calculateScore(0, 12),0);
		c.reiniciarPuntaje();
		assertEquals(c.calculateScore(0, 23),0);
		c.reiniciarPuntaje();
	}
	
	@Test
	public void DeberialanzarExcepcionBonusScore(){
		try {
			c2.calculateScore(-1, 0);
			c2.reiniciarPuntaje();
			fail("No se genero excepcion");
		}catch(GameException ec) {
			assertEquals(ec.getMessage(),GameException.numeroInvalido);
		}
		try {
			c2.calculateScore(0, -1);
			c2.reiniciarPuntaje();
			fail("No se genero excepcion");
		}catch(GameException ec) {
			assertEquals(ec.getMessage(),GameException.numeroInvalido);
		}
		try {
			c2.calculateScore(-1, -1);
			c2.reiniciarPuntaje();
			fail("No se genero excepcion");
		}catch(GameException ec) {
			assertEquals(ec.getMessage(),GameException.numeroInvalido);
		}
	}
	
	@Test
	public void NoDeberiaLanzarExcepcionBonusScore(){
		try {
			assertEquals(c2.calculateScore(0, 0),0);
			c2.reiniciarPuntaje();
			assertEquals(c2.calculateScore(1, 0),10);
			c2.reiniciarPuntaje();
			System.out.println(c2.calculateScore(0, 1));
			c2.reiniciarPuntaje();
			assertEquals(c2.calculateScore(0, 1),0);
			c2.reiniciarPuntaje();
		}catch(GameException ec) {
			fail("Se genero excepcion");
		}
	}
	
	@Test
	public void DeberiaRetornarResultadoNormalBonusScore() throws GameException{
		assertEquals(c2.calculateScore(0, 1),0);
		c2.reiniciarPuntaje();
		assertEquals(c2.calculateScore(0, 2),0);
		c2.reiniciarPuntaje();
		assertEquals(c2.calculateScore(0, 10),0);
		c2.reiniciarPuntaje();
	}
	
	@Test
	public void DeberiaRetornarResultadoNormalSiguiendoFormulaBonusScore() throws GameException{
		assertEquals(c2.calculateScore(0, 0),0);
		c2.reiniciarPuntaje();
		assertEquals(c2.calculateScore(1, 0),10);
		c2.reiniciarPuntaje();
		assertEquals(c2.calculateScore(1, 1),5);
		c2.reiniciarPuntaje();
		assertEquals(c2.calculateScore(4, 2),30);
		c2.reiniciarPuntaje();
	}
	
	@Test
	public void DeberialanzarExcepcionPowerBonusScore(){
		try {
			c3.calculateScore(-1, 0);
			c3.reiniciarPuntaje();
			fail("No se genero excepcion");
		}catch(GameException ec) {
			assertEquals(ec.getMessage(),GameException.numeroInvalido);
		}
		try {
			c3.calculateScore(0, -1);
			c3.reiniciarPuntaje();
			fail("No se genero excepcion");
		}catch(GameException ec) {
			assertEquals(ec.getMessage(),GameException.numeroInvalido);
		}
		try {
			c3.calculateScore(-1, -1);
			c3.reiniciarPuntaje();
			fail("No se genero excepcion");
		}catch(GameException ec) {
			assertEquals(ec.getMessage(),GameException.numeroInvalido);
		}
	}
	
	@Test
	public void NoDeberiaLanzarExcepcionPowerBonusScore(){
		try {
			assertEquals(c3.calculateScore(0, 0),0);
			c3.reiniciarPuntaje();
			assertEquals(c3.calculateScore(1, 0),5);
			c3.reiniciarPuntaje();
			assertEquals(c3.calculateScore(0, 1),0);
			c3.reiniciarPuntaje();
		}catch(GameException ec) {
			fail("Se genero excepcion");
		}
	}
	
	
	@Test
	public void DeberiaRetornarResultadoNormalConIesimoIntentoPowerBonusScore() throws GameException{
		assertEquals(c3.calculateScore(0, 0),0);
		c3.reiniciarPuntaje();
		assertEquals(c3.calculateScore(1, 0),5);
		c3.reiniciarPuntaje();
		assertEquals(c3.calculateScore(4, 0),500);
		c3.reiniciarPuntaje();
		assertEquals(c3.calculateScore(3, 0),125);
		c3.reiniciarPuntaje();
	}
	
	@Test
	public void DeberiaRetornarResultadoNormalSuperandoIntentosFallidosPowerScore() throws GameException{
		assertEquals(c3.calculateScore(0, 0),0);
		c3.reiniciarPuntaje();
		assertEquals(c3.calculateScore(0, 1),0);
		c3.reiniciarPuntaje();
		assertEquals(c3.calculateScore(0, 2),0);
		c3.reiniciarPuntaje();
		assertEquals(c3.calculateScore(0, 20),0);
		c3.reiniciarPuntaje();
	}
	
	@Test
	public void DeberiaRetornarResultadoNormalSiguiendoFormulaPowerScore() throws GameException{
		assertEquals(c3.calculateScore(1, 1),0);
		c3.reiniciarPuntaje();
		assertEquals(c3.calculateScore(2, 1),17);
		c3.reiniciarPuntaje();
		assertEquals(c3.calculateScore(5, 5),500);
		c3.reiniciarPuntaje();
	}
}
