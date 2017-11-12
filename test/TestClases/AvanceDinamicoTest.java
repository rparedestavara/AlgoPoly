package TestClases;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Random;

import Clases.AvanceDinamico;
import Clases.Jugador;
import Clases.Tablero;

public class AvanceDinamicoTest {

	@Test
	public void test01EntrarEnAvanceDinamicoConRango2a6AvanzaLaCantidadCorrecta() {
		Jugador jugador = new Jugador();
		ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
		jugadores.add(jugador);
		Tablero tablero = new Tablero(jugadores);
		AvanceDinamico avanceDinamico = new AvanceDinamico();
		
		int posicionInicial = tablero.getPosicion(jugador);
		Random dados = new Random();
		int resultadoDados = 2 + dados.nextInt(5); //genera un numero aleatorio entre 1 y 6 simulando los dados
		jugador.setResultadoDados(resultadoDados);
		jugador.setTablero(tablero);
		avanceDinamico.entrar(jugador);
		int posicionFinal = tablero.getPosicion(jugador);
		
		Assert.assertEquals((resultadoDados-2),(posicionFinal - posicionInicial));
	}

	@Test
	public void test02EntrarEnAvanceDinamicoConRango7a10AvanzaLaCantidadCorrecta() {
		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();
		ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
		jugadores.add(jugador1);
		jugadores.add(jugador2);
		Tablero tablero = new Tablero(jugadores);
		AvanceDinamico avanceDinamico = new AvanceDinamico();
		Random dados = new Random();
		int resultadoDados = 7 + dados.nextInt(4);  //numero aleatorio entre 7 y 10
		jugador1.setResultadoDados(resultadoDados);
		jugador1.setTablero(tablero);
		avanceDinamico.entrar(jugador1);
		tablero.mover(jugador2, jugador1.getDinero() % resultadoDados);
		Assert.assertEquals(tablero.getPosicion(jugador1), tablero.getPosicion(jugador2));
	}	
	
	
}
